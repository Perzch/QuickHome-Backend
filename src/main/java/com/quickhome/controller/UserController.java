package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.quickhome.domain.UserHeadImage;
import com.quickhome.pojo.PJUser;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.UserHeadImageService;
import com.quickhome.util.CreatAccount;
import com.quickhome.domain.User;
import com.quickhome.domain.UserInformation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.quickhome.service.UserInformationService;
import com.quickhome.service.UserService;

import java.util.List;

import static com.quickhome.request.ResultCode.USER_NOT_EXIST;

/**
 * @author Tim-h
 * @description 密码加密传回
 * @changeDate 2023/6/28 15:21
 */

@Controller("UserCon")
@RequestMapping("/User")
public class UserController {
    //公钥与私钥
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;

    @Autowired
    private UserService userService;

    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private UserHeadImageService userHeadImageService;

    @PostMapping("/insertUser")//创建用户
    @ResponseBody
    public ResponseEntity<?> insertUser_zch_hwz_gjc(@RequestBody User user,
                                                    HttpServletRequest req) {
        //RSA方式生成公钥和私钥
        RSA rsa = new RSA(privateKey, publicKey);
        //插入标记
        boolean flag_user = false, flag_img = false;
        List<User> flag_queryUser = null;
        //缺少数据判定
        if (user.getUserPwd_zch_hwz_gjc().equals("") || user.getUserPwd_zch_hwz_gjc() == null) {
            return ResponseEntity.ok(ResponseResult.of(100, "请输入用户密码!"));
        }
        if (user.getUserPhone_zch_hwz_gjc().equals("") || user.getUserPhone_zch_hwz_gjc() == null) {
            //用正则表达式判断手机号是否符合规范
            if (!user.getUserPhone_zch_hwz_gjc().matches("^1[3456789]\\d{9}$")) {
                return ResponseEntity.ok(ResponseResult.of(100, "请输入正确的手机号!"));
            }
            return ResponseEntity.ok(ResponseResult.of(100, "请输入手机号!"));
        }
        //补全用户类
        user.setUserInDate_zch_hwz_gjc(DateTime.now());

        byte[] decrypt = rsa.decrypt(user.getUserPwd_zch_hwz_gjc(), KeyType.PrivateKey);
        user.setUserPwd_zch_hwz_gjc(new String(decrypt));
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
            user.setUserName_zch_hwz_gjc(account);
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

    @PostMapping("/insertUserInf")//用户信息插入
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

    @GetMapping("/getUserAccountByAccount")//通过用户账号判断账号是否可用
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
    @PostMapping("/userLogin")//用户登录
    public ResponseEntity<ResponseResult<?>> userLogin_zch_hwz_hwz(@RequestBody User user, HttpServletRequest req) {
        String token = userService.userLogin_zch_hwz_gjc(user);
        List<User> user1=userService.queryUser(user);
        User user2=user1.get(0);
        PJUser pjUser= PJUser.builder().token(token).userId(user2.getUserId_zch_hwz_gjc()).build();
        if (token != null) {
            return ResponseEntity.ok(ResponseResult.ok(pjUser));
        } else {
            return ResponseEntity.ok(ResponseResult.of(USER_NOT_EXIST));
        }
    }

    @SneakyThrows
    @ResponseBody
    @PostMapping("/userLoginByPhone")//用户登录通过手机
    public ResponseEntity<ResponseResult<?>> userLoginByPhone_zch_hwz_hwz(@RequestBody User user,
                                                                          HttpServletRequest req) {

        return null;
    }



    @SneakyThrows
    @ResponseBody
    @PostMapping("/userForget")//忘记密码
    public ResponseEntity<ResponseResult<?>> userForget_zch_hwz_gjc(@RequestParam(defaultValue = "all") String userEmail,
                                                                    @RequestParam(defaultValue = "all") String userPhone,
                                                                    HttpServletRequest req) {
        User userForget = User.builder()
                .userEmail_zch_hwz_gjc(userEmail)
                .userPhone_zch_hwz_gjc(userPhone)
                .build();
        Boolean userFlag = userService.userForget_zch_hwz_gjc(userForget);
        if (userFlag) {
            return ResponseEntity.ok(ResponseResult.ok("用户存在!"));
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户不存在!"));
        }
    }
}
