package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.AccountBalance;
import com.quickhome.domain.Order;
import com.quickhome.mapper.AccountBalanceMapper;
import com.quickhome.pojo.OrderEndResult;
import com.quickhome.service.OrderService;
import com.quickhome.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

/**
 * @author Tim-h
 * @description 针对表【tab_order_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-21 09:48:18
 */
@Transactional
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
        implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private AccountBalanceMapper accountBalanceMapper;

    @Override
    public Boolean updateDynamicDoorPassword(Long OrderId, String dynamicDoorPassword) {
        return null;
    }

    @Override
    public String getDynamicDoorPassword(Long OrderId) {
        return baseMapper.getDynamicDoorPassword(OrderId);
    }


    @Override
    public List<Order> getAllUserOrders(Long userId) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userId_zch_hwz_gjc", userId); // 根据用户ID查询订单信息
        return orderMapper.selectList(queryWrapper);
    }
}





