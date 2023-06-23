package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.User;
import com.quickhome.service.UserService;
import com.quickhome.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author Tim-h
* @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:54
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Override
    public String getUserAccountByAccount_zch_hwz_gjc(String userAccount) {
        return baseMapper.getUserAccountByAccount_zch_hwz_gjc(userAccount);
    }

    @Override
    public User userLogin_zch_hwz_gjc(User user) {
        return baseMapper.userLogin_zch_hwz_gjc(user);
    }

    @Override
    public Long getUserIdByAccount(String userAccount) {
        return baseMapper.getUserIdByAccount(userAccount);
    }
}




