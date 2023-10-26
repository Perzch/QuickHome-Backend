package com.quickhome.mapper;

import com.quickhome.domain.HomeImage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeimage_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:47:24
* @Entity .domain.HomeImage
*/
@Mapper
public interface HomeImageMapper extends BaseMapper<HomeImage> {
    public List<HomeImage> getAllById(Long homeId_zch_hwz_gjc);

}




