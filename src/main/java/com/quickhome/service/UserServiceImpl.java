package com.quickhome.service;

import com.quickhome.entity.User;
import com.quickhome.entity.UserInformation;
import com.quickhome.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServ")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUserInf_zch_hwz_gjc(UserInformation userInformation) {
        return userMapper.insertUserInf_zch_hwz_gjc(userInformation);
    }

    @Override
    public int insertUser_zch_hwz_gjc(User user) {
        return userMapper.insertUser_zch_hwz_gjc(user);
    }
}
