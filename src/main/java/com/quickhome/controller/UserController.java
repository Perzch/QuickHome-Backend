package com.quickhome.controller;

import com.quickhome.entity.Order;
import com.quickhome.entity.User;
import com.quickhome.entity.UserInformation;
import com.quickhome.service.OrderService;
import com.quickhome.service.UserService;
import com.quickhome.util.CreatAccount;
import com.quickhome.util.DynamicDoorPassword;
import com.quickhome.util.NowTime;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller("UserCon")
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;
    @PostMapping("/insertUser")
    public ResponseEntity<User> insertUser_zch_hwz_gjc(@RequestBody User user, HttpServletRequest req) {
        user.setUserAccount_zch_hwz_gjc(String.valueOf(CreatAccount.creatAccount()));
        user.setUserInDate_zch_hwz_gjc(NowTime.getNowTime());//当前时间
        int x = userService.insertUser_zch_hwz_gjc(user);
        if(x==1) {
            System.out.println("用户注册成功");
            System.out.println(user);
            return ResponseEntity.ok(user);
        }else {
            System.out.println("用户注册失败");
            return ResponseEntity.ok(user);
        }
    }
    @PostMapping("/insertUserInf")
    public ResponseEntity<UserInformation> insertUserInf_zch_hwz_gjc(@RequestBody UserInformation userInformation,HttpServletRequest req){
        userInformation.setAuthenticationTime_zch_hwz_gjc(NowTime.getNowTime());//当前时间
        int flag=userService.insertUserInf_zch_hwz_gjc(userInformation);
        if (flag==1){
            System.out.println("用户信息插入成功");
            return ResponseEntity.ok(userInformation);
        }else {
            System.out.println("用户信息插入失败");
            return ResponseEntity.ok(userInformation);
        }
    }
}
