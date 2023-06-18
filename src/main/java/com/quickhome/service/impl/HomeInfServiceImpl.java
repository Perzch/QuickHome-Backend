package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.mapper.HomeInformationMapper;
import com.quickhome.entity.HomeInformation;
import com.quickhome.service.HomeInfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("homeInfServ")
public class HomeInfServiceImpl extends ServiceImpl<HomeInformationMapper, HomeInformation> implements HomeInfService {

    @Autowired
    HomeInformationMapper homeInformationMapper;

    @Override
    public List<HomeInformation> getAllHomeInformation_zch_hwz_gjc() {
        return homeInformationMapper.getAllHomeInformation_zch_hwz_gjc();
    }

    @Override
    public HomeInformation getHomeInfByHomeId_zch_hwz_gjc(long homeId_zch_hwz_gjc) {
        return homeInformationMapper.getHomeInfByHomeId_zch_hwz_gjc(homeId_zch_hwz_gjc);
    }
}
