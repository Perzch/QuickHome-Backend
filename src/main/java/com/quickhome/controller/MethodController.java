package com.quickhome.controller;

import com.quickhome.request.ResponseResult;
import com.quickhome.util.SendSMS;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ButterflyX
 * @description 方法控制类
 * @creatDate 2023/6/28 15:00
 */

@Controller("MethodCon")
@RequestMapping("/Method")
@CrossOrigin(origins = "http://localhost:5173")
public class MethodController {
    @PostMapping("/SendSMS")
    @ResponseBody
    public ResponseEntity<?> sendSMS(@RequestParam String phoneNumber){
        String returnCode;
        String regex = "^1[3456789]\\d{9}$";
        boolean isValid = phoneNumber.matches(regex);
        if(!isValid){
            return ResponseEntity.ok(ResponseResult.of(100,"手机号格式不正确"));
        }
        try {
            returnCode = SendSMS.SendSMS(phoneNumber);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (returnCode!=null){
            return ResponseEntity.ok(ResponseResult.ok(returnCode));
        }else {
            return ResponseEntity.ok(ResponseResult.of(100,"发送失败"));
        }
    }
}
