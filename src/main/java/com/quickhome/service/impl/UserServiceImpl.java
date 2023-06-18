package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.User;
import com.quickhome.domain.UserInformation;
import com.quickhome.mapper.UserMapper;
import com.quickhome.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Perzch
* @description 针对表【tab_user_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-17 19:42:29
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService {
}




