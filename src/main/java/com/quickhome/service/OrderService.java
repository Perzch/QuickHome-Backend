package com.quickhome.service;

import com.quickhome.domain.Order;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_order_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:48:18
*/
@Transactional
public interface OrderService extends IService<Order> {
    public String getDynamicDoorPassword(Long OrderId);
    public Boolean updateDynamicDoorPassword(Long OrderId, String dynamicDoorPassword);

    public List<Order> getAllUserOrders(Long userId);


}
