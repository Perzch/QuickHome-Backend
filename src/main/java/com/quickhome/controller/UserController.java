package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.User;
import com.quickhome.domain.UserInformation;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.UserInformationService;
import com.quickhome.service.UserService;
import com.quickhome.util.CreatAccount;
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

    @Autowired
    private UserInformationService userInformationService;

    @PostMapping("/insertUser")
    public ResponseEntity<?> insertUser_zch_hwz_gjc(@RequestBody User user, HttpServletRequest req) {
        String account = String.valueOf(CreatAccount.creatAccount());
        while (userService.getUserAccountByAccount_zch_hwz_gjc(account) != null) {
            account = String.valueOf(CreatAccount.creatAccount());
        }
        user.setUserInDate_zch_hwz_gjc(DateTime.now());//当前时间
        boolean flag = userService.save(user);
        if (flag) {
            return ResponseEntity.ok(ResponseResult.ok(user));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户注册失败!"));
        }
    }

    @PostMapping("/insertUserInf")
    public ResponseEntity<?> insertUserInf_zch_hwz_gjc(@RequestBody UserInformation userInformation, HttpServletRequest req) {
        userInformation.setAuthenticationTime_zch_hwz_gjc(DateTime.now());//当前时间
        boolean flag = userInformationService.save(userInformation);
        if (flag) {
            return ResponseEntity.ok(ResponseResult.ok(userInformation));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户信息注册失败!"));
        }
    }

    @RequestMapping("/getUserAccountByAccount")
    public ResponseEntity<?> getUserAccountByAccount_zch_hwz_gjc(@RequestBody User user, HttpServletRequest req) {
        user = userService.getUserAccountByAccount_zch_hwz_gjc(user.getUserAccount_zch_hwz_gjc());
        System.out.println("2222222222222");
        if (user.getUserId_zch_hwz_gjc() != null) {
            return ResponseEntity.ok(ResponseResult.of(100, "该账号已被使用!"));
        } else {
            return ResponseEntity.ok(ResponseResult.ok("该账号可用!"));
        }
    }

    @RequestMapping("/userLogin")
    public ResponseEntity<ResponseResult<?>> userLogin_zch_hwz_hwz(@RequestBody User user, HttpServletRequest req) {
        System.out.println("3333333333");
        try {
            user = userService.userLogin(user);
            System.out.println(user);
            System.out.println("1111111111111");
            if (user.getUserId_zch_hwz_gjc() != null) {
                try {
                    return ResponseEntity.ok(ResponseResult.ok(user));
                }catch (Exception e){
                    throw new RuntimeException(e);
            }

            } else {
                return ResponseEntity.ok(ResponseResult.of(404, "未查询到相应账户!"));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
