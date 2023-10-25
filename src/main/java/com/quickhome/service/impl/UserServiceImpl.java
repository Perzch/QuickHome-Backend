package com.quickhome.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.User;
import com.quickhome.exception.ExistException;
import com.quickhome.request.ResultCode;
import com.quickhome.service.UserService;
import com.quickhome.mapper.UserMapper;
import com.quickhome.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

/**
 * @author Tim-h
 * @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-21 09:48:54
 */
@Transactional
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;

    @Override
    public String getUserAccountByAccount_zch_hwz_gjc(String userAccount) {
        return baseMapper.getUserAccountByAccount_zch_hwz_gjc(userAccount);
    }

    @Override
    public String userLogin_zch_hwz_gjc(User user) {
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] decrypt = rsa.decrypt(user.getUserPwd_zch_hwz_gjc(), KeyType.PrivateKey);
        User u = queryUserForLogin(user);
        if (Objects.isNull(u)) throw new ExistException(ResultCode.USER_NOT_EXIST.getMsg());
        if (u.getUserPwd_zch_hwz_gjc().equals(StrUtil.str(decrypt, StandardCharsets.UTF_8))) {
            return JwtUtil.createToken(u.getUserId_zch_hwz_gjc());
        } else {
            return null;
        }
    }

    @Override
    public Long setUserPassword(String userEmail, String userPhone, String userPwd) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("deleted_zch_hwz_gjc", 0)
                .and(wrapper -> wrapper.eq("userEmail_zch_hwz_gjc", userEmail)
                        .or()
                        .eq("userPhone_zch_hwz_gjc", userPhone));

        User user = baseMapper.selectOne(queryWrapper);
        if (user != null) {
            user.setUserPwd_zch_hwz_gjc(userPwd);
            baseMapper.updateById(user);
            return user.getUserId_zch_hwz_gjc();
        }
        return null;
    }

    @Override
    public User loginByPhone(String phone) {
        return baseMapper.findByPhone(phone);
    }

    @Override
    public Long getUserIdByAccount(String userAccount) {
        return baseMapper.getUserIdByAccount(userAccount);
    }

    @Override
    public List<User> queryUser(User user) {
        return baseMapper.queryUser(user);
    }

    public User queryUserForLogin(User user) {
        return baseMapper.queryUserForLogin(user);
    }

    @Override
    public Boolean userForget_zch_hwz_gjc(User user) {
        User u = baseMapper.queryUserForLogin(user);
        if (Objects.isNull(u)) {
            return false;
        } else {
            return true;
        }
    }
}




