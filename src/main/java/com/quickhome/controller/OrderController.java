package com.quickhome.controller;

import cn.hutool.core.date.DateTime;
import com.quickhome.domain.Order;
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

@Controller("OrderCon")
@RequestMapping("/Order")
public class OrderController{
    @Autowired
    private OrderService orderService_;

    static final Log Logger = LogFactory.getLog(HomeInformationController.class);

    @PostMapping("/addOrder")
    public ResponseEntity<?> addOrder_zch_hwz_gjc(@RequestBody Order order, HttpServletRequest req) {
//        order.setDynamicDoorPassword_zch_hwz_gjc(String.valueOf(DynamicDoorPassword.dynamicDoorPassword()));
        order.setCreationTime_zch_hwz_gjc(DateTime.now());//当前时间
        order.setOrderState_zch_hwz_gjc("未支付");
        boolean flag = orderService_.save(order);
        return ResponseEntity.ok(ResponseResult.ok(order));
    }
}