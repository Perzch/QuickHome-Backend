package com.quickhome.service;

import com.quickhome.entity.Order;
import com.quickhome.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("OrderServ")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderMapper order_zch_hwz_gjc;

    @Override
    public int addOrder_zch_hwz_gjc(Order order) {
        return order_zch_hwz_gjc.addOrder_zch_hwz_gjc(order);
    }
}
