package com.quickhome.mapper;

import com.quickhome.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.junit.Test;

/**
* @author Tim-h
* @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:48:54
* @Entity .domain.User
*/
public interface UserMapper extends BaseMapper<User> {
    public String getUserAccountByAccount_zch_hwz_gjc(String userAccount);
    public User userLogin_zch_hwz_gjc(User user);
    public Long getUserIdByAccount(String userAccount);
    public Boolean queryUser(User user);

}




