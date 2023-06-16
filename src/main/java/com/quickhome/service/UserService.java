package com.quickhome.service;

import com.quickhome.entity.User;
import com.quickhome.entity.UserInformation;

public interface UserService {
    int insertUser_zch_hwz_gjc(User user);
    int insertUserInf_zch_hwz_gjc(UserInformation userInformation);
}
