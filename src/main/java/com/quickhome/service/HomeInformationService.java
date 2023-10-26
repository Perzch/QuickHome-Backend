package com.quickhome.service;

import com.quickhome.domain.HomeInformation;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_homeinformation_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:30
*/
@Transactional
public interface HomeInformationService extends IService<HomeInformation> {
    public HomeInformation getByHomeId(Long homeId_zch_hwz_gjc);
    public Double getHomeDepositByHomeId(Long homeId_zch_hwz_gjc);

}
