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
    public OrderEndResult processOrderEnd(Long orderId) throws Exception {
        // Retrieve the order by orderId
        Order order = orderMapper.selectById(orderId);
        if (order == null) {
            throw new Exception("Order not found");
        }

        // Check if the order has already been processed
        if ("已结束".equals(order.getOrderState_zch_hwz_gjc())) {
            throw new Exception("Order has already been ended");
        }

        // Check the time difference and password retrieval
        Date creationTime = order.getCreationTime_zch_hwz_gjc();
        Date now = new Date();
        long minutesDiff = getMinutesDifference(creationTime, now);
        boolean isPasswordRetrieved = order.getDynamicDoorPassword_zch_hwz_gjc() != null;

        // Determine if it's a full refund or full charge
        boolean fullRefund = minutesDiff <= 30 && !isPasswordRetrieved;

        // Update the order and user balance accordingly
        if (fullRefund) {
            // Refund the user
            updateUserBalance(order.getUserId_zch_hwz_gjc(), order.getOrderDeposit_zch_hwz_gjc());
            // Update the order status to '已结束'
            order.setOrderState_zch_hwz_gjc("已结束");
            order.setEndTime_zch_hwz_gjc(now); // Now is already a Date object
            order.setOrderDeposit_zch_hwz_gjc(0.0); // Set deposit to zero
            orderMapper.updateById(order);
        } else {
            // Full charge, just update the order status to '已结束'
            order.setOrderState_zch_hwz_gjc("已结束");
            order.setEndTime_zch_hwz_gjc(now); // Now is already a Date object
            orderMapper.updateById(order);
            // Additional steps may be required here for the full charge case
        }

        // Create the result object
        OrderEndResult result = new OrderEndResult();
        // Populate result with necessary information
        // ...

        return result;
    }

    private long getMinutesDifference(Date start, Date end) {
        long diffInMillies = Math.abs(end.getTime() - start.getTime());
        return diffInMillies / (60 * 1000);
    }

    private void updateUserBalance(Long userId, Double refundAmount) throws Exception {
        // Retrieve the user's account balance
        AccountBalance accountBalance = accountBalanceMapper.selectById(userId);
        if (accountBalance == null) {
            throw new Exception("User account balance not found");
        }

        // Update the user's balance
        accountBalance.setUserBalance_zch_hwz_gjc(accountBalance.getUserBalance_zch_hwz_gjc() + refundAmount);
        accountBalance.setLastModifiedDate_zch_hwz_gjc(convertToDate(LocalDateTime.now()));
        accountBalanceMapper.updateById(accountBalance);
    }

    private Date convertToDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }



    //----------------------------------------------------

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





