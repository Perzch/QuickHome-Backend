package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.quickhome.domain.*;
import com.quickhome.mapper.*;
import com.quickhome.pojo.PJFile;
import com.quickhome.pojo.PJUserHome;
import com.quickhome.pojo.PojoHome;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.*;
import com.quickhome.util.HandlePath;
import com.quickhome.util.ImageUtil;
import com.quickhome.util.TencentCOSUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Transactional
@Controller("HomeInfCon")
@RequestMapping("/home")
public class HomeInformationController {

    @Autowired
    private HomeMapper homeMapper;

    @Autowired
    private HomeInformationMapper homeInformationMapper;

    @Autowired
    private HouseCollectionMapper houseCollectionMapper;

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

    @Autowired
    private HomeImageMapper homeImageMapper;

    @Autowired
    private HomeImageService homeImageService;
    private static final List<String> ALLOWED_FILE_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/jpg");

    @Autowired
    private HomeDeviceMapper homeDeviceMapper;

    @Autowired
    private TencentCOSUtils tencentCOSUtils;

    /**
     * 插入设备
     *
     * @param homeDevice 设备信息
     * @return
     */

    @ResponseBody
    @PostMapping("/device")
    public ResponseEntity<ResponseResult<?>> insertHomeDevice(
            @RequestBody HomeDevice homeDevice) {
        try {
            homeDeviceMapper.insert(homeDevice);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.ok().body(ResponseResult.error("插入失败"));
        }
    }

    /**
     * 更新设备
     *
     * @param homeDevice 设备信息
     * @return
     */

    @ResponseBody
    @PutMapping("/device")
    public ResponseEntity<ResponseResult<?>> updateHomeDevice(
            @RequestBody HomeDevice homeDevice) {
        try {
            int result = homeDeviceMapper.updateById(homeDevice);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("更新失败，设备可能不存在或版本号不匹配"));
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.ok().body(ResponseResult.error("更新失败"));
        }
    }

    /**
     * 获取设备列表
     *
     * @param homeId  房间ID
     * @param current 当前页
     * @param size    每页大小
     * @return
     */
    @GetMapping("/device/list")
    public ResponseEntity<ResponseResult<?>> ListHomeDevice(
            @RequestParam Long homeId,
            @RequestParam(required = false, defaultValue = "1", name = "page") Integer current,
            @RequestParam(required = false, defaultValue = "10", name = "size") Integer size) {
        try {
            Page<HomeDevice> page = new Page<>(current, size);
            IPage<HomeDevice> devices = homeDeviceMapper.getDevicesByHomeId(page, homeId);
            return ResponseEntity.ok(ResponseResult.ok(devices));
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.ok().body(ResponseResult.error("获取设备列表失败"));
        }
    }

    /**
     * 删除设备
     *
     * @param deviceId 设备ID
     * @return
     */
    @DeleteMapping("/device/{deviceId}")
    public ResponseEntity<ResponseResult<?>> delHomeDev(@PathVariable("deviceId") Long deviceId) {
        try {
            // 构建查询条件
            QueryWrapper<HomeDevice> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deviceID_zch_hwz_gjc", deviceId);

            int result = homeDeviceMapper.delete(queryWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("删除失败，设备可能不存在或已被删除"));
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
        }
    }

    /**
     * 检查房间是否可用
     *
     * @param homeId    房间ID
     * @param beginDate 开始日期
     * @param endDate   结束日期
     * @return
     */
    @GetMapping("/check")
    public ResponseEntity<?> checkHomeAvailability(@RequestParam Long homeId,
                                                   @RequestParam String beginDate,
                                                   @RequestParam String endDate) {
        boolean isAvailable = homeSer_zch_hwz_gjc.checkHomeAvailability(homeId, beginDate, endDate);
        if (isAvailable) {
            return ResponseEntity.ok(ResponseResult.ok("房屋可用"));
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("房屋不可用"));
        }
    }

    /**
     * 获取房间图片
     *
     * @param homeId 房间ID
     * @return
     */
    @SneakyThrows
    @ResponseBody
    @GetMapping("/img/{homeId}")
    public ResponseEntity<ResponseResult<?>> getHomeImg(@PathVariable("homeId") Long homeId) {
        QueryWrapper<HomeImage> wrapper = new QueryWrapper<>();
        wrapper.eq("homeId_zch_hwz_gjc", homeId);
        wrapper.eq("deleted_zch_hwz_gjc", 0);
        List<HomeImage> images = homeImageMapper.selectList(wrapper);
        if (images.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ResponseResult.ok(images));
    }

    /**
     * 删除房间图片
     *
     * @param homeId    房间ID
     * @return
     */

    @DeleteMapping("/img/{homeId}")
    public ResponseEntity<?> deleteHomeImg(@PathVariable("homeId") Long homeId) {
        try {
            // 拼接attractionId和时间戳
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String combinedString = homeId.toString() + "-" + timestamp;

            // 使用拼接后的字符串去数据库中查找
            QueryWrapper<HomeImage> wrapper = new QueryWrapper<>();
            wrapper.like("imagePath_zch_hwz_gjc", combinedString);

            HomeImage image = homeImageMapper.selectOne(wrapper);
            if (image != null) {
                ImageUtil.deleteImg(image.getImagePath_zch_hwz_gjc());
                UpdateWrapper<HomeImage> updateWrapper = new UpdateWrapper<>();
                updateWrapper.like("imagePath_zch_hwz_gjc", combinedString)
                        .set("deleted_zch_hwz_gjc", 1);

                int result = homeImageMapper.update(null, updateWrapper);
                if (result > 0) {
                    return ResponseEntity.ok(ResponseResult.ok());
                } else {
                    return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
                }
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("图片不存在"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("删除图片出错"));
        }
    }

    /**
     * 上传房间图片
     *
     * @return
     * @throws IOException
     */

    @ResponseBody
    @PostMapping("/img")
    public ResponseEntity<ResponseResult<?>> addHomeImg(@RequestBody @ModelAttribute PJFile pjFile,
                                                        HttpServletRequest req) throws IOException {
        if (!ALLOWED_FILE_TYPES.contains(pjFile.getFile().getContentType())) {
            return ResponseEntity.ok().body(ResponseResult.error("文件类型错误"));
        }

        String imagePath = saveUploadedFile(pjFile.getHomeId(), pjFile.getFile());
        if (imagePath != null) {
            imagePath = HandlePath.extractRelativePath(imagePath, "image/HomeImg/");
        }

        HomeImage homeImage = homeImageService.saveHomeImg(pjFile.getHomeId(), imagePath);

        return ResponseEntity.ok(ResponseResult.ok(homeImage));
    }

    private String saveUploadedFile(Long homeId, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = homeId + "-" + timestamp + "." + getFileExtension(file.getOriginalFilename());
        try {

            return tencentCOSUtils.upload(file, newFileName, "HomeImg");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file to Tencent COS", e);
        }
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


    /**
     * 获取房屋信息
     *
     * @param homeType  房屋类型
     * @param beginDate 入住日期
     * @param endDate   退房日期
     * @param minRent   最低租金
     * @param maxRent   最高租金
     * @param address   模糊地址关键字
     * @param maxPeople 最大入住人数
     * @param page      最大回传显示页数
     * @param size      单页最大显示条数
     * @return 房屋信息
     */

    @GetMapping("/list")//获取房屋信息（复合模糊查询）
    @ResponseBody
    public ResponseEntity<?> getHomeInf(@RequestParam(required = false, defaultValue = "") String homeType,//房屋类型
                                        @RequestParam(required = false) String beginDate,//入住日期
                                        @RequestParam(required = false) String endDate,//退房日期
                                        @RequestParam(required = false, defaultValue = "") String device,//房屋设备
                                        @RequestParam(required = false, defaultValue = "0.0") double minRent,//最低租金
                                        @RequestParam(required = false, defaultValue = "10000.0") double maxRent,//最高租金
                                        @RequestParam(required = false, defaultValue = "") String address,//模糊地址关键字
                                        @RequestParam(required = false, defaultValue = "1") int maxPeople,//最大入住人数
                                        @RequestParam(defaultValue = "1") int page,//最大回传显示页数
                                        @RequestParam(required = false, defaultValue = "10") int size,//单页最大显示条数
                                        HttpServletRequest req) {
        List<String> deviceNames = Arrays.asList(device.split(","));
        List<PojoHome> pojoHomes = homeSer_zch_hwz_gjc.getHomesByCriteriaWithDevices(beginDate, endDate, address, minRent, maxRent, deviceNames, maxPeople, homeType, page, size);

        List<PojoHome> pojoHomeList = new ArrayList<>();
        for (PojoHome pojoHome : pojoHomes) {
            Home home = homeSer_zch_hwz_gjc.getById(pojoHome.getHomeId_zch_hwz_gjc());
            home.setHomeImageList(home.getHomeImages_zch_hwz_gjc().split(","));//将房屋图片路径分割成数组
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

    @GetMapping("/list/back")
    @ResponseBody
    public ResponseEntity<?> adminGetHome(@RequestParam(required = false, defaultValue = "") String homeType,//房屋类型
                                        @RequestParam(required = false, defaultValue = "") String device,//房屋设备
                                        @RequestParam(required = false, defaultValue = "0.0") double minRent,//最低租金
                                        @RequestParam(required = false, defaultValue = "10000.0") double maxRent,//最高租金
                                        @RequestParam(required = false, defaultValue = "") String address,//模糊地址关键字
                                        @RequestParam(required = false, defaultValue = "0") int maxPeople,//最大入住人数
                                        @RequestParam(defaultValue = "1") int page,//最大回传显示页数
                                        @RequestParam(required = false, defaultValue = "10") int size,//单页最大显示条数
                                        HttpServletRequest req) {
        List<String> deviceNames = Arrays.asList(device.split(","));

        IPage<Home> homePage = homeSer_zch_hwz_gjc.getHomesByCriteriaWithDevices(address, minRent, maxRent, deviceNames, maxPeople, homeType, page, size);
        List<PojoHome> pojoHomes = new ArrayList<>();
        homePage.getRecords().forEach(home -> {
            HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
            List<HomeDevice> devices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
            PojoHome pojoHome = new PojoHome();
            pojoHome.setHomeInformation(homeInformation);
            pojoHome.setHome(home);
            pojoHome.setHomeDeviceList(devices);
            pojoHome.setCollectionCount(houseCollectionService.getCollectionCountByHomeId(home.getHomeId_zch_hwz_gjc()));
            pojoHome.setHomeId_zch_hwz_gjc(home.getHomeId_zch_hwz_gjc());
            pojoHomes.add(pojoHome);
        });
        Page<PojoHome> pojoHomePage = new Page<>(page,size);
        pojoHomePage.setRecords(pojoHomes);
        pojoHomePage.setTotal(homePage.getTotal());
        pojoHomePage.setCurrent(homePage.getCurrent());
        pojoHomePage.setSize(homePage.getSize());
        pojoHomePage.setPages(homePage.getPages());
        pojoHomePage.setOptimizeCountSql(homePage.optimizeCountSql());
        return ResponseEntity.ok(ResponseResult.ok(pojoHomePage));
    }

    /**
     * 检查房屋收藏状态
     *
     * @param userId 用户ID
     * @param homeId 房屋ID
     * @return 收藏状态
     */

    @GetMapping("/collection/check")
    @ResponseBody
    public ResponseEntity<ResponseResult<?>> checkHomeCollectionStatus(
            @RequestParam Long userId,
            @RequestParam Long homeId) {
        try {
            QueryWrapper<HouseCollection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", userId);
            queryWrapper.eq("homeId_zch_hwz_gjc", homeId);
            queryWrapper.eq("deleted_zch_hwz_gjc", 0);
            Long count = houseCollectionMapper.selectCount(queryWrapper);
            boolean isCollected = count > 0;
            return ResponseEntity.ok(ResponseResult.ok(isCollected));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("查询收藏状态出错"));
        }
    }


    /**
     * 通过ID获取房屋信息
     *
     * @param id  房屋ID
     * @param req 请求
     * @return 房屋信息
     */
    @GetMapping("/{id}")//获取房屋信息通过id
    @ResponseBody
    public ResponseEntity<ResponseResult<?>> getHomeInfById(@PathVariable("id") Long id,
                                                            HttpServletRequest req) {
        PojoHome pojoHome = new PojoHome();
        Home home = homeSer_zch_hwz_gjc.getById(id);
        home.setHomeImageList(home.getHomeImages_zch_hwz_gjc().split(","));
        pojoHome.setHome(home);
        HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setHomeInformation(homeInformation);
        List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setHomeDeviceList(homeDevices);
        List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setHomeImageList(homeImages);
        int collectionNum = houseCollectionService.getCollectionCountByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setCollectionCount(collectionNum);
        pojoHome.setHomeId_zch_hwz_gjc(home.getHomeId_zch_hwz_gjc());
        return ResponseEntity.ok(ResponseResult.ok(pojoHome));
    }

    /**
     * 获取热门房屋信息
     *
     * @return 热门房屋信息
     */

    @GetMapping("/byCollection") //获取热门房屋信息
    @ResponseBody
    public ResponseEntity<ResponseResult<?>> getHomeListOrderByCollectionCount() {
        List<PojoHome> homeList = homeSer_zch_hwz_gjc.getHomeListOrderByCollectionCount();
        List<PojoHome> pojoHomeList = new ArrayList<>();
        for (PojoHome pojoHome : homeList) {
            Home home = homeSer_zch_hwz_gjc.getById(pojoHome.getHomeId_zch_hwz_gjc());
            home.setHomeImageList(home.getHomeImages_zch_hwz_gjc().split(","));
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


    /**
     * 插入房屋信息
     *
     * @param pojoHome 房屋信息
     * @return
     */

    @ResponseBody
    @PostMapping
    public ResponseEntity<ResponseResult<?>> insertHome(
            @RequestBody PojoHome pojoHome) {
        try {
            homeSer_zch_hwz_gjc.save(pojoHome.getHome());
            homeInfSer_zch_hwz_gjc.save(pojoHome.getHomeInformation());
            homeDeviceSer_zch_hwz_gjc.saveBatch(pojoHome.getHomeDeviceList());
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.ok().body(ResponseResult.error("插入失败"));
        }
    }

    /**
     * 更新房屋信息
     *
     * @param pojoHome 房屋信息
     * @return
     */

    @ResponseBody
    @PutMapping
    public ResponseEntity<ResponseResult<?>> updateHome(
            @RequestBody PojoHome pojoHome) {
        boolean homeResult = homeSer_zch_hwz_gjc.updateById(pojoHome.getHome());
        boolean infoResult = homeInfSer_zch_hwz_gjc.updateById(pojoHome.getHomeInformation());
//        调用saveOrUpdateBatch方法，如果数据库中没有该条数据则插入，有则更新
        boolean deviceResult = homeDeviceSer_zch_hwz_gjc.saveOrUpdateBatch(pojoHome.getHomeDeviceList());
        if (homeResult && infoResult && deviceResult) {
            return ResponseEntity.ok(ResponseResult.ok());
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("更新失败"));
        }
    }

    /**
     * 插入房屋信息
     *
     * @param homeInformation 房屋信息
     * @return
     */

    @ResponseBody
    @PostMapping("/info")
    public ResponseEntity<ResponseResult<?>> insertHomeInf(
            @RequestBody HomeInformation homeInformation) {
        try {
            // 设置房屋注册日期为当前时间
            homeInformation.setHomeInDate_zch_hwz_gjc(new Date());

            homeInformationMapper.insert(homeInformation);
            return ResponseEntity.ok(ResponseResult.ok(homeInformationMapper.selectById(homeInformation.getHomeInfId_zch_hwz_gjc())));
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.ok().body(ResponseResult.error("插入失败"));
        }
    }


    /**
     * 更新房屋信息
     *
     * @param homeInformation 房屋信息
     * @return
     */
    @ResponseBody
    @PutMapping("/info")
    public ResponseEntity<ResponseResult<?>> changeHomeInf(
            @RequestBody HomeInformation homeInformation) {
        try {
            // 检查homeInfId是否存在，因为我们需要根据ID更新
            if (homeInformation.getHomeInfId_zch_hwz_gjc() == null) {
                return ResponseEntity.ok().body(ResponseResult.error("房屋信息编号不能为空"));
            }

            // 从数据库中查询当前记录
            HomeInformation currentHomeInf = homeInformationMapper.selectById(homeInformation.getHomeInfId_zch_hwz_gjc());
            if (currentHomeInf == null) {
                return ResponseEntity.ok().body(ResponseResult.error("房屋信息编号不存在"));
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
                return ResponseEntity.ok().body(ResponseResult.error("更新失败，请重试"));
            }
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            return ResponseEntity.ok().body(ResponseResult.error("更新失败，发生异常"));
        }
    }

    /**
     * 获取用户收藏房屋列表
     *
     * @param userId   用户ID
     * @param pageNo   页码
     * @param pageSize 每页大小
     * @return
     */

    @GetMapping("/collection/list")
    public ResponseEntity<?> getUserHomeList(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "page", defaultValue = "1") int pageNo,
            @RequestParam(value = "size", defaultValue = "10") int pageSize) {
        try {
            Page<HouseCollection> resultPage = houseCollectionService.getUserHomeCollections(userId, pageNo, pageSize);
            return ResponseEntity.ok(ResponseResult.ok(resultPage));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("获取房屋收藏列表出错"));
        }
    }

    /**
     * 取消收藏房屋
     *
     * @return
     */

    @DeleteMapping("/collection")
    public ResponseEntity<?> cancelHomeCollection(@RequestBody PJUserHome userHome) {
        try {
            UpdateWrapper<HouseCollection> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("userId_zch_hwz_gjc", userHome.getUserId())
                    .eq("homeId_zch_hwz_gjc", userHome.getHomeId())
                    .set("deleted_zch_hwz_gjc", 1);

            int result = houseCollectionMapper.update(null, updateWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok("取消收藏成功"));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("取消收藏失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("取消收藏出错"));
        }
    }

    /**
     * 收藏房屋
     *
     * @return
     */

    @PostMapping("/collection")
    public ResponseEntity<?> addHomeCollection(@RequestBody PJUserHome userHome) {
        try {
            boolean result = houseCollectionService.addHouseCollection(userHome);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("收藏成功"));
            } else {
                return ResponseEntity.ok(ResponseResult.error("已收藏"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("收藏房屋出错"));
        }
    }

    /**
     * 删除房屋
     *
     * @param homeId 房屋ID
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> deleteHome(@PathVariable("id") Long homeId) {
        try {
            Home home = homeMapper.selectById(homeId);
            if (home == null) {
                return ResponseEntity.ok().body(ResponseResult.error("房屋不存在"));
            }
            boolean homeResult = homeSer_zch_hwz_gjc.removeById(homeId);
            boolean infoResult = homeInfSer_zch_hwz_gjc.removeById(homeId);
            if (homeResult && infoResult){
                return ResponseEntity.ok(ResponseResult.ok("删除成功"));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
        }
    }
}
