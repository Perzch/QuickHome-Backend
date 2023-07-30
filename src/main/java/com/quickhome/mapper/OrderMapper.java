package com.quickhome.mapper;

import com.quickhome.domain.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author Tim-h
* @description 针对表【tab_order_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-21 09:48:18
* @Entity .domain.Order
*/
public interface OrderMapper extends BaseMapper<Order> {
    public String getDynamicDoorPassword(Long OrderId);
    public Boolean updateDynamicDoorPassword(Long OrderId, String dynamicDoorPassword);

}




