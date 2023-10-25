package com.quickhome.service.impl;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.service.UserHeadImageService;
import com.quickhome.mapper.UserHeadImageMapper;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

/**
 * @author Tim-h
 * @description 针对表【tab_userheadimage_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-21 09:49:04
 */
@Transactional
@Service
public class UserHeadImageServiceImpl extends ServiceImpl<UserHeadImageMapper, UserHeadImage>
        implements UserHeadImageService {

    @Override
    public UserHeadImage saveOrUpdateUserHeadImage(Long userId, String imagePath) {
        UserHeadImage existingImage = baseMapper.selectByUserId(userId);
        if (existingImage != null) {
            existingImage.setImagePath_zch_hwz_gjc(imagePath);
            existingImage.setInDateTime_zch_hwz_gjc(DateTime.now());
            baseMapper.updateById(existingImage);
            return existingImage;
        } else {
            UserHeadImage newImage = new UserHeadImage();
            newImage.setUserId_zch_hwz_gjc(userId);
            newImage.setImagePath_zch_hwz_gjc(imagePath);
            newImage.setInDateTime_zch_hwz_gjc(DateTime.now());
            baseMapper.insert(newImage);
            return newImage;
        }
    }

    @Override
    public Long getHeadImgIdByUserId_zch_hwz_gjc(Long userId) {
        return baseMapper.getHeadImgIdByUserId_zch_hwz_gjc(userId);
    }

    @Override
    public UserHeadImage getUserHeadImageByUserId(Long userId) {
        QueryWrapper<UserHeadImage> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId);
        return baseMapper.selectOne(queryWrapper);
    }
}




