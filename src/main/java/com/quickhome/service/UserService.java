package com.quickhome.service;

import com.quickhome.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:48:54
*/
@Transactional
public interface UserService extends IService<User> {
    public String getUserAccountByAccount_zch_hwz_gjc(String userAccount);
    public String userLogin_zch_hwz_gjc(User user);
    public Long getUserIdByAccount(String userAccount);
    public List<User> queryUser(User user);
    public User queryUserForLogin(User user);
    public Boolean userForget_zch_hwz_gjc(User user);

    public User loginByPhone(String phone);
    public Long setUserPassword(String userEmail, String userPhone, String userPwd);
}
