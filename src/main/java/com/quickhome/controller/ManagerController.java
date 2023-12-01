package com.quickhome.controller;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.*;
import com.quickhome.mapper.*;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.ManagerHomeBindingService;
import com.quickhome.service.ManagerService;
import com.quickhome.service.UserNotificationService;
import com.quickhome.util.CreatAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/23 14:21
 */
@Transactional
@Controller("ManagerCon")
@RequestMapping("/Manager")
public class ManagerController {
    //公钥与私钥
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerHomeBindingService managerHomeBindingService;
    @Autowired
    private SuperManagerMapper superManagerMapper;
    @Autowired
    private ManagerHomeBindingMapper bindingMapper;

    @Autowired
    private ManagerMapper managerMapper;

    @Autowired
    private UserNotificationService userNotificationService;

    @Autowired
    private UserNotificationMapper userNotificationMapper;

    @PostMapping("/insertManager")
    public ResponseEntity<ResponseResult<?>> insertManager(@RequestBody Manager manager) {
        // 生成唯一的 managerAccount
        String managerAccount;
        do {
            managerAccount = CreatAccount.creatManagerAccount();
        } while (isAccountExists(managerAccount));
        manager.setManagerAccount_zch_hwz_gjc(managerAccount);

        // 设置 managerInDate 字段的值
        ZonedDateTime now = ZonedDateTime.now(ZoneId.of("+8"));
        manager.setManagerInDate_zch_hwz_gjc(Date.from(now.toInstant()));

        RSA rsa = new RSA(privateKey, publicKey);
        byte[] decrypt = rsa.decrypt(manager.getManagerPwd_zch_hwz_gjc(), KeyType.PrivateKey);
        manager.setManagerPwd_zch_hwz_gjc(new String(decrypt));

        boolean success = managerMapper.insert(manager) > 0;
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
        }
    }

    @PostMapping("/updatePassword")
    public ResponseEntity<ResponseResult<?>> updatePassword(
            @RequestBody Map<String, String> request) {

        String managerIdStr = request.get("managerId");
        String encryptedPassword = request.get("managerPwd");

        if (managerIdStr == null || encryptedPassword == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("缺少必要的请求参数"));
        }

        Long managerId;
        try {
            managerId = Long.parseLong(managerIdStr);
        } catch (NumberFormatException e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("无效的managerId"));
        }

        // 解密密码
        RSA rsa = new RSA(privateKey, publicKey);
        try {
            byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPassword);  // 假设密文是Base64编码的
            byte[] decrypt = rsa.decrypt(encryptedBytes, KeyType.PrivateKey);
            String newPassword = new String(decrypt);

            // 从数据库中查询当前记录
            Manager currentManager = managerMapper.selectById(managerId);
            if (currentManager == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("managerId不存在"));
            }

            // 更新密码
            currentManager.setManagerPwd_zch_hwz_gjc(newPassword);

            // 使用乐观锁更新方法
            boolean success = managerMapper.updateById(currentManager) > 0;
            if (success) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("密码更新失败，请重试"));
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseResult.error("解密失败: " + e.getMessage()));
        }
    }

    @GetMapping("/getManager")
    public ResponseEntity<ResponseResult<?>> getManager(@RequestParam Long managerId) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("managerId_zch_hwz_gjc", managerId);
        Manager manager = managerMapper.selectOne(queryWrapper);

        if (manager == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("没有找到指定的管理员"));
        }

        // 加密密码
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encryptedPasswordBytes = rsa.encrypt(manager.getManagerPwd_zch_hwz_gjc().getBytes(), KeyType.PublicKey);
        String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes);
        manager.setManagerPwd_zch_hwz_gjc(encryptedPassword);

        return ResponseEntity.ok(ResponseResult.ok(manager));
    }

    @GetMapping("/getAllManager")
    public ResponseEntity<ResponseResult<?>> getAllManager(
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {

        // 创建 Page 对象
        Page<Manager> page = new Page<>(pageNo, pageSize);

        // 执行分页查询
        IPage<Manager> managerPage = managerMapper.selectPage(page, null);

        // 创建 RSA 对象
        RSA rsa = new RSA(privateKey, publicKey);

        // 遍历管理员列表并加密每个管理员的密码
        List<Manager> managers = managerPage.getRecords();
        for (Manager manager : managers) {
            byte[] encryptedPasswordBytes = rsa.encrypt(manager.getManagerPwd_zch_hwz_gjc().getBytes(), KeyType.PublicKey);
            String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes);
            manager.setManagerPwd_zch_hwz_gjc(encryptedPassword);
        }

        return ResponseEntity.ok(ResponseResult.ok(managerPage));  // 返回分页结果
    }

    @PostMapping("/setOnline")
    public ResponseEntity<ResponseResult> setManagerOnline(@RequestParam Long managerId) {
        try {
            managerService.setManagerOnline(managerId);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    @PostMapping("/setOffline")
    public ResponseEntity<ResponseResult> setManagerOffline(@RequestParam Long managerId) {
        try {
            managerService.setManagerOffline(managerId);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    @DeleteMapping("/deleteManager")
    public ResponseEntity<ResponseResult<?>> deleteManager(@RequestParam Long managerId) {
        // 创建一个 UpdateWrapper 对象来构建更新条件
        UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("managerId_zch_hwz_gjc", managerId)
                .set("deleted_zch_hwz_gjc", 1);  // 设置 deleted_zch_hwz_gjc 字段为 1 表示该记录已被逻辑删除

        // 调用 update 方法执行更新操作
        boolean success = managerMapper.update(null, updateWrapper) > 0;
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
        }
    }

    @PostMapping("/loginForSupManager")
    public ResponseEntity<ResponseResult<?>> loginForSupManager(@RequestBody Map<String, String> loginRequest) {
        String superManagerAccount = loginRequest.get("superManagerAccount");
        String superManagerPwd = loginRequest.get("superManagerPwd");

        // 解密密码
        RSA rsa = new RSA(privateKey, publicKey);
        try {
            byte[] encryptedPasswordBytes = Base64.getDecoder().decode(superManagerPwd);  // 假设密码是Base64编码的
            byte[] decryptedPasswordBytes = rsa.decrypt(encryptedPasswordBytes, KeyType.PrivateKey);
            String decryptedSuperManagerPwd = new String(decryptedPasswordBytes);

            // 验证登录凭据
            QueryWrapper<SuperManager> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("superManagerAccount_zch_hwz_gjc", superManagerAccount)
                    .eq("superManagerPwd_zch_hwz_gjc", decryptedSuperManagerPwd)
                    .eq("deleted_zch_hwz_gjc", 0);  // 确保账号未被逻辑删除

            SuperManager superManager = superManagerMapper.selectOne(queryWrapper);
            byte[] encryptedPasswordBytes2 = rsa.encrypt(superManager.getSuperManagerPwd_zch_hwz_gjc().getBytes(), KeyType.PublicKey);
            String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes2);
            superManager.setSuperManagerPwd_zch_hwz_gjc(encryptedPassword);

            if (superManager != null) {
                return ResponseEntity.ok(ResponseResult.ok(superManager));  // 登录成功，返回超级管理员信息
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("账号或密码错误"));  // 登录失败，返回错误信息
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseResult.error("解密失败: " + e.getMessage()));  // 解密错误，返回错误信息
        }
    }

    @PostMapping("/loginForManager")
    public ResponseEntity<ResponseResult<?>> loginForManager(@RequestBody Map<String, String> loginRequest) {
        String managerAccountOrPhone = loginRequest.get("managerAccountOrPhone");
        String managerPwd = loginRequest.get("managerPwd");

        // 解密密码
        RSA rsa = new RSA(privateKey, publicKey);
        try {
            byte[] encryptedPasswordBytes = Base64.getDecoder().decode(managerPwd);  // 假设密码是Base64编码的
            byte[] decryptedPasswordBytes = rsa.decrypt(encryptedPasswordBytes, KeyType.PrivateKey);
            String decryptedManagerPwd = new String(decryptedPasswordBytes);

            // 验证登录凭据
            QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
            queryWrapper.nested(wrapper -> wrapper
                            .eq("managerAccount_zch_hwz_gjc", managerAccountOrPhone)
                            .or()
                            .eq("managerPhone_zch_hwz_gjc", managerAccountOrPhone))
                    .eq("managerPwd_zch_hwz_gjc", decryptedManagerPwd)
                    .eq("deleted_zch_hwz_gjc", 0);  // 确保账号未被逻辑删除

            Manager manager = managerMapper.selectOne(queryWrapper);
            byte[] encryptedPasswordBytes2 = rsa.encrypt(manager.getManagerPwd_zch_hwz_gjc().getBytes(), KeyType.PublicKey);
            String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes2);
            manager.setManagerPwd_zch_hwz_gjc(encryptedPassword);

            if (manager != null) {
                return ResponseEntity.ok(ResponseResult.ok(manager));  // 登录成功，返回管理员信息
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("账号或密码错误"));  // 登录失败，返回错误信息
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(ResponseResult.error("解密失败: " + e.getMessage()));  // 解密错误，返回错误信息
        }
    }

    private boolean isAccountExists(String account) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("managerAccount_zch_hwz_gjc", account);
        return managerMapper.selectCount(queryWrapper) > 0;
    }

    @DeleteMapping("/unbindManagerFromHome")
    public ResponseEntity<ResponseResult<?>> unbindManagerFromHome(
            @RequestParam Long managerId,
            @RequestParam Long homeId) {

        UpdateWrapper<ManagerHomeBinding> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("managerID_zch_hwz_gjc", managerId)
                .eq("homeID_zch_hwz_gjc", homeId)
                .eq("deleted_zch_hwz_gjc", 0)
                .set("bindingState_zch_hwz_gjc", "已解绑")
                .set("deleted_zch_hwz_gjc", 1);

        int rows = bindingMapper.update(null, updateWrapper);
        if (rows > 0) {
            return ResponseEntity.ok(ResponseResult.ok());  // 返回成功响应
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("Failed to unbind manager from home"));
        }
    }

    @PostMapping("/bindManagerToHome")
    public ResponseEntity<ResponseResult<?>> bindManagerToHome(@RequestBody ManagerHomeBinding binding) {
        QueryWrapper<ManagerHomeBinding> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("managerID_zch_hwz_gjc", binding.getManagerID_zch_hwz_gjc())
                .eq("homeID_zch_hwz_gjc", binding.getHomeID_zch_hwz_gjc())
                .eq("deleted_zch_hwz_gjc", 0);  // 确保记录未被逻辑删除

        Long count = bindingMapper.selectCount(queryWrapper);  // 查询匹配条件的记录数
        if (count > 0) {
            return ResponseEntity.badRequest().body(ResponseResult.error("已经存在绑定记录"));
        }

        binding.setBindingTime_zch_hwz_gjc(new Date());  // 获取当前时间作为绑定时间
        binding.setBindingState_zch_hwz_gjc("已绑定");  // 设置绑定状态为已绑定

        int rows = bindingMapper.insert(binding);  // 插入新的绑定记录
        if (rows > 0) {
            return ResponseEntity.ok(ResponseResult.ok());  // 返回成功响应
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("绑定失败"));
        }
    }

    @GetMapping("/getBindingInfo")
    public ResponseEntity<ResponseResult<?>> getBindingInfo(
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "managerId", required = false) Long managerId,
            @RequestParam(value = "homeId", required = false) Long homeId) {

        Page<?> page = new Page<>(pageNo, pageSize);

        if (managerId != null) {
            IPage<Home> homePage = managerHomeBindingService.getHomesByManagerId(managerId, (Page<Home>) page);  // 修改了这里
            return ResponseEntity.ok(ResponseResult.ok(homePage));
        } else if (homeId != null) {
            IPage<Manager> managerPage = managerHomeBindingService.getManagersByHomeId(homeId, (Page<Manager>) page);  // 修改了这里
            return ResponseEntity.ok(ResponseResult.ok(managerPage));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("需要提供管理员ID或房屋ID"));
        }
    }


    @PostMapping("/createUserNotification")
    public ResponseEntity<ResponseResult<?>> createUserNotification(@RequestBody UserNotification userNotification) {
        boolean result = userNotificationService.createUserNotification(userNotification);
        if (result) {
            return ResponseEntity.ok(ResponseResult.ok(userNotification));
        } else {
            return ResponseEntity.badRequest().body(ResponseResult.error("错误"));
        }
    }

    @PutMapping("/updateUserNotification")
    public ResponseEntity<ResponseResult<?>> updateUserNotification(
            @RequestParam Long userNotificationId,
            @RequestParam(required = false) String notificationContent) {
        try {
            // 首先通过ID查找通知
            UserNotification userNotification = userNotificationMapper.selectById(userNotificationId);
            if (userNotification == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("通知不存在"));
            }

            // 更新通知内容
            userNotification.setNotificationContent_zch_hwz_gjc(notificationContent);

            // 使用MyBatis-Plus的方法更新通知
            int result = userNotificationMapper.updateById(userNotification);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok(userNotification));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新通知失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    @DeleteMapping("/deleteNotification")
    public ResponseEntity<ResponseResult<?>> deleteNotification(@RequestParam Long userNotificationId) {
        try {
            boolean result = userNotificationService.deleteNotificationById(userNotificationId);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("删除成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("删除失败或通知不存在"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    @GetMapping("/getAllNotifications")
    public ResponseEntity<ResponseResult<?>> getAllNotifications(
            @RequestParam(required = false, defaultValue = "1") long current,
            @RequestParam(required = false, defaultValue = "10") long size) {
        try {
            // 创建一个 QueryWrapper 实例
            QueryWrapper<UserNotification> queryWrapper = new QueryWrapper<>();
            // 指定按创建时间降序排序
            queryWrapper.orderByDesc("notificationReleaseTime_zch_hwz_gjc");

            // 使用 MyBatis-Plus 的分页方法，传入当前页和每页大小以及排序规则
            IPage<UserNotification> page = userNotificationService.page(new Page<>(current, size), queryWrapper);

            return ResponseEntity.ok(ResponseResult.ok(page));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }
}
