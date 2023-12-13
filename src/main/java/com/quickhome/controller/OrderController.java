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
import com.quickhome.service.*;
import com.quickhome.util.DynamicDoorPassword;
import com.quickhome.util.ValidationUtils;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.quickhome.request.ResultCode.NOT_UPDATE;

@Transactional
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
    private IdentityCheckListService identityChecklistService;

    @Autowired
    private AccountBalanceController accountBalanceController;

    @Autowired
    private UsersAndCouponsMapper usersAndCouponsMapper;

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private AccountBalanceService accountBalanceService;

//    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    private boolean isCouponValid(Long couponId, Double orderAmount, Long userId) {
        Coupon coupon = couponMapper.selectById(couponId);
        if (coupon == null) {
            return false;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年M月d日 ahh:mm:ss", Locale.CHINA);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime earliestUseTime = LocalDateTime.parse(coupon.getEarliestUseTime_zch_hwz_gjc().toLocaleString(), formatter);
        LocalDateTime latestUseTime = LocalDateTime.parse(coupon.getLatestUseTime_zch_hwz_gjc().toLocaleString(), formatter);

        if (now.isBefore(earliestUseTime) || now.isAfter(latestUseTime)) {
            return false;
        }

        if (orderAmount < coupon.getUseThreshold_zch_hwz_gjc()) {
            return false;
        }

        // 检查用户是否有未使用的同种优惠券
        QueryWrapper<UsersAndCoupons> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId)
                .eq("couponId_zch_hwz_gjc", couponId)
                .ne("condition_zch_hwz_gjc", "已使用") // 使用 ne 表示 “不等于”
                .eq("deleted_zch_hwz_gjc", 0);

        Long count = usersAndCouponsMapper.selectCount(queryWrapper);
        if (count == 0) {
            // 用户没有未使用的同种优惠券
            return false;
        }

        return true;
    }


    /**
     * 插入订单
     * @param pjOrder 自定义订单类
     * @param req
     * @return
     */

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
//        if (checkInDate.compareTo(LocalDate.now().toString()) <= 0) {
//            dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
//        } else {
        dynamicDoorPassword = "未生成动态密码";
//        }
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
        List<Long> idCardRecordIds = new ArrayList<>();

        for (PJUserTenant userTenant : userTenantList) {
            // 验证身份证号码和手机号码
            if (!ValidationUtils.isValidIdCard(userTenant.getCardIdNumber()) || !ValidationUtils.isValidPhone(userTenant.getPhone())) {
                continue; // 如果不符合正则表达式，则跳过此记录
            }

            IdCardRecord idCardRecord = IdCardRecord.builder()
                    .IDCardName_zch_hwz_gjc(userTenant.getName())
                    .IDCardNumber_zch_hwz_gjc(userTenant.getCardIdNumber())
                    .IDCardPhoneNumber_zch_hwz_gjc(userTenant.getPhone())
                    .userId_zch_hwz_gjc(userId)
                    .build();

            Boolean save = idCardRecordService.save(idCardRecord);
            if (!save) {
                continue; // 如果保存失败，也跳过此记录
            }

            // 保存新创建的身份证记录的ID
            idCardRecordIds.add(idCardRecord.getIDCardRecordID_zch_hwz_gjc());
        }

        for (Long idCardRecordId : idCardRecordIds) {
            IdentityCheckList identityChecklist = new IdentityCheckList();
            identityChecklist.setIDCardRecordID_zch_hwz_gjc(idCardRecordId);
            identityChecklist.setOrderID_zch_hwz_gjc(order.getOrderId_zch_hwz_gjc()); // 假设 order 是新创建的订单实体
            // 可以设置其他字段

            // 保存到数据库
            identityChecklistService.save(identityChecklist);
        }
        return ResponseEntity.ok(ResponseResult.ok(order));
    }

    /**
     * 获取动态房屋密码
     * @param orderId 订单ID
     * @param req
     * @return
     */

    @GetMapping("/getDynamicDoorPassword")
    public ResponseEntity<?> getDynamicDoorPassword(@RequestParam Long orderId,
                                                    HttpServletRequest req) {
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单不存在"));
        }

        // 获取当前时间
        LocalDateTime now = LocalDateTime.now(ZoneId.systemDefault());

        // 获取订单的入住时间，并将时间设置为当天的12点
        LocalDateTime checkInDateAtNoon = order.getCheckInTime_zch_hwz_gjc().toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate()
                .atTime(LocalTime.NOON);

        // 检查当前时间是否已经过了入住时间当天的12点
        if (now.isBefore(checkInDateAtNoon)) {
            return ResponseEntity.badRequest().body(ResponseResult.error("还未到生成房屋密码的时间"));
        }

        // 如果已经过了12点，则生成动态门密码
        RSA rsa = new RSA(privateKey, publicKey);
        String dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
        byte[] encrypt = rsa.encrypt(dynamicDoorPassword, KeyType.PublicKey);

        // 更新订单中的动态门密码
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("orderId_zch_hwz_gjc", orderId)
                .set("DynamicDoorPassword_zch_hwz_gjc", dynamicDoorPassword);
        orderMapper.update(order, updateWrapper);

        // 返回加密后的动态门密码
        return ResponseEntity.ok(ResponseResult.ok(Base64.encode(encrypt)));
    }

    /**
     * 生成动态房屋密码
     * @param orderId 订单ID
     * @param req
     * @return
     */

    @PostMapping("/creatDynamicDoorPassword")
    public ResponseEntity<ResponseResult<?>> creatDynamicDoorPassword(@RequestParam Long orderId, HttpServletRequest req) {
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

        IPage<Order> ordersPage = orderMapper.selectPage(page,
                new QueryWrapper<Order>()
                        .eq("userId_zch_hwz_gjc", userId)
                        .orderByDesc("creationTime_zch_hwz_gjc")); // 添加排序条件

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

    /**
     * 支付订单
     *
     * @param orderId 订单ID
     * @param UACID   用户优惠券关联ID，可选参数
     * @param req
     * @return
     */

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

        // 实际付款金额（已包含优惠券折扣）
        Double actualPayment = order.getOrderPayment_zch_hwz_gjc() - order.getOrderDeposit_zch_hwz_gjc();

        // 还原优惠券应用前的原始订单金额
        Double originalOrderAmount = actualPayment;

        // 如果提供了UACID
        if (UACID != null) {
            UsersAndCoupons userCoupon = usersAndCouponsMapper.selectById(UACID);
            if (userCoupon == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("用户优惠券关联不存在"));
            }
            Long couponId = userCoupon.getCouponId_zch_hwz_gjc();
            Coupon coupon = couponMapper.selectById(couponId);
            if (coupon == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("优惠券不存在"));
            }

            // 根据优惠券类型还原原始订单金额
            if ("折扣".equals(coupon.getDiscountMethod_zch_hwz_gjc())) {
                originalOrderAmount /= coupon.getDiscountIntensity_zch_hwz_gjc();
            } else if ("满减".equals(coupon.getDiscountMethod_zch_hwz_gjc())) {
                originalOrderAmount += coupon.getDiscountIntensity_zch_hwz_gjc();
            }

            // 检查优惠券是否有效
            if (!isCouponValid(coupon.getCouponId_zch_hwz_gjc(), originalOrderAmount, userCoupon.getUserId_zch_hwz_gjc())) {
                return ResponseEntity.badRequest().body(ResponseResult.error("优惠券不可使用"));
            }
        }

        // 调用AccountBalanceController的updateMoney方法进行支付
        ResponseEntity<ResponseResult<?>> paymentResponse = accountBalanceController.updateMoney(order.getUserId_zch_hwz_gjc(), -(actualPayment + order.getOrderDeposit_zch_hwz_gjc()), req);

        // 检查支付结果
        if (!paymentResponse.getStatusCode().is2xxSuccessful()) {
            return ResponseEntity.badRequest().body(ResponseResult.error("支付失败"));
        }

        // 使用UpdateWrapper更新订单状态为“已支付”
        UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("orderId_zch_hwz_gjc", orderId)
                .eq("orderState_zch_hwz_gjc", "未支付")  // 加入当前订单状态的检查
                .set("orderState_zch_hwz_gjc", "已支付");
        boolean updateSuccess = orderMapper.update(order, updateWrapper) > 0;

        if (!updateSuccess) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单状态更新失败，可能已经被其他用户修改"));
        }

        order = orderMapper.selectById(orderId);
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        return ResponseEntity.ok(ResponseResult.ok(order));
    }

    /**
     * 退房
     *
     * @param orderId 订单ID
     * @param req
     * @return
     */

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

    /**
     * 取消订单计划
     *
     * @param orderId 订单ID
     * @return
     */

    @PostMapping("/scheduleCancellation")
    public ResponseEntity<ResponseResult<?>> scheduleOrderCancellation(@RequestParam Long orderId) {
        orderService.scheduleOrderCancellation(orderId, 5); // 5分钟后检查
        return ResponseEntity.ok(ResponseResult.ok("已接收订单"));
    }

    /**
     * 结束订单
     *
     * @param orderId          订单ID
     * @param maintenanceCost  维修费用
     * @param req
     * @return
     */

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

    /**
     * 更新订单信息
     *
     * @param order
     * @param req
     * @return
     */

    @ResponseBody
    @PostMapping("/updateOrder")
    public ResponseEntity<ResponseResult<?>> updateOrder(
            @RequestBody Order order,
            HttpServletRequest req) {
        try {
            if (order.getOrderId_zch_hwz_gjc() == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("订单ID不能为空"));
            }

            // 从数据库中查询当前记录
            Order currentOrder = orderMapper.selectById(order.getOrderId_zch_hwz_gjc());
            if (currentOrder == null) {
                return ResponseEntity.badRequest().body(ResponseResult.error("订单ID不存在"));
            }

            // 更新需要修改的字段
            if (order.getEndTime_zch_hwz_gjc() != null) {
                currentOrder.setEndTime_zch_hwz_gjc(order.getEndTime_zch_hwz_gjc());
            }
            if (order.getCheckOutTime_zch_hwz_gjc() != null) {
                currentOrder.setCheckOutTime_zch_hwz_gjc(order.getCheckOutTime_zch_hwz_gjc());
            }
            if (order.getOrderPayment_zch_hwz_gjc() != null) {
                currentOrder.setOrderPayment_zch_hwz_gjc(order.getOrderPayment_zch_hwz_gjc());
            }
            if (order.getOrderState_zch_hwz_gjc() != null) {
                currentOrder.setOrderState_zch_hwz_gjc(order.getOrderState_zch_hwz_gjc());
            }

            // 使用乐观锁更新方法
            int result = orderMapper.updateById(currentOrder);
            if (result > 0) {
                // 重新从数据库中查询更新后的记录
                Order updatedOrder = orderMapper.selectById(order.getOrderId_zch_hwz_gjc());

                // 加密动态门密码
                RSA rsa = new RSA(privateKey, publicKey);

                String dynamicDoorPassword = updatedOrder.getDynamicDoorPassword_zch_hwz_gjc();
                if (dynamicDoorPassword != null) {
                    byte[] encrypt = rsa.encrypt(dynamicDoorPassword, KeyType.PublicKey);
                    updatedOrder.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
                }

                return ResponseEntity.ok(ResponseResult.ok(updatedOrder));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("更新失败，请重试"));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(ResponseResult.error("更新订单信息出错: " + e.getMessage()));
        }
    }

    /**
     * 删除订单
     *
     * @param orderId
     * @return
     */

    @DeleteMapping("/delOrder")
    public ResponseEntity<ResponseResult<?>> deleteOrder(@RequestParam Long orderId) {
        try {
            // 构建更新条件
            UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("orderId_zch_hwz_gjc", orderId)
                    .set("deleted_zch_hwz_gjc", 1);

            int result = orderMapper.update(null, updateWrapper);
            if (result > 0) {
                return ResponseEntity.ok(ResponseResult.ok("订单删除成功"));
            } else {
                return ResponseEntity.badRequest().body(ResponseResult.error("删除失败，订单可能不存在或已被删除"));
            }
        } catch (Exception e) {
            // Log the exception or handle it as needed
            return ResponseEntity.badRequest().body(ResponseResult.error("删除失败"));
        }
    }

    /**
     * 退款或取消订单
     *
     * @param orderId
     * @return
     */

    @ResponseBody
    @PostMapping("/endOrderRefund")
    public ResponseEntity<ResponseResult<?>> endOrderRefund(@RequestParam Long orderId) {
        // 1. 根据orderId查询订单
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            return ResponseEntity.badRequest().body(ResponseResult.error("订单不存在"));
        }

        // 2. 检查订单是否已经获取了动态门密码
        boolean passwordObtained = order.getDynamicDoorPassword_zch_hwz_gjc() == null || order.getDynamicDoorPassword_zch_hwz_gjc().equals("未生成动态密码");

        // 3. 对比当前时间与订单的创建时间，判断是否超过30分钟
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime creationTime = LocalDateTime.ofInstant(order.getCreationTime_zch_hwz_gjc().toInstant(), ZoneId.systemDefault());
        boolean overThirtyMinutes = ChronoUnit.MINUTES.between(creationTime, now) > 30;

        // 4. 执行全额退款或保留全款
        if (!overThirtyMinutes && passwordObtained) {
            // 全额退款逻辑
            // 更新用户账户余额
            // 假设有一个方法来更新用户余额
            boolean refundSuccess = accountBalanceService.refundUserBalance(order.getUserId_zch_hwz_gjc(), order.getOrderPayment_zch_hwz_gjc());
            if (!refundSuccess) {
                return ResponseEntity.badRequest().body(ResponseResult.error("退款失败"));
            }
            // 将订单的押金清零
            order.setOrderState_zch_hwz_gjc("已退款");
            order.setDynamicDoorPassword_zch_hwz_gjc("订单已结束");
            order.setOrderState_zch_hwz_gjc("已退款");
            order.setEndTime_zch_hwz_gjc(DateTime.now());
            order.setOrderDeposit_zch_hwz_gjc(0.0);
        } else {
            // 保留全款，需要管理员操作结束订单
            // 这里不执行任何操作，等待管理员处理
            order.setOrderState_zch_hwz_gjc("已退房");
            order.setDynamicDoorPassword_zch_hwz_gjc("订单已结束");
        }

        // 5. 更新订单状态和相关信息
        int updated = orderMapper.updateById(order);
        if (updated <= 0) {
            return ResponseEntity.badRequest().body(ResponseResult.error("更新订单失败"));
        }
        RSA rsa = new RSA(privateKey, publicKey);
        byte[] encrypt = rsa.encrypt(order.getDynamicDoorPassword_zch_hwz_gjc(), KeyType.PublicKey);
        order.setDynamicDoorPassword_zch_hwz_gjc(Base64.encode(encrypt));
        // 返回更新后的订单信息
        return ResponseEntity.ok(ResponseResult.ok(order));
    }

    /**
     * 根据房源ID查询订单
     *
     * @param homeId 房源ID
     * @param currentPage 当前页
     * @param pageSize 每页大小
     * @return
     */

    @GetMapping("/getOrdersByHouseId")
    public ResponseEntity<ResponseResult<?>> getOrdersByHouseId(
            @RequestParam Long homeId,
            @RequestParam(defaultValue = "1") int currentPage,
            @RequestParam(defaultValue = "10") int pageSize) {

        try {
            IPage<Order> ordersPage = orderService.getOrdersByHouseId(homeId, currentPage, pageSize);
            return ResponseEntity.ok(ResponseResult.ok(ordersPage));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(ResponseResult.error("查询订单失败: " + e.getMessage()));
        }
    }


}