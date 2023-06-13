package com.quickhome.service;

import com.quickhome.mapper.HomeInformationMapper_zch_hwz_gjc;
import com.quickhome.entity.HomeInformation_zch_hwz_gjc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeInfServ")
public class HomeInfServiceZchhwzgjcImpl_zch_hwz_gjc implements HomeInfService_zch_hwz_gjc {

    @Autowired
    HomeInformationMapper_zch_hwz_gjc homeInformationMapper;

    @Override
    public List<HomeInformation_zch_hwz_gjc> getAllHomeInformation_zch_hwz_gjc() {
        return homeInformationMapper.getAllHomeInformation_zch_hwz_gjc();
    }
}
