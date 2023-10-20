package com.quickhome.mapper;

import com.quickhome.domain.UserHeadImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
* @author Tim-h
* @description 针对表【tab_userheadimage_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:49:04
* @Entity .domain.UserHeadImage
*/
@Mapper
public interface UserHeadImageMapper extends BaseMapper<UserHeadImage> {
    public Boolean insertHeadImgDef_zch_hwz_gjc(UserHeadImage userHeadImage);
    public Long getHeadImgIdByUserId_zch_hwz_gjc(Long userId);

    @Select("SELECT * FROM tab_userHeadImage_zch_hwz_gjc WHERE userId_zch_hwz_gjc = #{userId} AND deleted_zch_hwz_gjc = 0 LIMIT 1")
    UserHeadImage selectByUserId(Long userId);

}




