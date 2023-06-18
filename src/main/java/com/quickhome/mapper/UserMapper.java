package com.quickhome.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.domain.User;
import com.quickhome.domain.UserInformation;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Perzch
* @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-17 19:42:29
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

}




