package com.quickhome.mapper;

import com.quickhome.entity.User;
import com.quickhome.entity.UserInformation;

public interface UserMapper {
    public int insertUser_zch_hwz_gjc(User user);
    public int insertUserInf_zch_hwz_gjc(UserInformation userInformation);
}
