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

    @PutMapping("/updateIdCardInfo")
    public ResponseEntity<ResponseResult> updateIdCardInfo(
            @RequestParam("IDCardRecordID") Long IDCardRecordID,
            @RequestParam("IDCardName") String IDCardName,
            @RequestParam("IDCardNumber") String IDCardNumber,
            @RequestParam("IDCardPhoneNumber") String IDCardPhoneNumber) {
        try {
            boolean result = idCardService.updateIdCardInfo(IDCardRecordID, IDCardName, IDCardNumber, IDCardPhoneNumber);
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("更新成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败"));
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

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
