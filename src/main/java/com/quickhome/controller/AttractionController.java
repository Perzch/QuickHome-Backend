package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.AttractionCollection;
import com.quickhome.domain.AttractionImage;
import com.quickhome.domain.Attractions;
import com.quickhome.mapper.AttractionCollectionMapper;
import com.quickhome.mapper.AttractionsMapper;
import com.quickhome.pojo.PojoAttraction;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.AttractionImageService;
import com.quickhome.service.AttractionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Controller("AttractionCon")
@RequestMapping("/Attraction")
public class AttractionController {
    @Autowired
    private AttractionsService attractionsService;

    @Autowired
    private AttractionImageService attractionImageService;

    @Autowired
    private AttractionsMapper attractionMapper;
    @Autowired
    private AttractionCollectionMapper attractionCollectionMapper;


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
