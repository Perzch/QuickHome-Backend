package com.quickhome.controller;

import cn.hutool.core.codec.Base64;
import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.asymmetric.KeyType;
import cn.hutool.crypto.asymmetric.RSA;
import com.quickhome.domain.HomeInformation;
import com.quickhome.domain.IdCardRecord;
import com.quickhome.domain.Order;
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
    String privateKey;
    @Value("${rsa.public_key}")
    String publicKey;
    //服务
    @Autowired
    private OrderService orderService;
    @Autowired
    private IdCardRecordService idCardRecordService;
    @Autowired
    private HomeService homeService;
    @Autowired
    private HomeInformationService homeInformationService;

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
    public ResponseEntity<?> getDynamicDoorPassword(@RequestParam Long OrderId,
                                                    HttpServletRequest req) {
        RSA rsa = new RSA(privateKey, publicKey);
        String dynamicDoorPassword = orderService.getDynamicDoorPassword(OrderId);
        byte[] encrypt = rsa.encrypt(dynamicDoorPassword, KeyType.PublicKey);
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

}