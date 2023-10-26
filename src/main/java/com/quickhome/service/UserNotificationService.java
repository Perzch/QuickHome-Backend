package com.quickhome.service;

import com.quickhome.domain.UserNotification;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_usernotification_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:49:20
*/
@Transactional
public interface UserNotificationService extends IService<UserNotification> {

}
