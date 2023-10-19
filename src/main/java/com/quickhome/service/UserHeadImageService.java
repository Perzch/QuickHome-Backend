package com.quickhome.service;

import com.quickhome.domain.UserHeadImage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Tim-h
* @description 针对表【tab_userheadimage_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:49:04
*/
public interface UserHeadImageService extends IService<UserHeadImage> {
    public UserHeadImage saveOrUpdateUserHeadImage(Long userId, String imagePath);

    public Long getHeadImgIdByUserId_zch_hwz_gjc(Long userId);

    public UserHeadImage getUserHeadImageByUserId(Long userId);

}
