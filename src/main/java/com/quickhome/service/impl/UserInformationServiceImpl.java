package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserInformation;
import com.quickhome.service.UserInformationService;
import com.quickhome.mapper.UserInformationMapper;
import org.springframework.stereotype.Service;

/**
* @author Tim-h
* @description 针对表【tab_userinformation_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:49:11
*/
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserInformation>
    implements UserInformationService{

}




