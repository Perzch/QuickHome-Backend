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
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentPasswordService paymentPasswordService;

    /**
     * 设置支付密码
     * @param request 支付密码对象
     * @return
     */

    @PostMapping("/set")
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

    /**
     * 验证支付密码
     * @param request 支付密码对象
     * @return
     */

    @PostMapping("/verify")
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

    /**
     * 获取支付密码设置状态
     * @param userId 用户ID
     * @return
     */

    @GetMapping("/status")
    public ResponseEntity<ResponseResult> getPaymentPasswordStatus(@RequestParam("userId") Long userId) {
        try {
            boolean result = paymentPasswordService.getPaymentPasswordStatus(userId);
            if(result){
                return ResponseEntity.ok(ResponseResult.ok(true));
            }else {
                return ResponseEntity.badRequest().body(ResponseResult.error(String.valueOf(false)));
            }
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(ResponseResult.error(e.getMessage()));
        }
    }


}
