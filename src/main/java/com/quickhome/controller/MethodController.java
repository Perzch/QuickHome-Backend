package com.quickhome.controller;

import com.quickhome.request.ResponseResult;
import com.quickhome.util.MailUtils;
import com.quickhome.util.SendSMS;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

/**
 * @author ButterflyX
 * @description 方法控制类
 * @creatDate 2023/6/28 15:00
 */

@Transactional
@Controller("MethodCon")
@RequestMapping("/Method")
@CrossOrigin(origins = "http://localhost:8081")
public class MethodController {
    /**
     * 发送短信
     * @param phoneNumber 手机号
     * @return 返回发送结果
     */
    @PostMapping("/sendSMS")
    @ResponseBody
    public ResponseEntity<?> sendSMS(@RequestParam String phoneNumber) {
        String returnCode;
        String regex = "^1[3456789]\\d{9}$";
        boolean isValid = phoneNumber.matches(regex);
        if (!isValid) {
            return ResponseEntity.ok(ResponseResult.of(100, "手机号格式不正确"));
        }
        try {
            returnCode = SendSMS.SendSMS(phoneNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (returnCode != null) {
            return ResponseEntity.ok(ResponseResult.ok(returnCode));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "发送失败"));
        }
    }

    /**
     * 发送邮件
     * @param email 邮箱
     * @return 返回发送结果
     */
    @PostMapping("/sendMail")
    @ResponseBody
    public ResponseEntity<?> sendMail(@RequestParam String email) {
        String returnCode;
        String regex = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        boolean isValid = email.matches(regex);
        if (!isValid) {
            return ResponseEntity.ok(ResponseResult.of(100, "邮箱格式不正确"));
        }
        try {
            returnCode = MailUtils.sendMail(email);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (returnCode != null) {
            return ResponseEntity.ok(ResponseResult.ok(returnCode));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "发送失败"));
        }
    }
}
