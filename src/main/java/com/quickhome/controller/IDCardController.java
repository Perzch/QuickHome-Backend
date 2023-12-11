package com.quickhome.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.domain.IdentityCheckList;
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
@RequestMapping("/Identity")
public class IDCardController {
    @Autowired
    private IdCardRecordService idCardService;


    @Autowired
    private IdentityCheckListService IdentityCheckListService;

    /**
     * 上传身份证信息
     *
     * @param IDCardName   身份证姓名
     * @param IDCardNumber 身份证号
     * @param IDCardPhoneNumber 手机号
     * @param userId 用户id
     * @return
     */
    @PostMapping("/uploadIdcardInfo")
    public ResponseEntity<ResponseResult> uploadIdCardInfo(
            @RequestParam("IDCardName") String IDCardName,
            @RequestParam("IDCardNumber") String IDCardNumber,
            @RequestParam("IDCardPhoneNumber") String IDCardPhoneNumber,
            @RequestParam("userId") Long userId) {
        try {
            IdCardRecord idCardRecord = idCardService.uploadIdCardInfo(IDCardName, IDCardNumber, IDCardPhoneNumber, userId);
            return ResponseEntity.ok(ResponseResult.ok(idCardRecord));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
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

    @GetMapping("/getIdCardInfo")
    public ResponseEntity<ResponseResult> getIdCardInfo(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "current", defaultValue = "1") int current,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        try {
            IPage<IdCardRecord> idCardInfo = idCardService.getIdCardInfo(userId, current, size);
            return ResponseEntity.ok(ResponseResult.ok(idCardInfo));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 更新身份证信息
     *
     * @param userId 用户id
     * @param newIDCardName 新身份证姓名
     * @param newIDCardNumber 新身份证号
     * @param newIDCardPhoneNumber 新手机号
     * @param oldIDCardName 旧身份证姓名
     * @param oldIDCardNumber 旧身份证号
     * @param oldIDCardPhoneNumber 旧手机号
     * @return
     *
     */

    @PutMapping("/updateIdCardInfo")
    public ResponseEntity<ResponseResult> updateIdCardInfo(
            @RequestParam("userId") Long userId,
            @RequestParam(value = "newIDCardName", required = false) String newIDCardName,
            @RequestParam(value = "newIDCardNumber", required = false) String newIDCardNumber,
            @RequestParam(value = "newIDCardPhoneNumber", required = false) String newIDCardPhoneNumber,
            @RequestParam(value = "oldIDCardName", required = false) String oldIDCardName,
            @RequestParam(value = "oldIDCardNumber", required = false) String oldIDCardNumber,
            @RequestParam(value = "oldIDCardPhoneNumber", required = false) String oldIDCardPhoneNumber) {
        try {
            boolean result = idCardService.updateIdCardInfo(userId, newIDCardName, newIDCardNumber, newIDCardPhoneNumber,
                    oldIDCardName, oldIDCardNumber, oldIDCardPhoneNumber);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("更新成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 创建身份证审核列表
     *
     * @param IDCardRecordID 身份证记录id
     * @param orderID 订单id
     * @return
     */

    @PostMapping("/createIdentityChecklist")
    public ResponseEntity<ResponseResult<?>> createIdentityCheckList(@RequestParam Long IDCardRecordID, @RequestParam Long orderID) {
        try {
            IdentityCheckList IdentityCheckList = IdentityCheckListService.createIdentityChecklist(IDCardRecordID, orderID);
            if (IdentityCheckList != null) {
                return ResponseEntity.ok(ResponseResult.ok(IdentityCheckList));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("创建失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("错误: " + e.getMessage()));
        }
    }

    /**
     * 删除身份证信息
     *
     * @param IDCardName 身份证姓名
     * @param IDCardNumber 身份证号
     * @param IDCardPhoneNumber 手机号
     * @param userId 用户id
     * @return
     */

    @DeleteMapping("/deleteIdCardInfo")
    public ResponseEntity<ResponseResult> deleteIdCardInfo(
            @RequestParam("IDCardName") String IDCardName,
            @RequestParam("IDCardNumber") String IDCardNumber,
            @RequestParam("IDCardPhoneNumber") String IDCardPhoneNumber,
            @RequestParam("userId") Long userId){
        try {
            boolean result = idCardService.deleteIdCardInfo(IDCardName, IDCardNumber, IDCardPhoneNumber,userId);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("删除成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    /**
     * 获取订单身份证信息
     *
     * @param orderID 订单id
     * @return
     */

    @GetMapping("/getOrderIdentityInfo")
    public ResponseEntity<ResponseResult> getOrderIdentityInfo(
            @RequestParam("orderID") Long orderID) {
        try {
            List<IdCardRecord> identityInfoList = idCardService.getOrderIdentityInfo(orderID);
            return ResponseEntity.ok(ResponseResult.ok(identityInfoList));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }
}
