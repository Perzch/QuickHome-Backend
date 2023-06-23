package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserNotification;
import com.quickhome.service.UserNotificationService;
import com.quickhome.mapper.UserNotificationMapper;
import org.springframework.stereotype.Service;

/**
* @author Tim-h
* @description 针对表【tab_usernotification_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:49:20
*/
@Service
public class UserNotificationServiceImpl extends ServiceImpl<UserNotificationMapper, UserNotification>
    implements UserNotificationService{

}




