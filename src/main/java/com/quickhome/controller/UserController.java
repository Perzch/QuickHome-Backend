package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.UserHeadImageService;
import com.quickhome.util.CreatAccount;
import com.quickhome.domain.User;
import com.quickhome.domain.UserInformation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.quickhome.service.UserInformationService;
import com.quickhome.service.UserService;

import java.util.List;

import static com.quickhome.request.ResultCode.USER_NOT_EXIST;

@Controller("UserCon")
@RequestMapping("/User")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private UserHeadImageService userHeadImageService;

    @PostMapping("/insertUser")
    @ResponseBody
    public ResponseEntity<?> insertUser_zch_hwz_gjc(@RequestParam(required = false) String userName,
                                                    @RequestParam String userPwd,
                                                    @RequestParam(required = false) String userEmail,
                                                    @RequestParam(required = false) String userPhone,
                                                    HttpServletRequest req) {
        //插入标记
        boolean flag_user = false, flag_img = false;
        List<User> flag_queryUser = null;
        if (userPwd.equals("") || userPwd == null) {
            return ResponseEntity.ok(ResponseResult.of(100, "请输入用户密码!"));
        }
        //构造用户类
        User user = User.builder()
                .userName_zch_hwz_gjc(userName)
                .userPwd_zch_hwz_gjc(userPwd)
                .userEmail_zch_hwz_gjc(userEmail)
                .userPhone_zch_hwz_gjc(userPhone)
                .userInDate_zch_hwz_gjc(DateTime.now())
                .build();
        //查询用户信息
        flag_queryUser = userService.queryUser(user);
        //判断是否重复
        if (flag_queryUser == null || flag_queryUser.size() == 0) {
            //创建用户Account
            String account = String.valueOf(CreatAccount.creatAccount());
            while (userService.getUserAccountByAccount_zch_hwz_gjc(account) != null
                    && userService.getUserAccountByAccount_zch_hwz_gjc(account).equals(account)) {
                account = String.valueOf(CreatAccount.creatAccount());
            }
            //写入唯一的用户账号
            user.setUserAccount_zch_hwz_gjc(account);
            //写入用户表
            flag_user = userService.save(user);
            if (flag_user) {
                //创建默认头像
                UserHeadImage userHeadImage = UserHeadImage.builder()
                        .inDateTime_zch_hwz_gjc(DateTime.now())
                        .userId_zch_hwz_gjc(userService.getUserIdByAccount(account))
                        .imagePath_zch_hwz_gjc("F:\\QuickHome_SpringBoot\\QuickHome-Backend\\src\\main\\img\\head.jpg")
                        .build();//头像entity构造器
                //头像保存状态
                flag_img = userHeadImageService.save(userHeadImage);
                if (flag_img) {
                    return ResponseEntity.ok(ResponseResult.ok(userService.getUserIdByAccount(account)));
                } else {
                    return ResponseEntity.ok(ResponseResult.of(100, "用户注册失败!"));
                }
            } else {
                return ResponseEntity.ok(ResponseResult.of(100, "用户注册失败!"));
            }
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户信息已被注册!"));
        }
    }

    @PostMapping("/insertUserInf")
    @ResponseBody
    public ResponseEntity<?> insertUserInf_zch_hwz_gjc(@RequestBody UserInformation userInformation,
                                                       HttpServletRequest req) {
        userInformation.setAuthenticationTime_zch_hwz_gjc(DateTime.now());//当前时间
        userInformation.setUserHeadId_zch_hwz_gjc(
                userHeadImageService.getHeadImgIdByUserId_zch_hwz_gjc(
                        userInformation.getUserId_zch_hwz_gjc()
                )
        );
        boolean flag = userInformationService.save(userInformation);
        if (flag) {
            return ResponseEntity.ok(ResponseResult.ok(userInformation.getUserId_zch_hwz_gjc()));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户信息注册失败!"));
        }
    }

    @GetMapping("/getUserAccountByAccount")
    @ResponseBody
    public ResponseEntity<?> getUserAccountByAccount_zch_hwz_gjc(@RequestParam String userAccount,
                                                                 HttpServletRequest req) {
        if (userService.getUserAccountByAccount_zch_hwz_gjc(userAccount) != null) {
            return ResponseEntity.ok(ResponseResult.of(100, "该账号已被使用!"));
        } else {
            return ResponseEntity.ok(ResponseResult.ok("该账号可用!"));
        }
    }

    @SneakyThrows
    @ResponseBody
    @PostMapping("/userLogin")
    public ResponseEntity<ResponseResult<?>> userLogin_zch_hwz_hwz(@RequestBody User user, HttpServletRequest req) {

        String token = userService.userLogin_zch_hwz_gjc(user);
        System.out.println(token);
        if (token != null) {
            return ResponseEntity.ok(ResponseResult.ok(token));
        } else {
            return ResponseEntity.ok(ResponseResult.of(USER_NOT_EXIST));
        }
    }
}
