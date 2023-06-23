package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.service.UserHeadImageService;
import com.quickhome.mapper.UserHeadImageMapper;
import org.springframework.stereotype.Service;

/**
 * @author Tim-h
 * @description 针对表【tab_userheadimage_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-21 09:49:04
 */
@Service
public class UserHeadImageServiceImpl extends ServiceImpl<UserHeadImageMapper, UserHeadImage>
        implements UserHeadImageService {

    @Override
    public Boolean insertHeadImgDef_zch_hwz_gjc(UserHeadImage userHeadImage) {
        return baseMapper.insertHeadImgDef_zch_hwz_gjc(userHeadImage);
    }

    @Override
    public Long getHeadImgIdByUserId_zch_hwz_gjc(Long userId) {
        return baseMapper.getHeadImgIdByUserId_zch_hwz_gjc(userId);
    }
}




