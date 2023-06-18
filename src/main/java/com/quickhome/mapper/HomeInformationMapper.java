package com.quickhome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.entity.HomeInformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeInformationMapper extends BaseMapper<HomeInformation> {
    List<HomeInformation> getAllHomeInformation_zch_hwz_gjc();
    HomeInformation getHomeInfByHomeId_zch_hwz_gjc(long homeId_zch_hwz_gjc);
}
