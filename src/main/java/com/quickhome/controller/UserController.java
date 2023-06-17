package com.quickhome.controller;

import com.quickhome.entity.User;
import com.quickhome.entity.UserInformation;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.UserService;
import com.quickhome.util.CreatAccount;
import com.quickhome.util.NowTime;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("UserCon")
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/insertUser")
    public ResponseEntity<?> insertUser_zch_hwz_gjc(@RequestBody User user, HttpServletRequest req) {
        user.setUserAccount_zch_hwz_gjc(String.valueOf(CreatAccount.creatAccount()));
        user.setUserInDate_zch_hwz_gjc(NowTime.getNowTime());//当前时间
        int x = userService.insertUser_zch_hwz_gjc(user);
        if(x==1) {
            return ResponseEntity.ok(ResponseResult.ok(user));
        }else {
            return ResponseEntity.ok(ResponseResult.of(100,"用户注册失败!"));
        }
    }
    @PostMapping("/insertUserInf")
    public ResponseEntity<?> insertUserInf_zch_hwz_gjc(@RequestBody UserInformation userInformation,HttpServletRequest req){
        userInformation.setAuthenticationTime_zch_hwz_gjc(NowTime.getNowTime());//当前时间
        int flag=userService.insertUserInf_zch_hwz_gjc(userInformation);
        if(flag == 1) {
            return ResponseEntity.ok(ResponseResult.ok(userInformation));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100,"用户信息注册失败!"));
        }
    }
}
