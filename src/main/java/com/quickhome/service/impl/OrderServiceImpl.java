package com.quickhome.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Order;
import com.quickhome.mapper.OrderMapper;
import com.quickhome.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Perzch
* @description 针对表【tab_order_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-17 19:42:29
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService {
}




