package com.quickhome.controller;

import com.quickhome.domain.PaymentPassword;
import com.quickhome.pojo.PojoPaymentPassword;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.PaymentPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/28 20:55
 */
@Transactional
@Controller("PaymentCon")
@RequestMapping("/Payment")
public class PaymentController {
    @Autowired
    private PaymentPasswordService paymentPasswordService;

    @PostMapping("/setPaymentPwd")
    public ResponseEntity<ResponseResult<?>> setPaymentPassword(@RequestBody PaymentPassword request) {
        try {
            boolean result = paymentPasswordService.setPaymentPassword(request.getUserID_zch_hwz_gjc(), request.getPaymentPassword_zch_hwz_gjc());
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("支付密码设置成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("支付密码设置失败"));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }

    @PostMapping("/verifyPaymentPwd")
    public ResponseEntity<ResponseResult<?>> verifyPaymentPassword(@RequestBody PojoPaymentPassword request) {
        try {
            boolean result = paymentPasswordService.verifyPaymentPassword(request.getUserID(), request.getEncryptedPassword());
            if (result) {
                return ResponseEntity.ok(ResponseResult.ok("支付密码验证成功"));
            } else {
                return ResponseEntity.ok(ResponseResult.error("支付密码验证失败"));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }
    @GetMapping("/getPaymentPwdStatus")
    public ResponseEntity<ResponseResult> getPaymentPasswordStatus(@RequestParam("userId") Long userId) {
        try {
            boolean result = paymentPasswordService.getPaymentPasswordStatus(userId);
            return ResponseEntity.ok(ResponseResult.ok(result));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }


}