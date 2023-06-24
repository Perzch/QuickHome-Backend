package com.quickhome.controller;

import com.quickhome.domain.Home;
import com.quickhome.domain.HomeDevice;
import com.quickhome.domain.HomeImage;
import com.quickhome.pojo.PojoHome;
import com.quickhome.pojo.PojoPageHome;
import com.quickhome.request.ResponseResult;
import com.quickhome.domain.HomeInformation;
import com.quickhome.service.HomeDeviceService;
import com.quickhome.service.HomeImageService;
import com.quickhome.service.HomeService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.quickhome.service.HomeInformationService;

import java.util.ArrayList;
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
    public ResponseEntity<?> getAllHomeInf(@RequestParam(required = false, defaultValue = "all") String homeType,
                                           @RequestParam(required = false, defaultValue = "0.0") double area,
                                           @RequestParam(defaultValue = "1") int pageNumber,
                                           @RequestParam(required = false, defaultValue = "5") int size,
                                           HttpServletRequest req) {
        List<HomeInformation> allHomeInformationZchHwzGjc = homeInfSer_zch_hwz_gjc.list();
        return ResponseEntity.ok(ResponseResult.ok(allHomeInformationZchHwzGjc));
    }

    @GetMapping("/getHomeInfById")
    @ResponseBody
    public ResponseEntity<?> getHomeInfById(@RequestParam Long id, HttpServletRequest req) {
        return ResponseEntity.ok(ResponseResult.ok(homeInfSer_zch_hwz_gjc.getById(id)));
    }
    @GetMapping("/getHome")
    public ResponseEntity<?> getHomesByPage(@RequestParam Long page, @RequestParam Long size) {
        PojoPageHome pojoPageHome = new PojoPageHome();
        page = (page - 1) * size;
        List<Home> homeList =  homeSer_zch_hwz_gjc.getHomesByPage(page, size);
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
        pojoPageHome.setPage(page);
        pojoPageHome.setSize(size);
        return ResponseEntity.ok(ResponseResult.ok(pojoPageHome));
    }

    @GetMapping("/getHomeListOrderByCollectionCount")
    @ResponseBody
    public ResponseEntity<?> getHomeListOrderByCollectionCount() {
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
