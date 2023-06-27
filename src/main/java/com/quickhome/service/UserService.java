package com.quickhome.service;

import com.quickhome.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Tim-h
* @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:48:54
*/
public interface UserService extends IService<User> {
    public String getUserAccountByAccount_zch_hwz_gjc(String userAccount);
    public String userLogin_zch_hwz_gjc(User user);
    public Long getUserIdByAccount(String userAccount);
    public User queryUser(User user);
    public User queryUserForLogin(User user);

}
