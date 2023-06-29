package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.Order;
import com.quickhome.pojo.PJOrder;
import com.quickhome.pojo.PJUserTenant;
import com.quickhome.request.ResponseResult;
import com.quickhome.service.OrderService;
import com.quickhome.util.DynamicDoorPassword;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller("OrderCon")
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService_;

    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder_zch_hwz_gjc(@RequestBody PJOrder pjOrder,
                                                  HttpServletRequest req) {
        List<PJUserTenant> userTenantList = pjOrder.getUserTenantList();
        String checkInDate = pjOrder.getCheckInDate();
        String checkOutDate = pjOrder.getCheckOutDate();
        Long homeId = pjOrder.getHomeId();
        Long userId = pjOrder.getUserId();
        String dynamicDoorPassword = null;
        if (checkInDate.compareTo(LocalDate.now().toString()) >= 0) {
            dynamicDoorPassword = DynamicDoorPassword.dynamicDoorPassword();
        }


        Order order = Order.builder()
                .homeId_zch_hwz_gjc(homeId)
                .dynamicDoorPassword_zch_hwz_gjc(dynamicDoorPassword)
                .creationTime_zch_hwz_gjc(DateTime.now())
                .checkOutTime_zch_hwz_gjc(Date.valueOf(checkOutDate))
                .checkInTime_zch_hwz_gjc(Date.valueOf(checkInDate))
                .orderState_zch_hwz_gjc("未支付")
                .userId_zch_hwz_gjc(userId)
                .build();


//        order.setDynamicDoorPassword_zch_hwz_gjc(String.valueOf(DynamicDoorPassword.dynamicDoorPassword()));
//        order.setCreationTime_zch_hwz_gjc(DateTime.now());//当前时间
//        order.setOrderState_zch_hwz_gjc("未支付");
//        boolean flag = orderService_.save(order);
//        return ResponseEntity.ok(ResponseResult.ok(order));\
        return null;
    }
}