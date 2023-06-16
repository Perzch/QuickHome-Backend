package com.quickhome.mapper;

import com.quickhome.entity.HomeInformation;

import java.util.List;

public interface HomeInformationMapper {
    List<HomeInformation> getAllHomeInformation_zch_hwz_gjc();
    HomeInformation getHomeInfByHomeId_zch_hwz_gjc(long homeId_zch_hwz_gjc);
}
