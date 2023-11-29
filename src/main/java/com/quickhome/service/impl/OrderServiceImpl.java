package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Order;
import com.quickhome.service.OrderService;
import com.quickhome.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

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

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public void scheduleOrderCancellation(Long orderId, int delayInMinutes) {
        scheduler.schedule(() -> {
            cancelOrderIfNotPaid(orderId);
        }, delayInMinutes, TimeUnit.MINUTES);
    }

    private void cancelOrderIfNotPaid(Long orderId) {
        Order order = orderMapper.selectById(orderId);
        if (order != null && "未支付".equals(order.getOrderState_zch_hwz_gjc())) {
            order.setOrderState_zch_hwz_gjc("已取消");
            order.setEndTime_zch_hwz_gjc(new Date());
            UpdateWrapper<Order> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("orderId_zch_hwz_gjc", orderId);
            orderMapper.update(order, updateWrapper);
            // 这里可以添加其他逻辑，比如发送通知等
        }
    }

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





