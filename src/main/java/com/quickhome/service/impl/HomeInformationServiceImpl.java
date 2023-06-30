package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.HomeInformation;
import com.quickhome.service.HomeInformationService;
import com.quickhome.mapper.HomeInformationMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeinformation_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:47:30
*/
@Service
public class HomeInformationServiceImpl extends ServiceImpl<HomeInformationMapper, HomeInformation>
    implements HomeInformationService{

    @Override
    public HomeInformation getByHomeId(Long homeId_zch_hwz_gjc) {
        return baseMapper.getByHomeId(homeId_zch_hwz_gjc);
    }

    @Override
    public Double getHomeDepositByHomeId(Long homeId_zch_hwz_gjc) {
        return baseMapper.getHomeDepositByHomeId(homeId_zch_hwz_gjc);
    }
}




