package com.quickhome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.domain.AttractionImage;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_attractionimage_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-24 11:29:22
* @Entity .domain.AttractionImage
*/
public interface AttractionImageMapper extends BaseMapper<AttractionImage> {
    public List<AttractionImage> getAttractionImageListById(Long attractionId_zch_hwz_gjc);
}




