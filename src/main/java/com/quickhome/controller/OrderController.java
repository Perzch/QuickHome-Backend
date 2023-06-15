package com.quickhome.controller;

import com.quickhome.entity.Order;
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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Random;

@Controller("OrderCon")
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    OrderService orderService_;

    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    @PostMapping("/addOrder")
    public ResponseEntity<Order> addOrder_zch_hwz_gjc(@RequestBody Order order, HttpServletRequest req) {
        DynamicDoorPassword dynamicDoorPassword_zch_hwz_gjc=new DynamicDoorPassword();
        order.setDynamicDoorPassword_zch_hwz_gjc(String.valueOf(dynamicDoorPassword_zch_hwz_gjc.DynamicDoorPassword()));
        LocalDateTime now_zch_hwz_gjc = LocalDateTime.now();
        DateTimeFormatter formatter_zch_hwz_gjc = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String creationTimeString_zch_hwz_gjc = now_zch_hwz_gjc.format(formatter_zch_hwz_gjc);
        Date creationTime_zch_hwz_gjc = java.sql.Timestamp.valueOf(creationTimeString_zch_hwz_gjc);
        order.setCreationTime_zch_hwz_gjc(creationTime_zch_hwz_gjc);
        int x_zch_hwz_gjc = orderService_.addOrder_zch_hwz_gjc(order);
        System.out.println("成功添加了" + x_zch_hwz_gjc + "条订单");
        System.out.println(order);
        return ResponseEntity.ok(order);
    }
}