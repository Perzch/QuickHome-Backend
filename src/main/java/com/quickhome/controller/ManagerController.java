package com.quickhome.controller;

import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.Manager;
import com.quickhome.domain.SuperManager;
import com.quickhome.mapper.ManagerMapper;
import com.quickhome.mapper.SuperManagerMapper;
import com.quickhome.request.ResponseResult;
import com.quickhome.util.CreatAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@Controller("ManagerCon")
@RequestMapping("/Manager")
public class ManagerController {
    //公钥与私钥
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;

    @Autowired
    private SuperManagerMapper superManagerMapper;

    @Autowired
    private ManagerMapper managerMapper;

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

            // 更新密码
            UpdateWrapper<Manager> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("managerId_zch_hwz_gjc", managerId)
                    .set("managerPwd_zch_hwz_gjc", newPassword);

            boolean success = managerMapper.update(null, updateWrapper) > 0;
            if (success) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("密码更新失败"));
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
}
