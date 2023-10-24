package com.quickhome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.UserHeadImage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_attractionimage_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-24 11:29:22
* @Entity .domain.AttractionImage
*/
@Mapper
public interface AttractionImageMapper extends BaseMapper<AttractionImage> {
    public List<AttractionImage> getAttractionImageListById(Long attractionId_zch_hwz_gjc);

    @Select("SELECT * FROM tab_attractionimage_zch_hwz_gjc WHERE attractionId_zch_hwz_gjc = #{userId} AND deleted_zch_hwz_gjc = 0 LIMIT 1")
    AttractionImage selectByAttractionId(Long userId);
}




