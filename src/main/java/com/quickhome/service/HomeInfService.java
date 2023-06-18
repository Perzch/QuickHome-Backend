package com.quickhome.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.entity.HomeInformation;

import java.util.List;

public interface HomeInfService extends IService<HomeInformation> {
    List<HomeInformation> getAllHomeInformation_zch_hwz_gjc();
    public HomeInformation getHomeInfByHomeId_zch_hwz_gjc(long homeId_zch_hwz_gjc);
}
