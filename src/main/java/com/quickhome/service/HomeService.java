package com.quickhome.service;

import com.quickhome.domain.Home;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.pojo.PojoHome;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:47:09
*/
public interface HomeService extends IService<Home> {
    public List<Home> getHomesByPage(Long page, Long size);
    public List<PojoHome> getHomeListOrderByCollectionCount();
    public Double getHomeDayRentByHomeId(Long homeId_zch_hwz_gjc);
    List<PojoHome> getHomesByCriteriaWithDevices(String beginDateStr, String endDateStr, String address, double minRent, double maxRent, List<String> deviceNames,int maxPeople ,String homeType, int page, int size);
}
