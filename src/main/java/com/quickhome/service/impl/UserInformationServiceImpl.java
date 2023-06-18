package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserInformation;
import com.quickhome.mapper.UserInformationMapper;
import com.quickhome.service.UserInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Perzch
* @description 针对表【tab_userInformation_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-17 19:42:29
*/
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserInformation>
    implements UserInformationService {

    @Autowired
    private UserInformationMapper userInformationMapper;

    @Override
    public int insert(UserInformation userInformation) {
        return userInformationMapper.insert(userInformation);
    }
}




