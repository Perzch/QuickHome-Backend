package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.Home;
import com.quickhome.domain.HomeDevice;
import com.quickhome.domain.HomeImage;
import com.quickhome.pojo.PJHselect;
import com.quickhome.pojo.PojoHome;
import com.quickhome.pojo.PojoPageHome;
import com.quickhome.request.ResponseResult;
import com.quickhome.domain.HomeInformation;
import com.quickhome.service.HomeDeviceService;
import com.quickhome.service.HomeImageService;
import com.quickhome.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.quickhome.service.HomeInformationService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller("HomeInfCon")
@RequestMapping("/homeInf")
public class HomeInformationController {

    @Autowired
    private HomeInformationService homeInfSer_zch_hwz_gjc;

    @Autowired
    private HomeService homeSer_zch_hwz_gjc;

    @Autowired
    private HomeImageService homeImageSer_zch_hwz_gjc;

    @Autowired
    private HomeDeviceService homeDeviceSer_zch_hwz_gjc;

    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getHomeInf(@RequestParam(required = false, defaultValue = "all") String homeType,
                                        @RequestParam(required = false, defaultValue = "0.0") double area,
                                        @RequestParam String beginDate,
                                        @RequestParam String endDate,
                                        @RequestParam(required = false, defaultValue = "1") int maxPeople,
                                        @RequestParam(defaultValue = "1") Long pageNumber,
                                        @RequestParam(required = false, defaultValue = "5") Long size,
                                        HttpServletRequest req) {
        PojoPageHome pojoPageHome=new PojoPageHome();
        List<Home> homeList;
        //转存页面获取的值
        String homeType_un = homeType;
        double area_un = area == 0.0 ? 1000 : area;
        String beginDate_un = beginDate;
        String endDate_un = endDate;
        int maxPeople_un = maxPeople;
        Long pageNumber_un = (pageNumber - 1) * size;
        Long size_un = size;
        PJHselect pjh = PJHselect.builder()
                .homeType(homeType_un)
                .area(area_un)
                .beginDate(beginDate_un)
                .endDate(endDate_un)
                .maxPeople(maxPeople_un)
                .page(pageNumber_un)
                .size(size_un)
                .build();
        System.out.println("============");
        System.out.println(pjh);
        if (homeType_un.equals("all")) {
            homeList = homeSer_zch_hwz_gjc.selectHomeCate(pjh);
        } else {
            homeList = homeSer_zch_hwz_gjc.selectHomeTypeCate(pjh);
        }
        List<PojoHome> pojoHomeList = new ArrayList<>();
        for (Home home : homeList) {
            PojoHome pojoHome = new PojoHome();
            pojoHome.setHome(home);
            HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeInformation(homeInformation);
            List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeDeviceList(homeDevices);
            List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeImageList(homeImages);
            pojoHomeList.add(pojoHome);
        }
        pojoPageHome.setPojoHome(pojoHomeList);
        pojoPageHome.setPage(pageNumber);
        pojoPageHome.setSize(size);
        return ResponseEntity.ok(ResponseResult.ok(pojoPageHome));
    }

    @GetMapping("/getHomeInfById")
    @ResponseBody
    public ResponseEntity<?> getHomeInfById(@RequestParam Long id,
                                            HttpServletRequest req) {
        return ResponseEntity.ok(ResponseResult.ok(homeInfSer_zch_hwz_gjc.getById(id)));
    }



    @GetMapping("/getHomeListOrderByCollectionCount")
    @ResponseBody
    public ResponseEntity<?> getHomeListOrderByCollectionCount() {//获取热门景点
        List<PojoHome> homeList = homeSer_zch_hwz_gjc.getHomeListOrderByCollectionCount();
        List<PojoHome> pojoHomeList = new ArrayList<>();
        for (PojoHome pojoHome : homeList) {
            Home home = homeSer_zch_hwz_gjc.getById(pojoHome.getHomeId_zch_hwz_gjc());
            pojoHome.setHome(home);
            HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeInformation(homeInformation);
            List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeDeviceList(homeDevices);
            List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeImageList(homeImages);
            pojoHomeList.add(pojoHome);
        }
        return ResponseEntity.ok(ResponseResult.ok(pojoHomeList));
    }
}
