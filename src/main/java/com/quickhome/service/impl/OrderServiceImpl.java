package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Order;
import com.quickhome.service.OrderService;
import com.quickhome.mapper.OrderMapper;
import org.springframework.stereotype.Service;

/**
* @author Tim-h
* @description 针对表【tab_order_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:48:18
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Override
    public Boolean updateDynamicDoorPassword(Long OrderId, String dynamicDoorPassword) {
        return null;
    }

    @Override
    public String getDynamicDoorPassword(Long OrderId) {
        return baseMapper.getDynamicDoorPassword(OrderId);
    }
}




