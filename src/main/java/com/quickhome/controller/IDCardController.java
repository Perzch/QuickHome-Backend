package com.quickhome.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.domain.IdentityCheckList;
import com.quickhome.pojo.PJIdCard;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.IdCardRecordService;
import com.quickhome.service.IdentityCheckListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/28 22:14
 */
@Transactional
@Controller("IdentityCon")
@RequestMapping("/identity")
public class IDCardController {
    @Autowired
    private IdCardRecordService idCardService;


    @Autowired
    private IdentityCheckListService IdentityCheckListService;

    /**
     * 上传身份证信息
     *
     * @return
     */
    @PostMapping
    public ResponseEntity<ResponseResult> uploadIdCardInfo(@RequestBody IdCardRecord cardRecord) {
        try {
            IdCardRecord idCardRecord = idCardService.uploadIdCardInfo(cardRecord);
            return ResponseEntity.ok(ResponseResult.ok(idCardRecord));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 获取身份证信息
     *
     * @param userId 用户id
     * @param current 当前页
     * @param size 每页显示条数
     * @return
     */

    @GetMapping("/list")
    public ResponseEntity<ResponseResult> getIdCardInfo(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "page", defaultValue = "1") int current,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            Page<IdCardRecord> page = new Page<>(current, size);
            QueryWrapper<IdCardRecord> wrapper = new QueryWrapper<>();
            wrapper.eq("userId_zch_hwz_gjc", userId);
            Page<IdCardRecord> recordPage = idCardService.page(page, wrapper);
            return ResponseEntity.ok(ResponseResult.ok(recordPage));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 更新身份证信息
     *
     * @return
     *
     */

    @PutMapping
    public ResponseEntity<ResponseResult> updateIdCardInfo(@RequestBody PJIdCard idCard) {
        try {
            System.out.println(idCard);
            boolean result = idCardService.updateIdCardInfo(idCard);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("更新成功"));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("更新失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 创建身份证审核列表
     *
     * @return
     */

    @PostMapping("/createIdentityChecklist")
    public ResponseEntity<ResponseResult<?>> createIdentityCheckList(@RequestBody PJIdCard idCard) {
        try {
            IdentityCheckList IdentityCheckList = IdentityCheckListService.createIdentityChecklist(idCard);
            if (IdentityCheckList != null) {
                return ResponseEntity.ok(ResponseResult.ok(IdentityCheckList));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("创建失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error("错误: " + e.getMessage()));
        }
    }

    /**
     * 删除身份证信息
     *
     * @return
     */

    @DeleteMapping
    public ResponseEntity<ResponseResult> deleteIdCardInfo(@RequestBody PJIdCard idCard) {
        try {
            System.out.println(idCard);
            boolean result = idCardService.deleteIdCardInfo(idCard);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("删除成功"));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("删除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 获取订单身份证信息
     *
     * @param orderID 订单id
     * @return
     */

    @GetMapping("/order/{id}")
    public ResponseEntity<ResponseResult> getOrderIdentityInfo(
            @PathVariable("id") Long orderID) {
        try {
            List<IdCardRecord> identityInfoList = idCardService.getOrderIdentityInfo(orderID);
            return ResponseEntity.ok(ResponseResult.ok(identityInfoList));
        } catch (Exception e) {
            return ResponseEntity.ok().body(ResponseResult.error(e.getMessage()));
        }
    }
}
