package com.quickhome.service;

import com.quickhome.domain.UserInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;

/**
* @author Tim-h
* @description 针对表【tab_userinformation_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:49:11
*/
@Transactional
public interface UserInformationService extends IService<UserInformation> {
    public UserInformation getUserInformationByUserId(Long userId);
    public String getUserImagePath(Long userId);

    public Long updateUserInformation(UserInformation userInformation);
}
