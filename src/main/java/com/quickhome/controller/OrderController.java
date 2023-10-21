package com.quickhome.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.quickhome.domain.AccountBalance;
import com.quickhome.domain.HomeInformation;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.domain.Order;
import com.quickhome.mapper.AccountBalanceMapper;
import com.quickhome.mapper.OrderMapper;
import com.quickhome.pojo.PJOrder;
import com.quickhome.pojo.PJUserTenant;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.HomeInformationService;
import com.quickhome.service.HomeService;
import com.quickhome.service.IdCardRecordService;
import com.quickhome.service.OrderService;
import com.quickhome.util.DynamicDoorPassword;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
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

//    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

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
        String dateTime =String.valueOf(DateTime.now());
        String dynamicDoorPassword = null;
        if (dateTime.compareTo(LocalDate.now().toString()) >= 0) {
            dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
        } else {
            dynamicDoorPassword = "未到入住时间";
        }
        Boolean flag = orderService.updateDynamicDoorPassword(orderId, dynamicDoorPassword);
        if(flag) {
            byte[] encrypt = rsa.encrypt(dynamicDoorPassword, KeyType.PublicKey);
            return ResponseEntity.ok(ResponseResult.ok(Base64.encode(encrypt)));
        }else {
            return ResponseEntity.ok(ResponseResult.of(NOT_UPDATE));
        }
    }

    /**
     * 获取用户全部订单
     * @param userId 用户id
     * @return 用户全部订单
     */

    @GetMapping("/getAllUserOrder")
    public ResponseEntity<ResponseResult<?>> getAllUserOrders(@RequestParam Long userId) {
        List<Order> orders = orderService.getAllUserOrders(userId);
        for (Order order : orders){
            RSA rsa = new RSA(privateKey, publicKey);
            byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
            order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        }
        return ResponseEntity.ok(ResponseResult.ok(orders));
    }

    @ResponseBody
    @PostMapping("/payOrder")
    public ResponseEntity<ResponseResult<?>> payOrder(
            @RequestParam Long orderId,
            HttpServletRequest req) {

        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单不存在"));
        }

        if (!"未支付".equals(order.getOrderState_zch_hwz_gjc())) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单状态不允许支付"));
        }

        // 调用AccountBalanceController的updateMoney方法进行支付
        ResponseEntity<ResponseResult<?>> paymentResponse = accountBalanceController.updateMoney(order.getUserId_zch_hwz_gjc(), -order.getOrderPayment_zch_hwz_gjc(), req);

        System.out.println(order.getUserId_zch_hwz_gjc()+"  "+ -order.getOrderPayment_zch_hwz_gjc());
        System.out.println(paymentResponse.getStatusCode());

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