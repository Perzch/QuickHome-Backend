package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.AttractionCollection;
import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.Attraction;
import com.quickhome.mapper.AttractionCollectionMapper;
import com.quickhome.mapper.AttractionImageMapper;
import com.quickhome.mapper.AttractionMapper;
import com.quickhome.pojo.PJFile;
import com.quickhome.pojo.PojoAttraction;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.AttractionCollectionService;
import com.quickhome.service.AttractionImageService;
import com.quickhome.service.AttractionService;
import com.quickhome.util.HandlePath;
import com.quickhome.util.ImageUtil;
import com.quickhome.util.TencentCOSUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Transactional
@Controller("AttractionCon")
@RequestMapping("/attraction")
public class AttractionController {
    @Autowired
    private AttractionService attractionService;

    @Autowired
    private AttractionImageService attractionImageService;

    @Autowired
    private AttractionImageMapper attractionImageMapper;

    @Autowired
    private AttractionMapper attractionMapper;
    @Autowired
    private AttractionCollectionMapper attractionCollectionMapper;
    @Autowired
    private AttractionCollectionService attractionCollectionService;

    @Autowired
    private TencentCOSUtils tencentCOSUtils;
    private static final List<String> ALLOWED_FILE_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/jpg");

    /**
     * 获取景点图片
     *
     * @param attractionId 景点id
     * @return
     */
    @SneakyThrows
    @ResponseBody
    @GetMapping("/img/{id}")
    public ResponseEntity<ResponseResult<?>> getAttractionImg(@RequestParam("id") Long attractionId) {
        QueryWrapper<AttractionImage> wrapper = new QueryWrapper<>();
        wrapper.eq("attractionId_zch_hwz_gjc", attractionId);
        wrapper.eq("deleted_zch_hwz_gjc", 0);
        List<AttractionImage> images = attractionImageMapper.selectList(wrapper);
        if (images.size() == 0) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ResponseResult.ok(images));
    }

    /**
     * 检查用户是否收藏该景点
     *
     * @param userId       用户id
     * @param attractionId 景点id
     * @return
     */

    @GetMapping("/collection/check")
    @ResponseBody
    public ResponseEntity<ResponseResult<?>> checkAttractionCollectionStatus(
            @RequestParam Long userId,
            @RequestParam Long attractionId) {
        try {
            QueryWrapper<AttractionCollection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", userId);
            queryWrapper.eq("attractionId_zch_hwz_gjc", attractionId);
            Long count = attractionCollectionMapper.selectCount(queryWrapper);
            boolean isCollected = count > 0;
            return ResponseEntity.ok(ResponseResult.ok(isCollected));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("查询收藏状态出错"));
        }
    }

    /**
     * 删除景点图片
     *
     * @param attractionId 景点id
     * @return
     */

    @DeleteMapping("/img/{id}")
    public ResponseEntity<ResponseResult<?>> deleteAttractionByTimestamp(@PathVariable("id") Long attractionId) {
        try {
            // 拼接attractionId和时间戳
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String combinedString = attractionId.toString() + "-" + timestamp;

            // 使用拼接后的字符串去数据库中查找
            QueryWrapper<AttractionImage> wrapper = new QueryWrapper<>();
            wrapper.like("imagePath_zch_hwz_gjc", combinedString);
            wrapper.eq("deleted_zch_hwz_gjc", 0);

            AttractionImage image = attractionImageMapper.selectOne(wrapper);
            if (image != null) {
                ImageUtil.deleteImg(image.getImagePath_zch_hwz_gjc());
                UpdateWrapper<AttractionImage> updateWrapper = new UpdateWrapper<>();
                updateWrapper.like("imagePath_zch_hwz_gjc", combinedString)
                        .set("deleted_zch_hwz_gjc", 1);

                int result = attractionImageMapper.update(null, updateWrapper);
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
     * 上传景点图片
     *
     * @param req          请求
     * @return
     * @throws IOException
     */

    @ResponseBody
    @PostMapping("/img")
    public ResponseEntity<ResponseResult<?>> insertAttractionImg(@RequestBody @ModelAttribute PJFile pjFile,
                                                                 HttpServletRequest req) throws IOException {
        if (!ALLOWED_FILE_TYPES.contains(pjFile.getFile().getContentType())) {
            return ResponseEntity.ok().body(ResponseResult.error("文件类型错误"));
        }

        String imagePath = saveUploadedFile(pjFile.getAttractionId(), pjFile.getFile());

        if (imagePath != null) {
            imagePath = HandlePath.extractRelativePath(imagePath, "image/AttractionImg/");
        }

        AttractionImage attractionImage = attractionImageService.saveAttractionImg(pjFile.getAttractionId(), imagePath);

        return ResponseEntity.ok(ResponseResult.ok(attractionImage));
    }

    private String saveUploadedFile(Long attractionId, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = attractionId + "-" + timestamp + "." + getFileExtension(file.getOriginalFilename());
        try {
            return tencentCOSUtils.upload(file, newFileName, "AttractionImg");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file to Tencent COS", e);
        }
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 按收藏数量获取景点列表
     *
     * @return 景点信息列表
     */
    @GetMapping("/byCollection")
    @ResponseBody
    public ResponseEntity<ResponseResult<List<PojoAttraction>>> getAttractionListOrderByCollectionCount() {
        List<PojoAttraction> pojoAttractionList = attractionService.getAttractionListOrderByCollectionCount();
        for (PojoAttraction pojoAttraction : pojoAttractionList) {
            Attraction attraction = attractionService.getById(pojoAttraction.getAttractionId());
            pojoAttraction.setAttraction(attraction);
            List<AttractionImage> attractionImageList = attractionImageService.getAttractionImageListById(pojoAttraction.getAttractionId());
            pojoAttraction.setAttractionImageList(attractionImageList);
        }
        return ResponseEntity.ok(ResponseResult.ok(pojoAttractionList));
    }

    /**
     * 插入景点
     *
     * @param attraction 景点信息
     * @return
     */

    @PostMapping
    public ResponseEntity<?> insertAttraction(@RequestBody Attraction attraction) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            attraction.setAttractionInDate_zch_hwz_gjc(date);
            attractionMapper.insert(attraction);
            return ResponseEntity.ok(ResponseResult.ok("插入成功"));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("插入失败"));
        }
    }

    /**
     * 根据景点id获取景点信息
     *
     * @param attractionId 景点id
     * @param req          请求
     * @return
     */

    @GetMapping("/{id}")
    public ResponseEntity<?> getAttractionById(@PathVariable("id") Long attractionId,
                                               HttpServletRequest req) {
        try {
            Attraction attraction = attractionService.getById(attractionId);
            if(Objects.isNull(attraction)) {
                return ResponseEntity.ok().body(ResponseResult.error("未找到"));
            }
//            获取景区收藏数
            attraction.setCollectionCount((int) attractionCollectionService.count(
                    new QueryWrapper<>(
                            AttractionCollection.builder()
                                    .attractionId_zch_hwz_gjc(attraction.getAttractionId_zch_hwz_gjc()).build()
                    )
            ));
            attraction.setAttractionImageList(attraction.getAttractionImages_zch_hwz_gjc().split(","));
            return ResponseEntity.ok(ResponseResult.ok(attraction));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("Error fetching attraction details"));
        }
    }

    /**
     * 查询景点列表
     *
     * @param pageNo          页码
     * @param pageSize        每页大小
     * @param attractionName 景点名称
     * @return
     */

    @GetMapping("/list")
    public ResponseEntity<ResponseResult<?>> queryAttractions(
            @RequestParam(value = "page", defaultValue = "1") int pageNo,
            @RequestParam(value = "size", defaultValue = "10") int pageSize,
            @RequestParam(value = "attractionName", required = false) String attractionName) {
        try {
            Page<Attraction> page = new Page<>(pageNo, pageSize);
            QueryWrapper<Attraction> queryWrapper = new QueryWrapper<>();
            if (attractionName != null && !attractionName.trim().isEmpty()) {
                queryWrapper.like("attractionName_zch_hwz_gjc", attractionName);
            }
            IPage<Attraction> attractionsPage = attractionMapper.selectPage(page, queryWrapper);

            for (Attraction record : attractionsPage.getRecords()) {
//                计算收藏数
                record.setCollectionCount((int) attractionCollectionService.count(
                        new QueryWrapper<>(
                                AttractionCollection.builder()
                                        .attractionId_zch_hwz_gjc(record.getAttractionId_zch_hwz_gjc()).build()
                        )
                ));
//                将图片路径转换为数组
                record.setAttractionImageList(record.getAttractionImages_zch_hwz_gjc().split(","));
            }
//
//            List<PojoAttraction> pojoAttractionList = new ArrayList<>();
//            for (Attraction attraction : attractionsPage.getRecords()) {
//                PojoAttraction pojoAttraction = new PojoAttraction();
//                pojoAttraction.setAttractionId(attraction.getAttractionId_zch_hwz_gjc());
//                pojoAttraction.setAttraction(attraction);
//
//                // 计算收藏数
//                QueryWrapper<AttractionCollection> collectionWrapper = new QueryWrapper<>();
//                collectionWrapper.eq("attractionId_zch_hwz_gjc", attraction.getAttractionId_zch_hwz_gjc());
//                collectionWrapper.eq("deleted_zch_hwz_gjc", 0);
//                Integer collectionCount = Math.toIntExact(attractionCollectionMapper.selectCount(collectionWrapper));
//                pojoAttraction.setCollectionCount(collectionCount);
//
//                // 获取图片
//                QueryWrapper<AttractionImage> imageWrapper = new QueryWrapper<>();
//                imageWrapper.eq("attractionId_zch_hwz_gjc", attraction.getAttractionId_zch_hwz_gjc());
//                imageWrapper.eq("deleted_zch_hwz_gjc", 0);
//                List<AttractionImage> images = attractionImageMapper.selectList(imageWrapper);
//                pojoAttraction.setAttractionImageList(images);
//
//                pojoAttractionList.add(pojoAttraction);
//            }
//
//            Page<PojoAttraction> pojoAttractionPage = new Page<>(pageNo, pageSize);
//            pojoAttractionPage.setRecords(pojoAttractionList);
//            pojoAttractionPage.setTotal(attractionsPage.getTotal());

            return ResponseEntity.ok(ResponseResult.ok(attractionsPage));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("获取景点列表出错"));
        }
    }

    /**
     * 更新景点信息
     *
     * @param attraction 景点信息
     * @return
     */

    @PutMapping
    public ResponseEntity<?> updateAttraction(@RequestBody Attraction attraction) {
        try {
            if (attraction.getAttractionId_zch_hwz_gjc() == null) {
                return ResponseEntity.ok().body(ResponseResult.error("景点ID不能为空"));
            }
            boolean result = attractionService.updateById(attraction);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok(attraction));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("更新失败，请重试"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("更新景点信息出错"));
        }
    }

    /**
     * 删除景点信息
     *
     * @param attractionId 景点ID
     * @return
     */

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAttraction(@PathVariable("id") Long[] attractionId) {
        try {
            boolean result = attractionService.removeBatchByIds(Arrays.asList(attractionId));
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("删除景点信息出错"));
        }
    }

    /**
     * 添加景点收藏
     *
     * @param ac 收藏信息
     * @return
     */

    @PostMapping("/collection")
    public ResponseEntity<?> addAttractionCollection(
            @RequestBody AttractionCollection ac) {
        try {
            QueryWrapper<AttractionCollection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", ac.getUserId_zch_hwz_gjc())
                    .eq("attractionId_zch_hwz_gjc", ac.getAttractionId_zch_hwz_gjc());
            Long flag = attractionCollectionMapper.selectCount(queryWrapper);
            if (flag > 0) {
                return ResponseEntity.ok(ResponseResult.error("已收藏"));
            }
            AttractionCollection collection = new AttractionCollection();
            collection.setUserId_zch_hwz_gjc(ac.getUserId_zch_hwz_gjc());
            collection.setAttractionId_zch_hwz_gjc(ac.getAttractionId_zch_hwz_gjc());
            collection.setCollectionTime_zch_hwz_gjc(new Date());

            int result = attractionCollectionMapper.insert(collection);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("收藏失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("收藏景点出错"));
        }
    }

    /**
     * 取消景点收藏
     *
     * @return
     */

    @DeleteMapping("/collection")
    public ResponseEntity<?> cancelCollection(
           @RequestBody AttractionCollection ac
    ) {
        try {
            QueryWrapper<AttractionCollection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", ac.getUserId_zch_hwz_gjc())
                    .eq("attractionId_zch_hwz_gjc", ac.getAttractionId_zch_hwz_gjc());

            AttractionCollection collection = attractionCollectionMapper.selectOne(queryWrapper);

            int result = attractionCollectionMapper.deleteById(collection);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("取消收藏失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("取消收藏出错"));
        }
    }

    /**
     * 获取用户收藏列表
     *
     * @param userId   用户ID
     * @param pageNo   页码
     * @param pageSize 每页大小
     * @return
     */

    @GetMapping("/collection/list")
    public ResponseEntity<?> getUserCollections(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "page", defaultValue = "1") int pageNo,
            @RequestParam(value = "size", defaultValue = "10") int pageSize) {
        try {
            Page<AttractionCollection> page = new Page<>(pageNo, pageSize);
            QueryWrapper<AttractionCollection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", userId)
                    .eq("deleted_zch_hwz_gjc", 0);  // 只查询未被删除的收藏

            Page<AttractionCollection> resultPage = attractionCollectionMapper.selectPage(page, queryWrapper);
            return ResponseEntity.ok(ResponseResult.ok(resultPage));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("获取收藏列表出错"));
        }
    }
}
