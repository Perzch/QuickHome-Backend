package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.*;
import com.quickhome.mapper.*;
import com.quickhome.pojo.PojoHome;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.*;
import com.quickhome.util.ImageUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Transactional
@Controller("HomeInfCon")
@RequestMapping("/homeInf")
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

    @ResponseBody
    @PostMapping("/insertHomeDevice")
    public ResponseEntity<ResponseResult<?>> insertHomeDevice(
            @RequestBody HomeDevice homeDevice) {
        try {
            homeDeviceMapper.insert(homeDevice);
            return ResponseEntity.ok(ResponseResult.ok());
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
        }
    }

    @ResponseBody
    @PutMapping("/updateHomeDevice")
    public ResponseEntity<ResponseResult<?>> updateHomeDevice(
            @RequestBody HomeDevice homeDevice) {
        try {
            int result = homeDeviceMapper.updateById(homeDevice);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败，设备可能不存在或版本号不匹配"));
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.badRequest().body(ResponseResult.error("更新失败"));
        }
    }

    @GetMapping("/getHomeDevice")
    public ResponseEntity<ResponseResult<?>> getHomeDevice(
            @RequestParam Long homeId,
            @RequestParam(required = false, defaultValue = "1") Integer current,
            @RequestParam(required = false, defaultValue = "10") Integer size) {
        try {
            Page<HomeDevice> page = new Page<>(current, size);
            IPage<HomeDevice> devices = homeDeviceMapper.getDevicesByHomeId(page, homeId);
            return ResponseEntity.ok(ResponseResult.ok(devices));
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.badRequest().body(ResponseResult.error("获取设备列表失败"));
        }
    }

    @DeleteMapping("/delHomeDev")
    public ResponseEntity<ResponseResult<?>> delHomeDev(@RequestParam Long deviceId) {
        try {
            // 构建查询条件
            QueryWrapper<HomeDevice> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("deviceID_zch_hwz_gjc", deviceId);

            int result = homeDeviceMapper.delete(queryWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("删除失败，设备可能不存在或已被删除"));
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
        }
    }


//    @SneakyThrows
//    @ResponseBody
//    @GetMapping("/getHomeImg")
//    public ResponseEntity<Resource> getHomeImg(@RequestParam Long homeId) {
//        QueryWrapper<HomeImage> wrapper = new QueryWrapper<>();
//        wrapper.eq("homeId_zch_hwz_gjc", homeId);
//        wrapper.eq("deleted_zch_hwz_gjc", 0);
//        List<HomeImage> images = homeImageMapper.selectList(wrapper);
//        if (images.size() == 0) {
//            return ResponseEntity.notFound().build();
//        }
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        ZipOutputStream zos = new ZipOutputStream(baos);
//
//        try {
//            for (HomeImage image : images) {
//                Path path = Paths.get(image.getImagePath_zch_hwz_gjc());
//                FileInputStream fis = new FileInputStream(path.toFile());
//                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
//                zos.putNextEntry(zipEntry);
//
//                byte[] buffer = new byte[1024];
//                int len;
//                while ((len = fis.read(buffer)) > 0) {
//                    zos.write(buffer, 0, len);
//                }
//                zos.closeEntry();
//                fis.close();
//            }
//            zos.close();
//
//            ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());
//            return ResponseEntity.ok()
//                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=homeImages.zip")
//                    .body(resource);
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().build();
//        }
//    }


    @SneakyThrows
    @ResponseBody
    @GetMapping("/getHomeImg")
    public ResponseEntity<ResponseResult<?>> getHomeImg(@RequestParam Long homeId) {
        QueryWrapper<HomeImage> wrapper = new QueryWrapper<>();
        wrapper.eq("homeId_zch_hwz_gjc", homeId);
        wrapper.eq("deleted_zch_hwz_gjc", 0);
        List<HomeImage> images = homeImageMapper.selectList(wrapper);
        if (images.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        List<String> imageUrls = new ArrayList<>();
        try {
            for (HomeImage image : images) {
                Path fullPath = Paths.get(image.getImagePath_zch_hwz_gjc());
                Path relativePath = Paths.get("E:/Spring boot/uploads").relativize(fullPath);
                String imageUrl = "/image/" + relativePath.toString().replace("\\", "/");
                imageUrls.add(imageUrl);
            }

            Map<String, List<String>> response = new HashMap<>();
            response.put("imageUrls", imageUrls);
            return ResponseEntity.ok(ResponseResult.ok(response));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteHomeImg")
    public ResponseEntity<?> deleteHomeImg(@RequestParam Long homeId, @RequestParam String timestamp) {
        try {
            // 拼接attractionId和时间戳
            String combinedString = homeId.toString() +"-"+ timestamp;

            // 使用拼接后的字符串去数据库中查找
            QueryWrapper<HomeImage> wrapper = new QueryWrapper<>();
            wrapper.like("imagePath_zch_hwz_gjc", combinedString);
            wrapper.eq("deleted_zch_hwz_gjc", 0);

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
                    return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
                }
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("图片不存在"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("删除图片出错"));
        }
    }


    @ResponseBody
    @PostMapping("/addHomeImg")
    public ResponseEntity<ResponseResult<?>> addHomeImg(
            @RequestParam("homeId") Long homeId,
            @RequestParam("file") MultipartFile file,
            HttpServletRequest req) throws IOException {
        if (!ALLOWED_FILE_TYPES.contains(file.getContentType())) {
            return ResponseEntity.badRequest().body(ResponseResult.error("文件类型错误"));
        }

        String imagePath = saveUploadedFile(homeId, file);

        HomeImage homeImage = homeImageService.saveHomeImg(homeId, imagePath);

        return ResponseEntity.ok(ResponseResult.ok(homeImage));
    }

    private String saveUploadedFile(Long homeId, MultipartFile file) throws IOException {
        String uploadDir = "E:/Spring boot/uploads/HomeImg/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = homeId + "-" + timestamp + "." + getFileExtension(file.getOriginalFilename());
        String filePath = uploadDir + newFileName;
        file.transferTo(new File(filePath));
        return filePath;
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }


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
            List<HomeImage> formattedImageList = new ArrayList<>();
            for (HomeImage image : homeImages) {
                try {
                    Path fullPath = Paths.get(image.getImagePath_zch_hwz_gjc());
                    Path relativePath = Paths.get("E:/Spring boot/uploads").relativize(fullPath);
                    String imageUrl = "/image/" + relativePath.toString().replace("\\", "/");
                    image.setImagePath_zch_hwz_gjc(imageUrl);
                    formattedImageList.add(image);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            pojoHome.setHomeImageList(formattedImageList);
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
    public ResponseEntity<ResponseResult<?>> getHomeInfById(@RequestParam Long id,
                                            HttpServletRequest req) {
        PojoHome pojoHome = new PojoHome();
        Home home = homeSer_zch_hwz_gjc.getById(id);
        pojoHome.setHome(home);
        HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setHomeInformation(homeInformation);
        List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setHomeDeviceList(homeDevices);
        List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
        List<HomeImage> formattedImageList = new ArrayList<>();
        for (HomeImage image : homeImages) {
            try {
                Path fullPath = Paths.get(image.getImagePath_zch_hwz_gjc());
                Path relativePath = Paths.get("E:/Spring boot/uploads").relativize(fullPath);
                String imageUrl = "/image/" + relativePath.toString().replace("\\", "/");
                image.setImagePath_zch_hwz_gjc(imageUrl);
                formattedImageList.add(image);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        pojoHome.setHomeImageList(formattedImageList);
        int collectionNum = houseCollectionService.getCollectionCountByHomeId(home.getHomeId_zch_hwz_gjc());
        pojoHome.setCollectionCount(collectionNum);
        pojoHome.setHomeId_zch_hwz_gjc(home.getHomeId_zch_hwz_gjc());
        return ResponseEntity.ok(ResponseResult.ok(pojoHome));
    }



//    @GetMapping("/getHomeListOrderByCollectionCount")//获取热门房屋信息
//    @ResponseBody
//    public ResponseEntity<?> getHomeListOrderByCollectionCount() {
//        List<PojoHome> homeList = homeSer_zch_hwz_gjc.getHomeListOrderByCollectionCount();
//        List<PojoHome> pojoHomeList = new ArrayList<>();
//        for (PojoHome pojoHome : homeList) {
//            Home home = homeSer_zch_hwz_gjc.getById(pojoHome.getHomeId_zch_hwz_gjc());
//            pojoHome.setHome(home);
//            HomeInformation homeInformation = homeInfSer_zch_hwz_gjc.getByHomeId(home.getHomeId_zch_hwz_gjc());
//            pojoHome.setHomeInformation(homeInformation);
//            List<HomeDevice> homeDevices = homeDeviceSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
//            pojoHome.setHomeDeviceList(homeDevices);
//            List<HomeImage> homeImages = homeImageSer_zch_hwz_gjc.getAllByHomeId(home.getHomeId_zch_hwz_gjc());
//            pojoHome.setHomeImageList(homeImages);
//            pojoHomeList.add(pojoHome);
//        }
//        return ResponseEntity.ok(ResponseResult.ok(pojoHomeList));
//    }

    @GetMapping("/getHomeListOrderByCollectionCount") //获取热门房屋信息
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
            List<HomeImage> formattedImageList = new ArrayList<>();
            for (HomeImage image : homeImages) {
                try {
                    Path fullPath = Paths.get(image.getImagePath_zch_hwz_gjc());
                    Path relativePath = Paths.get("E:/Spring boot/uploads").relativize(fullPath);
                    String imageUrl = "/image/" + relativePath.toString().replace("\\", "/");
                    image.setImagePath_zch_hwz_gjc(imageUrl);
                    formattedImageList.add(image);
                } catch (Exception e) {
                    // Handle exception if necessary
                }
            }
            pojoHome.setHomeImageList(formattedImageList);
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

    @GetMapping("/getUserHomeList")
    public ResponseEntity<?> getUserHomeList(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            Page<HouseCollection> resultPage = houseCollectionService.getUserHomeCollections(userId, pageNo, pageSize);
            return ResponseEntity.ok(ResponseResult.ok(resultPage));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("获取房屋收藏列表出错"));
        }
    }

    @PutMapping("/cancelHome")
    public ResponseEntity<?> cancelHomeCollection(
            @RequestParam("userId") Long userId,
            @RequestParam("homeId") Long homeId) {
        try {
            UpdateWrapper<HouseCollection> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("userId_zch_hwz_gjc", userId)
                    .eq("homeId_zch_hwz_gjc", homeId)
                    .set("deleted_zch_hwz_gjc", 1);

            int result = houseCollectionMapper.update(null, updateWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok("取消收藏成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("取消收藏失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("取消收藏出错"));
        }
    }

    @PostMapping("/addHomeCollection")
    public ResponseEntity<?> addHomeCollection(
            @RequestParam("userId") Long userId,
            @RequestParam("homeId") Long homeId) {
        try {
            boolean result = houseCollectionService.addHouseCollection(userId, homeId);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("收藏成功"));
            } else {
                return ResponseEntity.ok(ResponseResult.error("已收藏"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("收藏房屋出错"));
        }
    }


}
