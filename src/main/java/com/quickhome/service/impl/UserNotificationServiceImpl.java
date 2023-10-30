package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserNotification;
import com.quickhome.service.UserNotificationService;
import com.quickhome.mapper.UserNotificationMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
* @author Tim-h
* @description 针对表【tab_usernotification_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:49:20
*/
@Transactional
@Service
public class UserNotificationServiceImpl extends ServiceImpl<UserNotificationMapper, UserNotification>
    implements UserNotificationService{
    @Override
    public boolean createUserNotification(UserNotification userNotification) {
        userNotification.setNotificationReleaseTime_zch_hwz_gjc(new Date()); // 设置当前时间为通知发布时间
        return baseMapper.insert(userNotification) > 0;
    }

    @Override
    public boolean deleteNotificationById(Long id) {
        return baseMapper.deleteById(id) > 0;
    }

    @Override
    public IPage<UserNotification> getAllNotifications(long current, long size) {
        Page<UserNotification> page = new Page<>(current, size);
        return baseMapper.selectPage(page, null);
    }
}




