package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.qcloud.cos.utils.IOUtils;
import com.quickhome.domain.*;
import com.quickhome.mapper.*;
import com.quickhome.pojo.PJFile;
import com.quickhome.pojo.PJUser;
import com.quickhome.pojo.PojoUser;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.*;
import com.quickhome.util.CreatAccount;
import com.quickhome.util.HandlePath;
import com.quickhome.util.JwtUtil;
import com.quickhome.util.TencentCOSUtils;
import jakarta.servlet.http.HttpServletRequest;
import lombok.SneakyThrows;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

import static com.quickhome.request.ResultCode.USER_NOT_EXIST;

/**
 * @author Tim-h
 * @description 密码加密传回
 * @changeDate 2023/6/28 15:21
 */

@Transactional
@Controller("UserCon")
@RequestMapping("/user")
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

    @Autowired
    private TencentCOSUtils tencentCOSUtils;

    /**
     * 查询用户
     *
     * @param userEmail   用户邮箱
     * @param userName    用户名
     * @param userAccount 用户账号
     * @param userPhone   用户手机
     * @param page        页数
     * @param size        页大小
     * @return
     */

    @GetMapping("/list")
    public ResponseEntity<ResponseResult<?>> searchUsers(
            @RequestParam(required = false) String userEmail,
            @RequestParam(required = false) String userName,
            @RequestParam(required = false) String userAccount,
            @RequestParam(required = false) String userPhone,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {

        Page<User> userPage = new Page<>(page, size);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(userEmail)) queryWrapper.like("userEmail_zch_hwz_gjc", userEmail);
        if (StringUtils.isNotBlank(userName)) queryWrapper.like("userName_zch_hwz_gjc", userName);
        if (StringUtils.isNotBlank(userAccount)) queryWrapper.eq("userAccount_zch_hwz_gjc", userAccount);
        if (StringUtils.isNotBlank(userPhone)) queryWrapper.eq("userPhone_zch_hwz_gjc", userPhone);

        IPage<User> resultPage = userService.page(userPage, queryWrapper);
        List<PojoUser> pojoUsers = resultPage.getRecords().stream().map(user -> {
            QueryWrapper<UserInformation> userInformationQuery = new QueryWrapper<>();
            userInformationQuery.eq("userId_zch_hwz_gjc", user.getUserId_zch_hwz_gjc());
            UserInformation userInformation = userInformationService.getOne(userInformationQuery);

            UserHeadImage userHeadImage = null;
            if (userInformation != null && userInformation.getUserHeadId_zch_hwz_gjc() != null) {
                userHeadImage = userHeadImageService.getById(userInformation.getUserHeadId_zch_hwz_gjc());
            }
            return new PojoUser(null, user.getUserId_zch_hwz_gjc().intValue(), user, userInformation, userHeadImage);
        }).collect(Collectors.toList());

        Page<PojoUser> pojoUserPage = new Page<>();
        BeanUtils.copyProperties(resultPage, pojoUserPage);
        pojoUserPage.setRecords(pojoUsers);

        return ResponseEntity.ok(ResponseResult.ok(pojoUserPage));
    }

    /**
     * 创建用户
     *
     * @param user 用户类
     */
    @PostMapping
    @ResponseBody
    public ResponseEntity<?> insertUser_zch_hwz_gjc(@RequestBody User user,
                                                    HttpServletRequest req) {
        //RSA方式生成公钥和私钥
        RSA rsa = new RSA(privateKey, publicKey);
        //插入标记
        boolean flag_user;
        List<User> flag_queryUser;
        //缺少数据判定
        if (user.getUserPwd_zch_hwz_gjc().isEmpty()) {
            return ResponseEntity.ok(ResponseResult.of(100, "请输入用户密码!"));
        }
        if (user.getUserPhone_zch_hwz_gjc().isEmpty()) {
            //用正则表达式判断手机号是否符合规范
            if (!user.getUserPhone_zch_hwz_gjc().matches("^1[3456789]\\d{9}$")) {
                return ResponseEntity.ok(ResponseResult.of(100, "请输入正确的手机号!"));
            }
            return ResponseEntity.ok(ResponseResult.of(100, "请输入手机号!"));
        }
        // 补全用户类
        user.setUserInDate_zch_hwz_gjc(DateTime.now());

        byte[] decrypt = rsa.decrypt(user.getUserPwd_zch_hwz_gjc(), KeyType.PrivateKey);
        user.setUserPwd_zch_hwz_gjc(new String(decrypt));
        //查询用户信息
        flag_queryUser = userService.queryUser(user);
        //判断是否重复
        if (flag_queryUser == null || flag_queryUser.isEmpty()) {
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
                return ResponseEntity.ok(ResponseResult.ok(userService.getUserIdByAccount(account)));
            } else {
                return ResponseEntity.ok(ResponseResult.of(100, "用户注册失败!"));
            }
        } else {
            return ResponseEntity.ok(ResponseResult.of(100, "用户信息已被注册!"));
        }
    }

    /**
     * 创建用户信息
     *
     * @param userInformation 用户信息类
     */
    @PostMapping("/info")//用户信息插入
    @ResponseBody
    public ResponseEntity<?> insertUserInf_zch_hwz_gjc(@RequestBody UserInformation userInformation,HttpServletRequest req) {
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

    /**
     * 通过用户账号判断账号是否可用
     *
     * @param userAccount 用户账号
     */
    @GetMapping("/check")//通过用户账号判断账号是否可用
    @ResponseBody
    public ResponseEntity<?> getUserAccountByAccount_zch_hwz_gjc(@RequestParam String userAccount,
                                                                 HttpServletRequest req) {
        if (userService.getUserAccountByAccount_zch_hwz_gjc(userAccount) != null) {
            return ResponseEntity.ok(ResponseResult.of(100, "该账号已被使用!"));
        } else {
            return ResponseEntity.ok(ResponseResult.ok("该账号可用!"));
        }
    }

    /**
     * 用户登录
     *
     * @param user 用户类
     */
    @SneakyThrows
    @ResponseBody
    @PostMapping("/login")//用户登录
    public ResponseEntity<ResponseResult<?>> userLogin_zch_hwz_hwz(@RequestBody User user, HttpServletRequest req) {
        String token = userService.userLogin_zch_hwz_gjc(user);
        User user1 = userService.queryUserForLogin(user);
        PJUser pjUser = PJUser.builder().token(token).userId(user1.getUserId_zch_hwz_gjc()).build();
        if (token != null) {
            return ResponseEntity.ok(ResponseResult.ok(pjUser));
        } else {
            return ResponseEntity.ok(ResponseResult.of(USER_NOT_EXIST));
        }
    }

    /**
     * 用户登录通过手机号
     *
     * @param userPhone 手机号
     */
    @SneakyThrows
    @ResponseBody
    @PostMapping("/login/phone")//用户登录通过手机
    public ResponseEntity<ResponseResult<?>> loginByPhone(@RequestParam String userPhone, HttpServletRequest req) {

        User user = userService.loginByPhone(userPhone);
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

    /**
     * 获取用户信息
     *
     * @param userId 用户ID
     */
    @SneakyThrows
    @ResponseBody
    @GetMapping("/info")
    public ResponseEntity<ResponseResult<?>> getUserInformation(
//            @RequestParam String token,
            @RequestParam int userId,
            HttpServletRequest req) {
//        boolean flag = JwtUtil.verifyToken(token);
//        Long verifyUserId = JwtUtil.getUserIdFromToken(token);
//        if (verifyUserId != userId) {
//            return ResponseEntity.ok(ResponseResult.of(500, "用户信息错误"));
//        }
        User user = userMapper.selectById(userId);
        if (user != null) {
            PojoUser pojoUser = new PojoUser();
//            pojoUser.setToken(token);
            pojoUser.setUserId(userId);
            pojoUser.setUser(userService.getById((long) userId));
            pojoUser.setUserInformation(userInformationService.getUserInformationByUserId((long) userId));
            UserHeadImage userHeadImage = userHeadImageService.getUserHeadImageByUserId((long) userId);
            pojoUser.setUserHeadImage(userHeadImage);

            return ResponseEntity.ok(ResponseResult.ok(pojoUser));
        }
        return ResponseEntity.ok(ResponseResult.error("查询失败"));
    }

    /**
     * 用户忘记密码找回
     *
     */
    @SneakyThrows
    @ResponseBody
    @PostMapping("/forget")//忘记密码
    public ResponseEntity<ResponseResult<?>> userForget_zch_hwz_gjc(@RequestBody User user,
                                                                    HttpServletRequest req) {
        Boolean userFlag = userService.userForget_zch_hwz_gjc(user);
        if (userFlag) {
            return ResponseEntity.ok(ResponseResult.of(200, "用户存在!"));
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("用户不存在!"));
        }
    }

    /**
     * 设置用户密码
     *
     * @param user 用户类
     */
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
            return ResponseEntity.ok().body(ResponseResult.error("用户不存在"));
        }

        // 设置新密码
        existingUser.setUserPwd_zch_hwz_gjc(plainTextPassword);

        // 更新用户信息
        boolean updateSuccess = userService.updateById(existingUser);
        if (updateSuccess) {
            return ResponseEntity.ok(ResponseResult.ok(existingUser.getUserId_zch_hwz_gjc()));
        } else {
            return ResponseEntity.ok().body(ResponseResult.error("设置密码失败，数据可能已被其他用户修改"));
        }
    }

    /**
     * 上传用户头像
     *
     */
    @PostMapping("/img")
    public ResponseEntity<ResponseResult<?>> uploadUserHeadImage(@RequestBody @ModelAttribute PJFile pjFile) throws IOException {

        if (!ALLOWED_FILE_TYPES.contains(pjFile.getFile().getContentType())) {
            return ResponseEntity.ok().body(ResponseResult.error("文件类型错误"));
        }

        String imagePath = saveUploadedFile(pjFile.getUserId(), pjFile.getFile());
        if (imagePath != null) {
            imagePath = HandlePath.extractRelativePath(imagePath, "image/HeadImage/");
        }
        UserHeadImage userHeadImage = userHeadImageService.saveOrUpdateUserHeadImage(pjFile.getUserId(), imagePath);
        QueryWrapper<UserInformation> queryWrapper =
                new QueryWrapper<UserInformation>().eq("userId_zch_hwz_gjc", pjFile.getUserId());
        UserInformation userInformation = userInformationService.getOne(queryWrapper);
        userInformation.setUserHeadId_zch_hwz_gjc(userHeadImage.getUserImageId_zch_hwz_gjc());
        userInformationMapper.updateById(userInformation);
        User user = userMapper.selectById(pjFile.getUserId());
        user.setUserHeadImage_zch_hwz_gjc(imagePath);
        userMapper.updateById(user);
        return ResponseEntity.ok(ResponseResult.ok(userHeadImage));
    }

    /**
     * 保存上传的文件
     *
     * @param userId 用户ID
     * @param file   上传的文件
     */
    private String saveUploadedFile(Long userId, MultipartFile file) throws IOException {
        if (file.isEmpty()) {
            throw new IOException("Failed to store empty file.");
        }

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String newFileName = userId + "-" + timestamp + "." + getFileExtension(file.getOriginalFilename());
        try {
            return tencentCOSUtils.upload(file, newFileName, "HeadImage/");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to upload file to Tencent COS", e);
        }
    }


    /**
     * 获取文件后缀名
     *
     * @param fileName 文件名
     */
    private String getFileExtension(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }

    /**
     * 更新用户信息
     *
     */
    @SneakyThrows
    @ResponseBody
    @PutMapping("/info")
    public ResponseEntity<ResponseResult<?>> updateUserInf(
            @RequestBody UserInformation userInformation,
            HttpServletRequest req) {
        return ResponseEntity.ok(ResponseResult.ok(userInformationService.updateUserInformation(userInformation)));
    }

    /**
     * 获取用户头像
     *
     * @param userId 用户ID
     */
    @SneakyThrows
    @ResponseBody
    @GetMapping("/img/{id}")
    public ResponseEntity<ResponseResult<?>> getHeadImg(@PathVariable("id") Long userId) {
        String imagePath = userInformationService.getUserImagePath(userId);
        if (imagePath == null) {
            return ResponseEntity.notFound().build();
        }
        try {
            return ResponseEntity.ok(ResponseResult.ok(imagePath));
        } catch (Exception e) {
            return ResponseEntity.ok().build();
        }
    }


    /**
     * 判断头像是否需要更新
     *
     * @param userId     用户ID
     * @param inDateTime 插入图片时的时间戳
     */
    @SneakyThrows
    @ResponseBody
    @GetMapping("/img/check")
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
                return ResponseEntity.ok(ResponseResult.of(210, "头像需要更新"));
            }
        } else {
            // 用户ID没有对应的头像
            return ResponseEntity.ok(ResponseResult.error("用户没有头像"));
        }
    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseResult<?>> deleteUser(
            @PathVariable("id") Long userId,
            HttpServletRequest req) {

        QueryWrapper<AccountBalance> queryWrapper5 = new QueryWrapper<>();
        queryWrapper5.eq("userId_zch_hwz_gjc", userId);
        AccountBalance accountBalance = accountBalanceMapper.selectOne(queryWrapper5);

        if (accountBalance.getUserBalance_zch_hwz_gjc() > 0) {
            return ResponseEntity.ok(ResponseResult.error("用户余额大于0，不能注销"));
        }

        if (accountBalance.getUserBalance_zch_hwz_gjc() < 0) {
            return ResponseEntity.ok(ResponseResult.error("用户欠款未偿还，不能注销"));
        }

        QueryWrapper<Order> queryWrapper6 = new QueryWrapper<>();
        queryWrapper6.eq("userId_zch_hwz_gjc", userId);
        List<Order> orders = orderMapper.selectList(queryWrapper6);

        boolean hasUnfinishedOrder = false;

        for (Order order : orders) {
            String state = order.getOrderState_zch_hwz_gjc();
            if (!state.equals("已结束") && !state.equals("已取消") && !state.equals("已退款")) {
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

    /**
     * 刷新Token
     *
     * @param token 旧Token
     */
    @PostMapping("/refreshToken")
    public ResponseEntity<ResponseResult<?>> refreshToken(@RequestParam String token) {
        // 验证旧的Token
        if (!JwtUtil.verifyToken(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ResponseResult.error("无效的Token"));
        }
        // 从旧Token中获取用户ID
        Long userId = JwtUtil.getUserIdFromToken(token);

        // 生成新的Token
        String newToken = JwtUtil.createToken(userId);

        // 返回新的Token
        return ResponseEntity.ok(ResponseResult.ok(newToken));
    }

    /**
     * 更新用户基本信息
     *
     */
    @ResponseBody
    @PutMapping
    public ResponseEntity<ResponseResult<?>> updateUserBasicInf(@RequestBody User u,
            HttpServletRequest request) {
        try {
            // 检查userId是否存在
            if (u.getUserId_zch_hwz_gjc() == null) {
                return ResponseEntity.ok().body(ResponseResult.error("用户编号不能为空"));
            }
            // 从数据库中查询当前用户记录
            User currentUser = userMapper.selectById(u.getUserId_zch_hwz_gjc());
            if (currentUser == null) {
                return ResponseEntity.ok().body(ResponseResult.error("用户编号不存在"));
            }

            // 更新需要修改的字段
            if (u.getUserName_zch_hwz_gjc() != null && !u.getUserName_zch_hwz_gjc().isEmpty()) {
                currentUser.setUserName_zch_hwz_gjc(u.getUserName_zch_hwz_gjc());
            }
            if (u.getUserEmail_zch_hwz_gjc() != null && !u.getUserEmail_zch_hwz_gjc().isEmpty()) {
                currentUser.setUserEmail_zch_hwz_gjc(u.getUserEmail_zch_hwz_gjc());
            }
            if (u.getUserPhone_zch_hwz_gjc() != null && !u.getUserPhone_zch_hwz_gjc().isEmpty()) {
                currentUser.setUserPhone_zch_hwz_gjc(u.getUserPhone_zch_hwz_gjc());
            }
            if(Objects.nonNull(u.getUserHeadImage_zch_hwz_gjc()) && !u.getUserHeadImage_zch_hwz_gjc().isEmpty()) {
                currentUser.setUserHeadImage_zch_hwz_gjc(u.getUserHeadImage_zch_hwz_gjc());
            }

            // 使用乐观锁更新方法
            int result = userMapper.updateById(currentUser);

            // 检查是否有数据被更新
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok(userMapper.selectById(u.getUserId_zch_hwz_gjc())));
            } else {
                return ResponseEntity.ok().body(ResponseResult.error("更新失败，请重试"));
            }
        } catch (Exception e) {
            // 这里可以记录日志或者返回具体的错误信息
            e.printStackTrace();
            return ResponseEntity.ok().body(ResponseResult.error("更新失败，发生异常"));
        }
    }
}
