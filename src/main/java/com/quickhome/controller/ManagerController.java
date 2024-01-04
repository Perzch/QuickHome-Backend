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
import com.quickhome.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.*;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/23 14:21
 */
@Transactional
@Controller("ManagerCon")
@RequestMapping("/manager")
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

    /**
     * 新增管理员
     * @param manager 管理员对象
     * @return
     */

    @PostMapping
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
            return ResponseEntity.ok().body(ResponseResult.error("插入失败"));
        }
    }

    /**
     * 更新管理员
     * @return
     */

    @PutMapping
    public ResponseEntity<ResponseResult<?>> updatePassword(
            @RequestBody Manager manager) {
        if (manager.getManagerId_zch_hwz_gjc() == null) {
            return ResponseEntity.ok().body(ResponseResult.error("管理员Id不能为空"));
        }
        Manager currentManager = managerMapper.selectById(manager.getManagerId_zch_hwz_gjc());
        if(Objects.nonNull(currentManager)) {
            if(!StringUtils.isEmpty(manager.getManagerPwd_zch_hwz_gjc())) {
                RSA rsa = new RSA(privateKey, publicKey);
                byte[] decrypt = rsa.decrypt(manager.getManagerPwd_zch_hwz_gjc(), KeyType.PrivateKey);
                manager.setManagerPwd_zch_hwz_gjc(new String(decrypt));
            }
            boolean result = managerService.updateById(manager);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("更新失败，请重试"));
            }
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("管理员不存在"));
        }
    }

    /**
     * 获取管理员信息
     * @param managerId 管理员ID
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> getManager(@PathVariable("id") Long managerId) {
        QueryWrapper<Manager> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("managerId_zch_hwz_gjc", managerId);
        Manager manager = managerMapper.selectOne(queryWrapper);

        if (manager == null) {
            return ResponseEntity.ok().body(ResponseResult.error("没有找到指定的管理员"));
        }

        // 加密密码
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encryptedPasswordBytes = rsa.encrypt(manager.getManagerPwd_zch_hwz_gjc().getBytes(), KeyType.PublicKey);
        String encryptedPassword = Base64.getEncoder().encodeToString(encryptedPasswordBytes);
        manager.setManagerPwd_zch_hwz_gjc(encryptedPassword);

        return ResponseEntity.ok(ResponseResult.ok(manager));
    }

    /**
     * 获取所有管理员信息
     * @param pageNo 页码
     * @param pageSize 每页大小
     * @return
     */

    @GetMapping("/list")
    public ResponseEntity<ResponseResult<?>> getAllManager(
            @RequestParam(value = "page", defaultValue = "1") int pageNo,
            @RequestParam(value = "size", defaultValue = "10") int pageSize) {

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

    /**
     * 设置管理员在线状态
     * @param managerId 管理员ID
     * @return
     */

    @PutMapping("/online")
    public ResponseEntity<ResponseResult> setManagerOnline(@RequestParam Long managerId) {
        try {
            managerService.setManagerOnline(managerId);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 设置管理员离线状态
     * @param managerId 管理员ID
     * @return
     */

    @PutMapping("/offline")
    public ResponseEntity<ResponseResult> setManagerOffline(@RequestParam Long managerId) {
        try {
            managerService.setManagerOffline(managerId);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 删除管理员
     * @param managerId 管理员ID
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> deleteManager(@PathVariable("id") Long[] managerId) {
        boolean success = managerService.removeBatchByIds(Arrays.asList(managerId));
        if (success) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
        }
    }

    /**
     * 超级管理员登录
     * @param loginRequest 登录请求
     * @return
     */

    @PostMapping("/super/login")
    public ResponseEntity<ResponseResult<?>> loginForSupManager(@RequestBody Map<String, String> loginRequest) {
        String superManagerAccount = loginRequest.get("username");
        String superManagerPwd = loginRequest.get("password");

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

            if (superManager != null) {
                superManager.setToken(JwtUtil.createToken(superManager.getSuperManagerId_zch_hwz_gjc()));
                return ResponseEntity.ok(ResponseResult.ok(superManager));  // 登录成功，返回超级管理员信息
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("账号或密码错误"));  // 登录失败，返回错误信息
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(ResponseResult.error("解密失败: " + e.getMessage()));  // 解密错误，返回错误信息
        }
    }

    /**
     * 管理员登录
     * @param loginRequest 登录请求
     * @return
     */

    @PostMapping("/login")
    public ResponseEntity<ResponseResult<?>> loginForManager(@RequestBody Map<String, String> loginRequest) {
        String managerAccountOrPhone = loginRequest.get("username");
        String managerPwd = loginRequest.get("password");

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

            if (manager != null) {
                manager.setToken(JwtUtil.createToken(manager.getManagerId_zch_hwz_gjc()));
                return ResponseEntity.ok(ResponseResult.ok(manager));  // 登录成功，返回管理员信息
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("账号或密码错误"));  // 登录失败，返回错误信息
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

    /**
     * 解绑管理员与房屋
     * @return
     */

    @DeleteMapping("/binding/unbind")
    public ResponseEntity<ResponseResult<?>> unbindManagerFromHome(@RequestBody ManagerHomeBinding homeBinding) {

        UpdateWrapper<ManagerHomeBinding> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("managerID_zch_hwz_gjc", homeBinding.getManagerID_zch_hwz_gjc())
                .eq("homeID_zch_hwz_gjc", homeBinding.getHomeID_zch_hwz_gjc())
                .eq("deleted_zch_hwz_gjc", 0)
                .set("bindingState_zch_hwz_gjc", "已解绑")
                .set("deleted_zch_hwz_gjc", 1);

        int rows = bindingMapper.update(null, updateWrapper);
        if (rows > 0) {
            return ResponseEntity.ok(ResponseResult.ok());  // 返回成功响应
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("Failed to unbind manager from home"));
        }
    }

    /**
     * 绑定管理员与房屋
     * @param binding 绑定信息
     * @return
     */

    @PostMapping("/binding/bind")
    public ResponseEntity<ResponseResult<?>> bindManagerToHome(@RequestBody ManagerHomeBinding binding) {
        QueryWrapper<ManagerHomeBinding> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("managerID_zch_hwz_gjc", binding.getManagerID_zch_hwz_gjc())
                .eq("homeID_zch_hwz_gjc", binding.getHomeID_zch_hwz_gjc())
                .eq("deleted_zch_hwz_gjc", 0);  // 确保记录未被逻辑删除

        Long count = bindingMapper.selectCount(queryWrapper);  // 查询匹配条件的记录数
        if (count > 0) {
            return ResponseEntity.ok().body(ResponseResult.error("已经存在绑定记录"));
        }

        binding.setBindingTime_zch_hwz_gjc(new Date());  // 获取当前时间作为绑定时间
        binding.setBindingState_zch_hwz_gjc("已绑定");  // 设置绑定状态为已绑定

        int rows = bindingMapper.insert(binding);  // 插入新的绑定记录
        if (rows > 0) {
            return ResponseEntity.ok(ResponseResult.ok());  // 返回成功响应
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("绑定失败"));
        }
    }

    /**
     * 获取管理员与房屋的绑定信息
     * @param pageNo 页码
     * @param pageSize 每页大小
     * @param managerId 管理员ID
     * @param homeId 房屋ID
     * @return
     */
    @GetMapping("/binding/list")
    public ResponseEntity<ResponseResult<?>> getBindingInfo(
            @RequestParam(value = "page", defaultValue = "1") int pageNo,
            @RequestParam(value = "size", defaultValue = "10") int pageSize,
            @RequestParam(value = "managerId", required = false) Long managerId,
            @RequestParam(value = "homeId", required = false) Long homeId) {

        Page<?> page = new Page<>(pageNo, pageSize);

        if (managerId != null) {
            IPage<Home> homePage = managerHomeBindingService.getHomesByManagerId(managerId, (Page<Home>) page);
            return ResponseEntity.ok(ResponseResult.ok(homePage));
        } else if (homeId != null) {
            IPage<Manager> managerPage = managerHomeBindingService.getManagersByHomeId(homeId, (Page<Manager>) page);
            return ResponseEntity.ok(ResponseResult.ok(managerPage));
        } else {
            // 如果没有提供管理员ID或房屋ID，返回该表中所有数据
            IPage<ManagerHomeBinding> bindingInfoPage = managerHomeBindingService.getAllBindingInfo(page);
            return ResponseEntity.ok(ResponseResult.ok(bindingInfoPage));
        }
    }

    /**
     * 创建用户通知
     * @param userNotification 用户通知
     * @return
     */

    @PostMapping("/notification")
    public ResponseEntity<ResponseResult<?>> createUserNotification(@RequestBody UserNotification userNotification) {
        boolean result = userNotificationService.createUserNotification(userNotification);
        if (result) {
            return ResponseEntity.ok(ResponseResult.ok(userNotification));
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("错误"));
        }
    }

    /**
     * 更新用户通知
     * @return
     */
    @PutMapping("/notification")
    public ResponseEntity<ResponseResult<?>> updateUserNotification(@RequestBody UserNotification un) {
        try {
            // 首先通过ID查找通知
            UserNotification userNotification = userNotificationMapper.selectById(un.getUserNotificationId_zch_hwz_gjc());
            if (userNotification == null) {
                return ResponseEntity.ok().body(ResponseResult.error("通知不存在"));
            }

            // 更新通知内容
            userNotification.setNotificationContent_zch_hwz_gjc(un.getNotificationContent_zch_hwz_gjc());

            // 使用MyBatis-Plus的方法更新通知
            int result = userNotificationMapper.updateById(un);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok(un));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("更新通知失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 删除用户通知
     * @param userNotificationIds 用户通知ID
     * @return
     */

    @DeleteMapping("/notification/{id}")
    public ResponseEntity<ResponseResult<?>> deleteNotification(@PathVariable("id") Long[] userNotificationIds) {
        try {
            int result = userNotificationMapper.deleteBatchIds(Arrays.asList(userNotificationIds));
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok("删除成功"));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("删除失败或通知不存在"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 获取所有用户通知
     * @param current 当前页
     * @param size 每页大小
     * @return
     */

    @GetMapping("/notification/list")
    public ResponseEntity<ResponseResult<?>> getAllNotifications(
            @RequestParam(required = false, name = "after") Boolean after,
            @RequestParam(required = false, defaultValue = "1", name = "page") long current,
            @RequestParam(required = false, defaultValue = "10", name = "size") long size,
            HttpServletRequest req) {
        try {
            // 创建一个 QueryWrapper 实例
            QueryWrapper<UserNotification> queryWrapper = new QueryWrapper<>();

            // 如果传入了 after 参数且为真，则不设置时间条件，查询所有通知
            if (after != null && after) {
                queryWrapper.orderByDesc("notificationReleaseTime_zch_hwz_gjc");
            } else {
                // 否则，指定按创建时间降序排序，并且查询当前时间之前的通知
                queryWrapper.orderByDesc("notificationReleaseTime_zch_hwz_gjc")
                        .le("notificationReleaseTime_zch_hwz_gjc", LocalDateTime.now());
            }

            // 使用 MyBatis-Plus 的分页方法，传入当前页和每页大小以及排序规则
            IPage<UserNotification> page = userNotificationService.page(new Page<>(current, size), queryWrapper);

            return ResponseEntity.ok(ResponseResult.ok(page));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

}
