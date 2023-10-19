package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserInformation;
import com.quickhome.service.UserInformationService;
import com.quickhome.mapper.UserInformationMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;

/**
* @author Tim-h
* @description 针对表【tab_userinformation_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:49:11
*/
@Service
public class UserInformationServiceImpl extends ServiceImpl<UserInformationMapper, UserInformation>
    implements UserInformationService{

    public UserInformation getUserInformationByUserId(Long userId) {
        QueryWrapper<UserInformation> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId);
        return baseMapper.selectOne(queryWrapper);
    }

    public Long updateUserInformation(Long userId, String userGender, Date userBirthday, String userSignature) {
        UserInformation userInformation = getUserInformationByUserId(userId);
        if (userInformation != null) {
            if (userGender != null && !userGender.isEmpty()) {
                userInformation.setUserGender_zch_hwz_gjc(userGender);
            }
            if (userBirthday != null) {
                userInformation.setUserBirthday_zch_hwz_gjc(userBirthday);
            }
            if (userSignature != null && !userSignature.isEmpty()) {
                userInformation.setUserSignature_zch_hwz_gjc(userSignature);
            }
            baseMapper.updateById(userInformation);
        }
        return userInformation.getUserId_zch_hwz_gjc();
    }

}




