package com.quickhome.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.PaymentPassword;
import com.quickhome.service.PaymentPasswordService;
import com.quickhome.mapper.PaymentPasswordMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
* @author Tim-h
* @description 针对表【tab_paymentpassword_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:24
*/
@Transactional
@Service
public class PaymentPasswordServiceImpl extends ServiceImpl<PaymentPasswordMapper, PaymentPassword>
    implements PaymentPasswordService{


    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;
    @Override
    public boolean setPaymentPassword(Long userId, String encryptedPassword) {

        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("无效的用户ID");
        }
        // 使用私钥解密密码
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] decrypt = rsa.decrypt(encryptedPassword, KeyType.PrivateKey);

        // 接下来的代码与之前相同，只是使用解密后的密码
        QueryWrapper<PaymentPassword> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq("deleted_zch_hwz_gjc", 0);

        PaymentPassword existingPassword = baseMapper.selectOne(queryWrapper);
        if (existingPassword != null) {
            existingPassword.setPaymentPassword_zch_hwz_gjc(StrUtil.str(decrypt, StandardCharsets.UTF_8));
            existingPassword.setSetTime_zch_hwz_gjc(new Date());
            return updateById(existingPassword);
        } else {
            PaymentPassword newPassword = new PaymentPassword();
            newPassword.setUserID_zch_hwz_gjc(userId);
            newPassword.setPaymentPassword_zch_hwz_gjc(StrUtil.str(decrypt, StandardCharsets.UTF_8));
            newPassword.setSetTime_zch_hwz_gjc(new Date());
            return save(newPassword);
        }
    }

    @Override
    public boolean verifyPaymentPassword(Long userId, String encryptedPassword) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("无效的用户ID");
        }

        // 使用私钥解密密码
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] decrypt = rsa.decrypt(encryptedPassword, KeyType.PrivateKey);

        // 接下来的代码与之前相同，只是使用解密后的密码
        QueryWrapper<PaymentPassword> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq("deleted_zch_hwz_gjc", 0);

        PaymentPassword existingPassword = baseMapper.selectOne(queryWrapper);

        if (existingPassword == null) {
            throw new IllegalArgumentException("用户未设置支付密码");
        }

        return existingPassword.getPaymentPassword_zch_hwz_gjc().equals(StrUtil.str(decrypt, StandardCharsets.UTF_8));
    }

    public boolean getPaymentPasswordStatus(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("无效的用户ID");
        }

        QueryWrapper<PaymentPassword> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq("deleted_zch_hwz_gjc", 0)
                .isNotNull("paymentPassword_zch_hwz_gjc")
                .ne("paymentPassword_zch_hwz_gjc", "");

        Long count = baseMapper.selectCount(queryWrapper);
        return count > 0;
    }


}




