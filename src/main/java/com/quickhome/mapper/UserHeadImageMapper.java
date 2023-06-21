package com.quickhome.mapper;

import com.quickhome.domain.UserHeadImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tim-h
* @description 针对表【tab_userheadimage_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:49:04
* @Entity .domain.UserHeadImage
*/
public interface UserHeadImageMapper extends BaseMapper<UserHeadImage> {
    public Boolean insertHeadImgDef_zch_hwz_gjc(UserHeadImage userHeadImage);
    public Long getHeadImgIdByUserId_zch_hwz_gjc(Long userId);


}




