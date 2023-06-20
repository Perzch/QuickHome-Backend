package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.User;
import com.quickhome.domain.UserInformation;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.UserInformationService;
import com.quickhome.service.UserService;
import com.quickhome.util.CreatAccount;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.quickhome.request.ResultCode.USER_NOT_EXIST;

@Controller("UserCon")
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserInformationService userInformationService;

    @PostMapping("/insertUser")
    @ResponseBody
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
    @ResponseBody
    public ResponseEntity<?> insertUserInf_zch_hwz_gjc(@RequestBody UserInformation userInformation, HttpServletRequest req) {
        userInformation.setAuthenticationTime_zch_hwz_gjc(DateTime.now());//当前时间
        boolean flag = userInformationService.save(userInformation);
        if (flag) {
            return ResponseEntity.ok(ResponseResult.ok(userInformation));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户信息注册失败!"));
        }
    }

    @GetMapping("/getUserAccountByAccount")
    @ResponseBody
    public ResponseEntity<?> getUserAccountByAccount_zch_hwz_gjc(@RequestParam String userAccount, HttpServletRequest req) {
        if (userService.getUserAccountByAccount_zch_hwz_gjc(userAccount).getUserId_zch_hwz_gjc() != null) {
            return ResponseEntity.ok(ResponseResult.of(100, "该账号已被使用!"));
        } else {
            return ResponseEntity.ok(ResponseResult.ok("该账号可用!"));
        }
    }

    @SneakyThrows
    @GetMapping("/userLogin")
    public ResponseEntity<ResponseResult<?>> userLogin_zch_hwz_hwz(@RequestParam(required = false) String userAccount,
                                                                   @RequestParam(required = false) String userEmail,
                                                                   @RequestParam(required = false) String userPhone,
                                                                   @RequestParam String userPwd,
                                                                   HttpServletRequest req) {
        User user = User.builder()
                .userAccount_zch_hwz_gjc(userAccount)
                .userEmail_zch_hwz_gjc(userEmail)
                .userPhone_zch_hwz_gjc(userPhone)
                .userPwd_zch_hwz_gjc(userPwd).build();
        user = userService.userLogin(user);
        if (user.getUserId_zch_hwz_gjc() != null) {
            return ResponseEntity.ok(ResponseResult.ok(user));
        } else {
            return ResponseEntity.ok(ResponseResult.of(USER_NOT_EXIST));
        }
    }
}
