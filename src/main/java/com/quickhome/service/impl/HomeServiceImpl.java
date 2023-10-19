package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.*;
import com.quickhome.pojo.PojoHome;
import com.quickhome.service.HomeService;
import com.quickhome.mapper.HomeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_home_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-21 09:47:09
 */
@Service
public class HomeServiceImpl extends ServiceImpl<HomeMapper, Home>
        implements HomeService {

    @Autowired
    private HomeMapper homeMapper;


    @Override
    public List<PojoHome> getHomesByCriteriaWithDevices(String beginDateStr, String endDateStr, String address, double minRent, double maxRent, List<String> deviceNames, int maxPeople, String homeType, int page, int size) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date beginDate = null;
        Date endDate = null;
        try {
            beginDate = sdf.parse(beginDateStr);
            endDate = sdf.parse(endDateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            // Handle date parsing error
        }

        List<Home> homes;
        System.out.println("deviceNames: " + deviceNames);
        if (deviceNames == null || deviceNames.isEmpty() || deviceNames.get(0).isEmpty()) {
            // 如果没有指定设备，查询所有房屋
            homes = homeMapper.selectHomesWithoutDevicesCriteria(beginDate, endDate, address, minRent, maxRent, maxPeople , homeType, (page - 1) * size, size);
        } else {
            // 查询拥有指定设备的房屋
            homes = homeMapper.selectHomesByCriteriaWithDevices(beginDate, endDate, address, minRent, maxRent, deviceNames, deviceNames.size(), maxPeople , homeType, (page - 1) * size, size);
        }

        List<PojoHome> pojoHomes = new ArrayList<>();

        for (Home home : homes) {
            PojoHome pojoHome = new PojoHome();
            pojoHome.setHomeId_zch_hwz_gjc(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHome(home);
            pojoHomes.add(pojoHome);
        }

        return pojoHomes;
    }

    @Override
    public List<Home> getHomesByPage(Long page, Long size) {
        return baseMapper.selectHomeByPage(page, size);
    }

    @Override
    public List<PojoHome> getHomeListOrderByCollectionCount() {
        return baseMapper.getHomeListOrderByCollectionCount();
    }

    @Override
    public Double getHomeDayRentByHomeId(Long homeId_zch_hwz_gjc) {
        return baseMapper.getHomeDayRentByHomeId(homeId_zch_hwz_gjc);
    }
}




