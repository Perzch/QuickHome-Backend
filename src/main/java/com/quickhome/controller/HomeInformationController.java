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

    /**
     * 通过ID获取房屋信息
     * @param homeType 房屋类型
     * @param beginDate 入住日期
     * @param endDate 退房日期
     * @param minRent 最低租金
     * @param maxRent 最高租金
     * @param address 模糊地址关键字
     * @param maxPeople 最大入住人数
     * @param pageNumber 最大回传显示页数
     * @param size 单页最大显示条数
     * @return 房屋信息
     */
    @GetMapping("/")
    @ResponseBody
    public ResponseEntity<?> getHomeInf(@RequestParam(required = false, defaultValue = "all") String homeType,//房屋类型
                                        @RequestParam String beginDate,//入住日期
                                        @RequestParam String endDate,//退房日期
                                        @RequestParam(required = false, defaultValue = "0.0") double minRent,//最低租金
                                        @RequestParam(required = false, defaultValue = "10000.0") double maxRent,//最高租金
                                        @RequestParam(required = false, defaultValue = "all") String address,//模糊地址关键字
                                        @RequestParam(required = false, defaultValue = "1") int maxPeople,//最大入住人数
                                        @RequestParam(defaultValue = "1") Long pageNumber,//最大回传显示页数
                                        @RequestParam(required = false, defaultValue = "5") Long size,//单页最大显示条数
                                        HttpServletRequest req){
        try{
            PojoPageHome pojoPageHome=new PojoPageHome();//回传的数据
            List<Home> homeList;//房屋信息列表
            PJHselect pjh=PJHselect.builder()
                    .homeType(homeType)
                    .beginDate(beginDate)
                    .endDate(endDate)
                    .minRent(minRent)
                    .maxRent(maxRent)
                    .address(address)
                    .maxPeople(maxPeople)
                    .page((pageNumber-1)*size)
                    .size(size)
                    .build();
            if(homeType.equals("all")){
                homeList=homeSer_zch_hwz_gjc.selectHomeCate(pjh);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(ResponseResult.error());

    }

//    @GetMapping("/")//获取房屋信息（复合模糊查询）
//    @ResponseBody
//    public ResponseEntity<?> getHomeInf(@RequestParam(required = false, defaultValue = "all") String homeType,//房屋类型
//                                        @RequestParam(required = false, defaultValue = "0.0") double area,//面积
//                                        @RequestParam String beginDate,//入住日期
//                                        @RequestParam String endDate,//退房日期
//                                        //------------------------------------------------
//                                        @RequestParam(required = false, defaultValue = "all") String device,//房屋设备
//                                        @RequestParam(required = false, defaultValue = "0.0") double minRent,//最低租金
//                                        @RequestParam(required = false, defaultValue = "10000.0") double maxRent,//最高租金
//                                        @RequestParam(required = false, defaultValue = "all") String address,//模糊地址关键字
//                                        //------------------------------------------------
//                                        @RequestParam(required = false, defaultValue = "1") int maxPeople,//最大入住人数
//                                        @RequestParam(defaultValue = "1") Long pageNumber,//最大回传显示页数
//                                        @RequestParam(required = false, defaultValue = "5") Long size,//单页最大显示条数
//                                        HttpServletRequest req) {
//        try {
//            PojoPageHome pojoPageHome = new PojoPageHome();
//            List<Home> homeList;
//            //转存页面获取的值
//            String homeType_un = homeType;
//            double area_un = area;
//            String beginDate_un = beginDate;
//            String endDate_un = endDate;
//            int maxPeople_un = maxPeople;
//            Long pageNumber_un = (pageNumber - 1) * size;
//            Long size_un = size;
//            PJHselect pjh = PJHselect.builder()
//                    .homeType(homeType_un)
//                    .area(area_un)
//                    .beginDate(beginDate_un)
//                    .endDate(endDate_un)
//                    .maxPeople(maxPeople_un)
//                    .page(pageNumber_un)
//                    .size(size_un)
//                    .build();
//            if (homeType_un.equals("all")) {
//                homeList = homeSer_zch_hwz_gjc.selectHomeCate(pjh);
//            } else {
//                homeList = homeSer_zch_hwz_gjc.selectHomeTypeCate(pjh);
//            }
//            List<PojoHome> pojoHomeList = new ArrayList<>();
//            for (Home home : homeList) {
//                PojoHome pojoHome = new PojoHome();
//                pojoHome.setHome(home);
//                pojoHome.setHomeId_zch_hwz_gjc(home.getHomeId_zch_hwz_gjc());
//                HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
//                pojoHome.setHomeInformation(homeInformation);
//                List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
//                pojoHome.setHomeDeviceList(homeDevices);
//                List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
//                pojoHome.setHomeImageList(homeImages);
//                pojoHomeList.add(pojoHome);
//            }
//            pojoPageHome.setPojoHome(pojoHomeList);
//            pojoPageHome.setPage(pageNumber);
//            pojoPageHome.setSize(size);
//            return ResponseEntity.ok(ResponseResult.ok(pojoPageHome));
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return ResponseEntity.ok(ResponseResult.error());
//    }

    /**
     * 通过ID获取房屋信息
     * @param id 房屋ID
     * @param req 请求
     * @return 房屋信息
     */
    @GetMapping("/getHomeInfById")//获取房屋信息通过id
    @ResponseBody
    public ResponseEntity<?> getHomeInfById(@RequestParam Long id,
                                            HttpServletRequest req) {
        return ResponseEntity.ok(ResponseResult.ok(homeInfSer_zch_hwz_gjc.getById(id)));
    }



    @GetMapping("/getHomeListOrderByCollectionCount")//获取热门房屋信息
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
