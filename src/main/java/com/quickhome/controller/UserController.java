package com.quickhome.controller;

import com.quickhome.entity.Order;
import com.quickhome.entity.User;
import com.quickhome.service.OrderService;
import com.quickhome.service.UserService;
import com.quickhome.util.CreatAccount;
import com.quickhome.util.DynamicDoorPassword;
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
    UserService userService;
    @PostMapping("/insertUser")
    public ResponseEntity<User> insertUser_zch_hwz_gjc(@RequestBody User user, HttpServletRequest req) {
        //-------------------------------------
        //获取时间
        LocalDateTime now_zch_hwz_gjc = LocalDateTime.now();
        DateTimeFormatter formatter_zch_hwz_gjc = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String creationTimeString_zch_hwz_gjc = now_zch_hwz_gjc.format(formatter_zch_hwz_gjc);
        Date creationTime_zch_hwz_gjc = java.sql.Timestamp.valueOf(creationTimeString_zch_hwz_gjc);
        //-------------------------------------\
        user.setUserAccount_zch_hwz_gjc(String.valueOf(new CreatAccount().creatAccount()));
        user.setUserInDate_zch_hwz_gjc(creationTime_zch_hwz_gjc);
        int x_zch_hwz_gjc = userService.insertUser_zch_hwz_gjc(user);
        System.out.println("用户注册成功");
        System.out.println(user);
        return ResponseEntity.ok(user);
    }
}
