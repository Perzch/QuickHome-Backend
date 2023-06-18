package com.quickhome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.domain.HomeInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Perzch
* @description 针对表【tab_homeInformation_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-17 19:42:29
*/
@Mapper
public interface HomeInformationMapper extends BaseMapper<HomeInformation> {
    List<HomeInformation> selectAll();
}