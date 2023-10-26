package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.quickhome.domain.Home;
import com.quickhome.domain.HomeDevice;
import com.quickhome.domain.HomeImage;
import com.quickhome.mapper.HomeInformationMapper;
import com.quickhome.mapper.HomeMapper;
import com.quickhome.pojo.PojoHome;
import com.quickhome.request.ResponseResult;
import com.quickhome.domain.HomeInformation;
import com.quickhome.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Transactional
@Controller("HomeInfCon")
@RequestMapping("/homeInf")
public class HomeInformationController {

    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private HomeInformationMapper homeInformationMapper;

    @Autowired
    private HouseCollectionService houseCollectionService;

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
     * @param page 最大回传显示页数
     * @param size 单页最大显示条数
     * @return 房屋信息
     */

    @GetMapping("/")//获取房屋信息（复合模糊查询）
    @ResponseBody
    public ResponseEntity<?> getHomeInf(@RequestParam(required = false, defaultValue = "") String homeType,//房屋类型
                                        @RequestParam String beginDate,//入住日期
                                        @RequestParam String endDate,//退房日期
                                        @RequestParam(required = false, defaultValue = "") String device,//房屋设备
                                        @RequestParam(required = false, defaultValue = "0.0") double minRent,//最低租金
                                        @RequestParam(required = false, defaultValue = "10000.0") double maxRent,//最高租金
                                        @RequestParam(required = false, defaultValue = "") String address,//模糊地址关键字
                                        @RequestParam(required = false, defaultValue = "1") int maxPeople,//最大入住人数
                                        @RequestParam(defaultValue = "1") int page,//最大回传显示页数
                                        @RequestParam(required = false, defaultValue = "10") int size,//单页最大显示条数
                                        HttpServletRequest req) {
        List<String> deviceNames = Arrays.asList(device.split(","));
        List<PojoHome> pojoHomes = homeSer_zch_hwz_gjc.getHomesByCriteriaWithDevices(beginDate, endDate, address, minRent, maxRent,deviceNames ,maxPeople ,homeType ,page, size);

        List<PojoHome> pojoHomeList = new ArrayList<>();
        for (PojoHome pojoHome : pojoHomes) {
            Home home = homeSer_zch_hwz_gjc.getById(pojoHome.getHomeId_zch_hwz_gjc());
            pojoHome.setHome(home);
            HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeInformation(homeInformation);
            List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeDeviceList(homeDevices);
            List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setHomeImageList(homeImages);
            int collectionNum = houseCollectionService.getCollectionCountByHomeId(home.getHomeId_zch_hwz_gjc());
            pojoHome.setCollectionCount(collectionNum);
            pojoHomeList.add(pojoHome);
        }
        return ResponseEntity.ok(ResponseResult.ok(pojoHomeList));
    }

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


    @ResponseBody
    @PostMapping("/insertHome")
    public ResponseEntity<ResponseResult<?>> insertHome(
            @RequestBody Home home) {
        try {
            homeMapper.insert(home);
            return ResponseEntity.ok(ResponseResult.ok(homeMapper.selectById(home.getHomeId_zch_hwz_gjc())));
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
        }
    }

    @ResponseBody
    @PostMapping("/updateHome")
    public ResponseEntity<ResponseResult<?>> updateHome(
            @RequestBody Home home) {
        try {
            // 检查homeId是否存在，因为我们需要根据ID更新
            if (home.getHomeId_zch_hwz_gjc() == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("房屋编号不能为空"));
            }

            // 从数据库中查询当前记录
            Home currentHome = homeMapper.selectById(home.getHomeId_zch_hwz_gjc());
            if (currentHome == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("房屋编号不存在"));
            }

            // 更新需要修改的字段
            if (home.getHomeDayRent_zch_hwz_gjc() != null) {
                currentHome.setHomeDayRent_zch_hwz_gjc(home.getHomeDayRent_zch_hwz_gjc());
            }

            if (home.getHomeState_zch_hwz_gjc() != null && !home.getHomeState_zch_hwz_gjc().isEmpty()) {
                currentHome.setHomeState_zch_hwz_gjc(home.getHomeState_zch_hwz_gjc());
            }

            // 使用乐观锁更新方法
            int result = homeMapper.updateById(currentHome);

            // 检查是否有数据被更新
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok(homeMapper.selectById(home.getHomeId_zch_hwz_gjc())));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败，请重试"));
            }
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.badRequest().body(ResponseResult.error("更新失败，发生异常"));
        }
    }


    @ResponseBody
    @PostMapping("/insertHomeInf")
    public ResponseEntity<ResponseResult<?>> insertHomeInf(
            @RequestBody HomeInformation homeInformation) {
        try {
            // 设置房屋注册日期为当前时间
            homeInformation.setHomeInDate_zch_hwz_gjc(new Date());

            homeInformationMapper.insert(homeInformation);
            return ResponseEntity.ok(ResponseResult.ok(homeInformationMapper.selectById(homeInformation.getHomeInfId_zch_hwz_gjc())));
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
        }
    }
    @ResponseBody
    @PostMapping("/changeHomeInf")
    public ResponseEntity<ResponseResult<?>> changeHomeInf(
            @RequestBody HomeInformation homeInformation) {
        try {
            // 检查homeInfId是否存在，因为我们需要根据ID更新
            if (homeInformation.getHomeInfId_zch_hwz_gjc() == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("房屋信息编号不能为空"));
            }

            // 从数据库中查询当前记录
            HomeInformation currentHomeInf = homeInformationMapper.selectById(homeInformation.getHomeInfId_zch_hwz_gjc());
            if (currentHomeInf == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("房屋信息编号不存在"));
            }

            // 更新需要修改的字段
            if (homeInformation.getHomeArea_zch_hwz_gjc() != null) {
                currentHomeInf.setHomeArea_zch_hwz_gjc(homeInformation.getHomeArea_zch_hwz_gjc());
            }
            if (homeInformation.getHouseStructure_zch_hwz_gjc() != null && !homeInformation.getHouseStructure_zch_hwz_gjc().isEmpty()) {
                currentHomeInf.setHouseStructure_zch_hwz_gjc(homeInformation.getHouseStructure_zch_hwz_gjc());
            }
            if (homeInformation.getMaxPerson_zch_hwz_gjc() != null) {
                currentHomeInf.setMaxPerson_zch_hwz_gjc(homeInformation.getMaxPerson_zch_hwz_gjc());
            }
            if (homeInformation.getHomeDeposit_zch_hwz_gjc() != null) {
                currentHomeInf.setHomeDeposit_zch_hwz_gjc(homeInformation.getHomeDeposit_zch_hwz_gjc());
            }
            // ... 添加其他可变字段的更新逻辑

            // 使用乐观锁更新方法
            int result = homeInformationMapper.updateById(currentHomeInf);

            // 检查是否有数据被更新
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok(homeInformationMapper.selectById(homeInformation.getHomeInfId_zch_hwz_gjc())));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败，请重试"));
            }
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.badRequest().body(ResponseResult.error("更新失败，发生异常"));
        }
    }


}
