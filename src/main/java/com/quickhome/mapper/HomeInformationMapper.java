package com.quickhome.mapper;

import com.quickhome.domain.HomeInformation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeinformation_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:47:30
* @Entity .domain.HomeInformation
*/
public interface HomeInformationMapper extends BaseMapper<HomeInformation> {
    public HomeInformation getByHomeId(Long homeId_zch_hwz_gjc);
    public Double getHomeDepositByHomeId(Long homeId_zch_hwz_gjc);

}




