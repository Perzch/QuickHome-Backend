package com.quickhome.mapper;

import com.quickhome.domain.Attraction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.pojo.PojoAttraction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_attractions_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:45:15
* @Entity .domain.Attractions
*/
@Mapper
public interface AttractionMapper extends BaseMapper<Attraction> {
    List<PojoAttraction> getAttractionListOrderByCollectionCount();
}




