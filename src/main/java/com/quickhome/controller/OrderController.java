package com.quickhome.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.quickhome.domain.*;
import com.quickhome.mapper.AccountBalanceMapper;
import com.quickhome.mapper.CouponMapper;
import com.quickhome.mapper.OrderMapper;
import com.quickhome.mapper.UsersAndCouponsMapper;
import com.quickhome.pojo.PJOrder;
import com.quickhome.pojo.PJUserTenant;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.HomeInformationService;
import com.quickhome.service.HomeService;
import com.quickhome.service.IdCardRecordService;
import com.quickhome.service.OrderService;
import com.quickhome.util.DynamicDoorPassword;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static com.quickhome.request.ResultCode.NOT_UPDATE;
import static com.quickhome.request.ResultCode.USER_NOT_EXIST;

@Controller("OrderCon")
@RequestMapping("/Order")
public class OrderController {
    //公钥与私钥
    @Value("${rsa.private_key}")
    private String privateKey;
    @Value("${rsa.public_key}")
    private String publicKey;
    //服务
    @Autowired
    private OrderService orderService;
    @Autowired
    private AccountBalanceMapper accountBalanceMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private IdCardRecordService idCardRecordService;
    @Autowired
    private HomeService homeService;
    @Autowired
    private HomeInformationService homeInformationService;

    @Autowired
    private AccountBalanceController accountBalanceController;
    @Autowired
    private CouponController couponController;

    @Autowired
    private UsersAndCouponsMapper usersAndCouponsMapper;

    @Autowired
    private CouponMapper couponMapper;

//    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    private boolean isCouponValid(Long couponId, Double orderAmount, Long userId) {
        Coupon coupon = couponMapper.selectById(couponId);
        if (coupon == null) {
            return false;
        }

        // 1. 检查优惠券是否在有效期内
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 aH:mm:ss");

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime earliestUseTime = LocalDateTime.parse(coupon.getEarliestUseTime_zch_hwz_gjc().toLocaleString(), formatter);
        LocalDateTime latestUseTime = LocalDateTime.parse(coupon.getLatestUseTime_zch_hwz_gjc().toLocaleString(), formatter);
        if (now.isBefore(earliestUseTime) || now.isAfter(latestUseTime)) {
            return false;
        }

        // 2. 检查订单金额是否满足优惠券的使用门槛
        if (orderAmount < coupon.getUseThreshold_zch_hwz_gjc()) {
            return false;
        }

        // 3. 检查用户是否已经使用过该优惠券
        QueryWrapper<UsersAndCoupons> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq("couponId_zch_hwz_gjc", couponId)
                .eq("condition_zch_hwz_gjc", "已使用")
                .eq("deleted_zch_hwz_gjc", 0);
        UsersAndCoupons userCoupon = usersAndCouponsMapper.selectOne(queryWrapper);
        if (userCoupon != null) {
            return false;
        }

        return true;
    }

    @PostMapping("/insertOrder")
    public ResponseEntity<?> insertOrder(@RequestBody PJOrder pjOrder,
                                         HttpServletRequest req) {
        //对请求的体进行解析
        List<PJUserTenant> userTenantList = pjOrder.getUserTenantList();
        String checkInDate = pjOrder.getCheckInDate();
        String checkOutDate = pjOrder.getCheckOutDate();
        Long homeId = pjOrder.getHomeId();
        Long userId = pjOrder.getUserId();
        String dynamicDoorPassword = null;
        //用于给动态密码加密
        RSA rsa = new RSA(privateKey, publicKey);
        //判断当前时间是否可以获取动态房屋密码
        if (checkInDate.compareTo(LocalDate.now().toString()) >= 0) {
            dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
        } else {
            dynamicDoorPassword = "未到入住时间";
        }
        //写入租客身份证信息
        for (PJUserTenant userTenant : userTenantList) {
            IdCardRecord idCardRecord = IdCardRecord.builder()
                    .IDCardName_zch_hwz_gjc(userTenant.getName())
                    .IDCardNumber_zch_hwz_gjc(userTenant.getCardIdNumber())
                    .IDCardPhoneNumber_zch_hwz_gjc(userTenant.getPhone())
                    .userId_zch_hwz_gjc(userId)
                    .build();
            Boolean flag = idCardRecordService.save(idCardRecord);
            if (!flag) {
                return ResponseEntity.ok(ResponseResult.of(100, "写入租客身份证信息失败!"));
            }
        }
        //获取押金
        Double deposit = homeInformationService.getHomeDepositByHomeId(homeId);
        //获取单日租金
        Double dailyRent = homeService.getHomeDayRentByHomeId(homeId);
        //计算支付金额
        Double payment = 0.0;
        Date checkIn, checkOut;
        checkIn = Date.valueOf(checkInDate);
        checkOut = Date.valueOf(checkOutDate);
        long date = checkOut.getTime() - checkIn.getTime();
        String day = String.valueOf(date / (24 * 60 * 60 * 1000));
        payment = Integer.valueOf(day) * dailyRent + deposit;
        //构造实体类
        Order order = Order.builder()
                .homeId_zch_hwz_gjc(homeId)
                .dynamicDoorPassword_zch_hwz_gjc(dynamicDoorPassword)
                .creationTime_zch_hwz_gjc(DateTime.now())
                .checkInTime_zch_hwz_gjc(Date.valueOf(checkInDate))
                .checkOutTime_zch_hwz_gjc(Date.valueOf(checkOutDate))
                .orderPayment_zch_hwz_gjc(payment)
                .orderDeposit_zch_hwz_gjc(deposit)
                .orderState_zch_hwz_gjc("未支付")
                .userId_zch_hwz_gjc(userId)
                .build();
        boolean flag = orderService.save(order);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        return ResponseEntity.ok(ResponseResult.ok(order));
    }

    @GetMapping("/getDynamicDoorPassword")
    public ResponseEntity<?> getDynamicDoorPassword(@RequestParam Long orderId,
                                                    HttpServletRequest req) {
        RSA rsa = new RSA(privateKey, publicKey);
        String dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
        byte[] encrypt = rsa.encrypt(dynamicDoorPassword, KeyType.PublicKey);
        Order order = orderMapper.selectById(orderId);
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("orderId_zch_hwz_gjc", orderId)
                .set("DynamicDoorPassword_zch_hwz_gjc", dynamicDoorPassword);
        orderMapper.update(order, updateWrapper);
        return ResponseEntity.ok(ResponseResult.ok(Base64.encode(encrypt)));
    }

    @PostMapping("/creatDynamicDoorPassword")
    public ResponseEntity<ResponseResult<?>> creatDynamicDoorPassword(@RequestBody Long orderId, HttpServletRequest req) {
        RSA rsa = new RSA(privateKey, publicKey);
        String dateTime = String.valueOf(DateTime.now());
        String dynamicDoorPassword = null;
        if (dateTime.compareTo(LocalDate.now().toString()) >= 0) {
            dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
        } else {
            dynamicDoorPassword = "未到入住时间";
        }
        Boolean flag = orderService.updateDynamicDoorPassword(orderId, dynamicDoorPassword);
        if (flag) {
            byte[] encrypt = rsa.encrypt(dynamicDoorPassword, KeyType.PublicKey);
            return ResponseEntity.ok(ResponseResult.ok(Base64.encode(encrypt)));
        } else {
            return ResponseEntity.ok(ResponseResult.of(NOT_UPDATE));
        }
    }

    /**
     * 获取用户全部订单
     *
     * @param userId 用户id
     * @return 用户全部订单
     */

    @GetMapping("/getAllUserOrder")
    public ResponseEntity<ResponseResult<?>> getAllUserOrders(@RequestParam Long userId,
                                                              @RequestParam(defaultValue = "1") int currentPage,
                                                              @RequestParam(defaultValue = "10") int pageSize) {
        // 创建一个Page对象
        Page<Order> page = new Page<>(currentPage, pageSize);

        // 使用OrderMapper的selectPage方法进行分页查询
        IPage<Order> ordersPage = orderMapper.selectPage(page, new QueryWrapper<Order>().eq("userId_zch_hwz_gjc", userId).eq("deleted_zch_hwz_gjc", 0));

        List<Order> orders = ordersPage.getRecords();

        for (Order order : orders) {
            if (order.getDynamicDoorPassword_zch_hwz_gjc() != null) {
                RSA rsa = new RSA(privateKey, publicKey);
                byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
                order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
            }
        }

        return ResponseEntity.ok(ResponseResult.ok(ordersPage));  // 返回整个IPage对象，它包含了当前页的数据、总记录数、总页数等信息
    }



    // 根据优惠券的折扣方式和优惠力度计算实际支付金额

    @ResponseBody
    @PostMapping("/payOrder")
    public ResponseEntity<ResponseResult<?>> payOrder(
            @RequestParam Long orderId,
            @RequestParam(required = false) Long UACID,  // 用户优惠券关联ID，可选参数
            HttpServletRequest req) {

        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单不存在"));
        }

        if (!"未支付".equals(order.getOrderState_zch_hwz_gjc())) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单状态不允许支付"));
        }

        // 计算实际付款金额
        Double actualPayment = order.getOrderPayment_zch_hwz_gjc() - order.getOrderDeposit_zch_hwz_gjc();

        // 如果提供了UACID
        if (UACID != null) {
            UsersAndCoupons userCoupon = usersAndCouponsMapper.selectById(UACID);
            if (userCoupon == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("用户优惠券关联不存在"));
            }
            Long couponId = userCoupon.getCouponId_zch_hwz_gjc();
            ResponseEntity<ResponseResult<?>> couponResponse = couponController.getCouponInfo(couponId);
            if (!couponResponse.getStatusCode().is2xxSuccessful()) {
                return ResponseEntity.badRequest().body(ResponseResult.error("获取优惠券信息失败"));
            }
            Coupon coupon = (Coupon) couponResponse.getBody().getData();
            if (!isCouponValid(coupon.getCouponId_zch_hwz_gjc(),actualPayment, userCoupon.getUserId_zch_hwz_gjc())){
                return ResponseEntity.badRequest().body(ResponseResult.error("优惠券不可使用"));
            }
            // 根据coupon对象进行优惠券折扣逻辑
            if ("折扣".equals(coupon.getDiscountMethod_zch_hwz_gjc())) {
                actualPayment *= coupon.getDiscountIntensity_zch_hwz_gjc();
            } else if ("满减".equals(coupon.getDiscountMethod_zch_hwz_gjc())) {
                actualPayment -= coupon.getDiscountIntensity_zch_hwz_gjc();
            }
            // 注意：这里只是一个示例，您需要根据实际的优惠券逻辑来进行计算
        }

        // 调用AccountBalanceController的updateMoney方法进行支付
        ResponseEntity<ResponseResult<?>> paymentResponse = accountBalanceController.updateMoney(order.getUserId_zch_hwz_gjc(), -(actualPayment+order.getOrderDeposit_zch_hwz_gjc()), req);

        // 检查支付结果
        if (!paymentResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().body(ResponseResult.error("支付失败"));
        }

        // 使用UpdateWrapper更新订单状态为“已支付”
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("orderId_zch_hwz_gjc", orderId)
                .set("orderState_zch_hwz_gjc", "已支付");
        orderMapper.update(null, updateWrapper);

        order = orderMapper.selectById(orderId);
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        return ResponseEntity.ok(ResponseResult.ok(order));
    }



    @ResponseBody
    @PostMapping("/checkOut")
    public ResponseEntity<ResponseResult<?>> checkOut(
            @RequestParam Long orderId,
            HttpServletRequest req) {

        // 1. 根据orderId查询订单
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单不存在"));
        }

        // 2. 更改订单状态为“已退房”
        order.setOrderState_zch_hwz_gjc("已退房");

        // 3. 将房屋动态密码修改为“订单已结束”
        order.setDynamicDoorPassword_zch_hwz_gjc("订单已结束");

        // 4. 更新订单信息到数据库
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("orderId_zch_hwz_gjc", orderId);
        orderMapper.update(order, updateWrapper);

        order = orderMapper.selectById(orderId);
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        return ResponseEntity.ok(ResponseResult.ok(order));
    }


    @ResponseBody
    @PostMapping("/endOrder")
    public ResponseEntity<ResponseResult<?>> endOrder(
            @RequestParam Long orderId,
            @RequestParam Double maintenanceCost,
            HttpServletRequest req) {

        // 1. 根据orderId查询订单
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单不存在"));
        }

        Double deposit = order.getOrderDeposit_zch_hwz_gjc();
        Double refundAmount = 0.0;

        // 2. 检查维修金额
        if (maintenanceCost <= 0) {
            // 全额退回押金
            refundAmount = deposit;
            order.setOrderDeposit_zch_hwz_gjc(0.0);
        } else {
            // 扣除维修费用
            refundAmount = deposit - maintenanceCost;
            order.setOrderDeposit_zch_hwz_gjc(maintenanceCost);
        }

        // 3. 更新用户账户余额
        QueryWrapper<AccountBalance> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", order.getUserId_zch_hwz_gjc());
        AccountBalance accountBalance = accountBalanceMapper.selectOne(queryWrapper);
        if (accountBalance == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("用户不存在"));
        }

        Double currentBalance = accountBalance.getUserBalance_zch_hwz_gjc();
        if (refundAmount < 0) {
            // 如果押金不足以支付维修费用，从用户余额中扣除
            currentBalance += refundAmount;
        } else {
            // 退还剩余押金
            currentBalance += refundAmount;
        }
        accountBalance.setUserBalance_zch_hwz_gjc(currentBalance);
        accountBalanceMapper.updateById(accountBalance);

        // 4. 更新订单状态为“已结束”
        order.setOrderState_zch_hwz_gjc("已结束");
        order.setEndTime_zch_hwz_gjc(DateTime.now());
        orderMapper.updateById(order);
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));

        return ResponseEntity.ok(ResponseResult.ok(order));
    }

    @ResponseBody
    @PostMapping("/updateOrder")
    public ResponseEntity<ResponseResult<?>> updateOrder(
            @RequestBody Order order,
            HttpServletRequest req) {
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("orderId_zch_hwz_gjc", order.getOrderId_zch_hwz_gjc());
        orderMapper.update(order, updateWrapper);

        order = orderMapper.selectById(order.getOrderId_zch_hwz_gjc());
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        return ResponseEntity.ok(ResponseResult.ok(order));
    }

}