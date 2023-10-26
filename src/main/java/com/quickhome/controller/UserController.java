package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.quickhome.domain.*;
import com.quickhome.mapper.*;
import com.quickhome.pojo.PJUser;
import com.quickhome.pojo.PojoUser;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.UserHeadImageService;
import com.quickhome.util.CreatAccount;
import com.quickhome.util.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.quickhome.service.UserInformationService;
import com.quickhome.service.UserService;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.quickhome.request.ResultCode.USER_NOT_EXIST;

/**
 * @author Tim-h
 * @description 密码加密传回
 * @changeDate 2023/6/28 15:21
 */

@Transactional
@Controller("UserCon")
@RequestMapping("/User")
public class UserController {
    //公钥与私钥
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;
    private static final List<String> ALLOWED_FILE_TYPES = Arrays.asList("image/jpeg", "image/png", "image/gif", "image/jpg");
    @Autowired
    private UserService userService;

    @Autowired
    private UserInformationMapper userInformationMapper;

    @Autowired
    private UserHeadImageMapper userHeadImageMapper;

    @Autowired
    private AccountBalanceMapper accountBalanceMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PaymentPasswordMapper paymentPasswordMapper;

    @Autowired
    private UserInformationService userInformationService;

    @Autowired
    private UserHeadImageService userHeadImageService;

    @Autowired
    private UserMapper userMapper;

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
        List<User> user1 = userService.queryUser(user);
        User user2 = user1.get(0);
        PJUser pjUser = PJUser.builder().token(token).userId(user2.getUserId_zch_hwz_gjc()).build();
        if (token != null) {
            return ResponseEntity.ok(ResponseResult.ok(pjUser));
        } else {
            return ResponseEntity.ok(ResponseResult.of(USER_NOT_EXIST));
        }
    }

    @SneakyThrows
    @ResponseBody
    @PostMapping("/userLoginByPhone")//用户登录通过手机
    public ResponseEntity<ResponseResult<?>> loginByPhone(@RequestParam String phone, HttpServletRequest req) {

        User user = userService.loginByPhone(phone);
        if (user != null) {
            String accessToken = JwtUtil.createToken(user.getUserId_zch_hwz_gjc());

            Map<String, Object> responseData = new HashMap<>();
            responseData.put("token", accessToken);
            responseData.put("userId", user.getUserId_zch_hwz_gjc());

            return ResponseEntity.ok(ResponseResult.ok(responseData));
        } else {
            return ResponseEntity.ok(ResponseResult.error("登录失败"));
        }
    }

    @SneakyThrows
    @ResponseBody
    @GetMapping("/getUserInformation")
    public ResponseEntity<ResponseResult<?>> getUserInformation(
            @RequestParam String token,
            @RequestParam int userId,
            HttpServletRequest req) {
        boolean flag = JwtUtil.verifyToken(token);
        User user = userMapper.selectById(userId);
        if (flag && user != null) {
            PojoUser pojoUser = new PojoUser();
            pojoUser.setToken(token);
            pojoUser.setUserId(userId);
            pojoUser.setUser(userService.getById((long) userId));
            pojoUser.setUserInformation(userInformationService.getUserInformationByUserId((long) userId));
            pojoUser.setUserHeadImage(userHeadImageService.getUserHeadImageByUserId((long) userId));

            return ResponseEntity.ok(ResponseResult.ok(pojoUser));
        }
        return ResponseEntity.ok(ResponseResult.error("查询失败"));
    }

    @SneakyThrows
    @ResponseBody
    @PostMapping("/userForget")//忘记密码
    public ResponseEntity<ResponseResult<?>> userForget_zch_hwz_gjc(@RequestParam(defaultValue = "") String userEmail,
                                                                    @RequestParam(defaultValue = "") String userPhone,
                                                                    HttpServletRequest req) {
        User userForget = User.builder()
                .userEmail_zch_hwz_gjc(userEmail)
                .userPhone_zch_hwz_gjc(userPhone)
                .build();
        Boolean userFlag = userService.userForget_zch_hwz_gjc(userForget);
        if (userFlag) {
            return ResponseEntity.ok(ResponseResult.ok("用户存在!"));
        } else {
            return ResponseEntity.ok(ResponseResult.ok("用户不存在!"));
        }
    }

    @PostMapping("/setPassword")
    public ResponseEntity<ResponseResult<?>> setUserPassword(@RequestBody User user) {
        String password = user.getUserPwd_zch_hwz_gjc();
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] decrypt = rsa.decrypt(password, KeyType.PrivateKey);
        String plainTextPassword = new String(decrypt);
        System.out.println("解密后的明文为:" + plainTextPassword);

        // 构建查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userEmail_zch_hwz_gjc", user.getUserEmail_zch_hwz_gjc())
                .or()
                .eq("userPhone_zch_hwz_gjc", user.getUserPhone_zch_hwz_gjc());

        // 从数据库中加载用户信息
        User existingUser = userService.getOne(queryWrapper);
        if (existingUser == null) {
            return ResponseEntity.ok(ResponseResult.error("用户不存在"));
        }

        // 设置新密码
        existingUser.setUserPwd_zch_hwz_gjc(plainTextPassword);

        // 更新用户信息
        boolean updateSuccess = userService.updateById(existingUser);
        if (updateSuccess) {
            return ResponseEntity.ok(ResponseResult.ok(existingUser.getUserId_zch_hwz_gjc()));
        } else {
            return ResponseEntity.ok(ResponseResult.error("设置密码失败，数据可能已被其他用户修改"));
        }
    }

    @PostMapping("/uploadUserHeadImage")
    public ResponseEntity<ResponseResult<?>> uploadUserHeadImage(
            @RequestParam("userId") Long userId,
            @RequestParam("file") MultipartFile file) throws IOException {

        if (!ALLOWED_FILE_TYPES.contains(file.getContentType())) {
            return ResponseEntity.badRequest().body(ResponseResult.error("文件类型错误"));
        }

        String imagePath = saveUploadedFile(userId, file);

        UserHeadImage userHeadImage = userHeadImageService.saveOrUpdateUserHeadImage(userId, imagePath);
        return ResponseEntity.ok(ResponseResult.ok(userHeadImage));
    }

    private String saveUploadedFile(Long userId, MultipartFile file) throws IOException {
        String uploadDir = "E:/Spring boot/uploads/HeadImage/";
        File dir = new File(uploadDir);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = userId + "-" + timestamp + "." + getFileExtension(file.getOriginalFilename());
        String filePath = uploadDir + newFileName;
        file.transferTo(new File(filePath));
        return filePath;
    }

    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    @SneakyThrows
    @ResponseBody
    @PostMapping("/updateUserInf")
    public ResponseEntity<ResponseResult<?>> updateUserInf(
            @RequestParam Long userId,
            @RequestParam(required = false) String userGender,
            @RequestParam(required = false) String userBirthday,
            @RequestParam(required = false) String userSignature,
            HttpServletRequest req) {

        Date dateBirthday = null;
        if (userBirthday != null && !userBirthday.isEmpty()) {
            LocalDate localDateBirthday = LocalDate.parse(userBirthday, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dateBirthday = Date.from(localDateBirthday.atStartOfDay(ZoneId.of("Asia/Shanghai")).toInstant());
        }

        return ResponseEntity.ok(ResponseResult.ok(userInformationService.updateUserInformation(userId, userGender, dateBirthday, userSignature)));
    }

    @SneakyThrows
    @ResponseBody
    @GetMapping("/getHeadImg")
    public ResponseEntity<Resource> getHeadImg(@RequestParam Long userId) {
        String imagePath = userInformationService.getUserImagePath(userId);
        if (imagePath == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            Path path = Paths.get(imagePath);
            Resource resource = new UrlResource(path.toUri());
            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + resource.getFilename())
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @SneakyThrows
    @ResponseBody
    @PostMapping("/findHeadImg")
    public ResponseEntity<ResponseResult<?>> findHeadImg(
            @RequestParam Long userId,
            @RequestParam String inDateTime,
            HttpServletRequest req) {

        // 拼接预期的文件名部分
        String expectedFilenamePart = userId + "-" + inDateTime;

        // 从数据库中根据用户ID查询头像路径
        String imagePathInDB = userInformationService.getUserImagePath(userId);

        if (imagePathInDB != null && !imagePathInDB.isEmpty()) {
            // 从完整路径中提取文件名
            String filenameInDB = imagePathInDB.substring(imagePathInDB.lastIndexOf("/") + 1, imagePathInDB.lastIndexOf("."));

            if (filenameInDB.equals(expectedFilenamePart)) {
                // 文件名匹配成功
                return ResponseEntity.ok(ResponseResult.ok("头像不需要更新"));
            } else {
                // 文件名匹配失败
                return ResponseEntity.ok(ResponseResult.of(210,"头像需要更新"));
            }
        } else {
            // 用户ID没有对应的头像
            return ResponseEntity.ok(ResponseResult.error("用户没有头像"));
        }
    }

    @ResponseBody
    @PostMapping("/deleteUser")
    public ResponseEntity<ResponseResult<?>> deleteUser(
            @RequestParam Long userId,
            HttpServletRequest req) {

        QueryWrapper<AccountBalance> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.eq("userId_zch_hwz_gjc", userId);
        AccountBalance accountBalance = accountBalanceMapper.selectOne(queryWrapper5);

        if (accountBalance.getUserBalance_zch_hwz_gjc() > 0){
            return ResponseEntity.ok(ResponseResult.error("用户余额大于0，不能注销"));
        }

        QueryWrapper<Order> queryWrapper6 = new QueryWrapper<>();
        queryWrapper6.eq("userId_zch_hwz_gjc", userId);
        List<Order> orders = orderMapper.selectList(queryWrapper6);

        boolean hasUnfinishedOrder = false;

        for (Order order : orders){
            String state = order.getOrderState_zch_hwz_gjc();
            if (!state.equals("已完成") && !state.equals("已取消")) {
                hasUnfinishedOrder = true;
                break;
            }
        }

        if (hasUnfinishedOrder) {
            return ResponseEntity.ok(ResponseResult.error("用户有未完成的订单，不能注销"));
        }

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("userId_zch_hwz_gjc", userId)
                .set("deleted_zch_hwz_gjc", 1);
        userMapper.update(null, updateWrapper);

        UpdateWrapper<PaymentPassword> updateWrapper7 = new UpdateWrapper<>();
        updateWrapper7.eq("userId_zch_hwz_gjc", userId)
                .set("deleted_zch_hwz_gjc", 1);
        paymentPasswordMapper.update(null, updateWrapper7);


        UpdateWrapper<Order> updateWrapper6 = new UpdateWrapper<>();
        updateWrapper6.eq("userId_zch_hwz_gjc", userId)
                .set("deleted_zch_hwz_gjc", 1);
        orderMapper.update(null, updateWrapper6);


        UpdateWrapper<UserInformation> updateWrapper1 = new UpdateWrapper<>();
        updateWrapper1.eq("userId_zch_hwz_gjc", userId)
                .set("deleted_zch_hwz_gjc", 1);
        userInformationMapper.update(null, updateWrapper1);

        UpdateWrapper<UserHeadImage> updateWrapper2 = new UpdateWrapper<>();
        updateWrapper2.eq("userId_zch_hwz_gjc", userId)
                .set("deleted_zch_hwz_gjc", 1);
        userHeadImageMapper.update(null, updateWrapper2);

        UpdateWrapper<AccountBalance> updateWrapper3 = new UpdateWrapper<>();
        updateWrapper3.eq("userId_zch_hwz_gjc", userId)
                .set("deleted_zch_hwz_gjc", 1);
        accountBalanceMapper.update(null, updateWrapper3);

        return ResponseEntity.ok(ResponseResult.ok("注销成功"));
    }
}
