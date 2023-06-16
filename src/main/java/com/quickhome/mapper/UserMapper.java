package com.quickhome.mapper;

import com.quickhome.entity.User;
import com.quickhome.entity.UserInformation;

public interface UserMapper {
    int insertUser_zch_hwz_gjc(User user);
    int insertUserInf_zch_hwz_gjc(UserInformation userInformation);
}
