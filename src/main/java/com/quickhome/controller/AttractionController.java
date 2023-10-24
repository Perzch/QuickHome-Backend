package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.AttractionCollection;
import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.Attractions;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.mapper.AttractionCollectionMapper;
import com.quickhome.mapper.AttractionImageMapper;
import com.quickhome.mapper.AttractionsMapper;
import com.quickhome.pojo.PojoAttraction;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.AttractionImageService;
import com.quickhome.service.AttractionsService;
import com.quickhome.util.ImageUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

@Controller("AttractionCon")
@RequestMapping("/Attraction")
public class AttractionController {
    @Autowired
    private AttractionsService attractionsService;

    @Autowired
    private AttractionImageService attractionImageService;

    @Autowired
    private AttractionImageMapper attractionImageMapper;

    @Autowired
    private AttractionsMapper attractionMapper;
    @Autowired
    private AttractionCollectionMapper attractionCollectionMapper;

    private static final List<String> ALLOWED_FILE_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/jpg");

    @SneakyThrows
    @ResponseBody
    @GetMapping("/getAttractionImg")
    public ResponseEntity<Resource> getAttractionImg(@RequestParam Long attractionId) {
        QueryWrapper<AttractionImage> wrapper = new QueryWrapper<>();
        wrapper.eq("attractionId_zch_hwz_gjc", attractionId);
        wrapper.eq("deleted_zch_hwz_gjc", 0);
        List<AttractionImage> images = attractionImageMapper.selectList(wrapper);
        if (images.size() == 0) {
            return ResponseEntity.notFound().build();
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ZipOutputStream zos = new ZipOutputStream(baos);

        try {
            for (AttractionImage image : images) {
                Path path = Paths.get(image.getImagePath_zch_hwz_gjc());
                FileInputStream fis = new FileInputStream(path.toFile());
                ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                zos.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int len;
                while ((len = fis.read(buffer)) > 0) {
                    zos.write(buffer, 0, len);
                }
                zos.closeEntry();
                fis.close();
            }
            zos.close();

            ByteArrayResource resource = new ByteArrayResource(baos.toByteArray());
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=attractionImages.zip")
                    .body(resource);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/deleteAttractionImg")
    public ResponseEntity<?> deleteAttractionByTimestamp(@RequestParam Long attractionId, @RequestParam String timestamp) {
        try {
            // 拼接attractionId和时间戳
            String combinedString = attractionId.toString() +"-"+ timestamp;

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
    @PostMapping("/insertAttractionImg")
    public ResponseEntity<ResponseResult<?>> insertAttractionImg(
            @RequestParam("attractionId") Long attractionId,
            @RequestParam("file") MultipartFile file,
            HttpServletRequest req) throws IOException{
        if (!ALLOWED_FILE_TYPES.contains(file.getContentType())) {
            return ResponseEntity.badRequest().body(ResponseResult.error("文件类型错误"));
        }

        String imagePath = saveUploadedFile(attractionId, file);

        AttractionImage attractionImage = attractionImageService.saveOrUpdateUserHeadImage(attractionId, imagePath);

        return ResponseEntity.ok(ResponseResult.ok(attractionImage));
    }

    private String saveUploadedFile(Long attractionId, MultipartFile file) throws IOException {
        String uploadDir = "E:/Spring boot/uploads/AttractionImg/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = attractionId + "-" + timestamp + "." + getFileExtension(file.getOriginalFilename());
        String filePath = uploadDir + newFileName;
        file.transferTo(new File(filePath));
        return filePath;
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 按收藏数量获取景点列表
     *
     * @return 景点信息列表
     */
    @GetMapping("/getAttractionListByCollectionCount")
    @ResponseBody
    public ResponseEntity<ResponseResult<List<PojoAttraction>>> getAttractionListOrderByCollectionCount() {
        List<PojoAttraction> pojoAttractionList = attractionsService.getAttractionListOrderByCollectionCount();
        for (PojoAttraction pojoAttraction : pojoAttractionList) {
            Attractions attractions = attractionsService.getById(pojoAttraction.getAttractionsId_zch_hwz_gjc());
            pojoAttraction.setAttractions(attractions);
            List<AttractionImage> attractionImageList = attractionImageService.getAttractionImageListById(pojoAttraction.getAttractionsId_zch_hwz_gjc());
            pojoAttraction.setAttractionImageList(attractionImageList);
        }
        return ResponseEntity.ok(ResponseResult.ok(pojoAttractionList));
    }

    @PostMapping("/insertAttraction")
    public ResponseEntity<?> insertAttraction(@RequestBody Attractions attractions) {
        try {
            LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("Asia/Shanghai"));
            Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
            attractions.setAttractionInDate_zch_hwz_gjc(date);
            attractionMapper.insert(attractions);
            return ResponseEntity.ok(ResponseResult.ok("插入成功"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("插入失败"));
        }
    }

    @GetMapping("/getAttractionById")
    public ResponseEntity<?> getAttractionById(@RequestParam Long attractionId) {
        try {
            Attractions attractions = attractionMapper.selectById(attractionId);
            if (attractions != null) {
                return ResponseEntity.ok(ResponseResult.ok(attractions));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("未找到"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("Error fetching attraction details"));
        }
    }

    @GetMapping("/queryAttractions")
    public ResponseEntity<?> queryAttractions(
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize,
            @RequestParam(value = "attractionsName", required = false) String attractionsName) {
        try {
            Page<Attractions> page = new Page<>(pageNo, pageSize);
            QueryWrapper<Attractions> queryWrapper = new QueryWrapper<>();
            if (attractionsName != null && !attractionsName.trim().isEmpty()) {
                queryWrapper.like("attractionsName_zch_hwz_gjc", attractionsName);
            }
            IPage<Attractions> attractionsPage = attractionMapper.selectPage(page, queryWrapper);
            return ResponseEntity.ok(attractionsPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("获取景点列表出错"));
        }
    }

    @PutMapping("/updateAttraction")
    public ResponseEntity<?> updateAttraction(@RequestBody Attractions attractions) {
        try {
            if (attractions.getAttractionsId_zch_hwz_gjc() == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("景点ID不能为空"));
            }
            int result = attractionMapper.updateById(attractions);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("更新景点信息出错"));
        }
    }

    @DeleteMapping("/deleteAttraction")
    public ResponseEntity<?> deleteAttraction(@RequestParam("attractionId") Long attractionId) {
        try {
            UpdateWrapper<Attractions> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("attractionsId_zch_hwz_gjc", attractionId)
                    .set("deleted_zch_hwz_gjc", 1);

            int result = attractionMapper.update(null, updateWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("删除景点信息出错"));
        }
    }

    @PostMapping("/addAttractionCollection")
    public ResponseEntity<?> addAttractionCollection(
            @RequestParam("userId") Long userId,
            @RequestParam("attractionsId") Long attractionsId) {
        try {
            AttractionCollection collection = new AttractionCollection();
            collection.setUserId_zch_hwz_gjc(userId);
            collection.setAttractionsId_zch_hwz_gjc(attractionsId);
            collection.setCollectionTime_zch_hwz_gjc(new Date());

            int result = attractionCollectionMapper.insert(collection);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("收藏失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("收藏景点出错"));
        }
    }

    @PutMapping("/cancelCollection")
    public ResponseEntity<?> cancelCollection(
            @RequestParam("userId") Long userId,
            @RequestParam("attractionsId") Long attractionsId) {
        try {
            UpdateWrapper<AttractionCollection> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("userId_zch_hwz_gjc", userId)
                    .eq("attractionsId_zch_hwz_gjc", attractionsId)
                    .set("deleted_zch_hwz_gjc", 1);

            int result = attractionCollectionMapper.update(null, updateWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok());
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("取消收藏失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("取消收藏出错"));
        }
    }

    @GetMapping("/getUserCollections")
    public ResponseEntity<?> getUserCollections(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        try {
            Page<AttractionCollection> page = new Page<>(pageNo, pageSize);
            QueryWrapper<AttractionCollection> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("userId_zch_hwz_gjc", userId)
                    .eq("deleted_zch_hwz_gjc", 0);  // 只查询未被删除的收藏

            Page<AttractionCollection> resultPage = attractionCollectionMapper.selectPage(page, queryWrapper);
            return ResponseEntity.ok(ResponseResult.ok(resultPage));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("获取收藏列表出错"));
        }
    }
}
