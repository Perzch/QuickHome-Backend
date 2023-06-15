package com.quickhome.service;

import com.quickhome.mapper.HomeInformationMapper;
import com.quickhome.entity.HomeInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeInfServ")
public class HomeInfServiceImpl implements HomeInfService {

    @Autowired
    HomeInformationMapper homeInformationMapper;

    @Override
    public List<HomeInformation> getAllHomeInformation_zch_hwz_gjc() {
        return homeInformationMapper.getAllHomeInformation_zch_hwz_gjc();
    }
}
