package com.quickhome.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.quickhome.domain.Order;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Perzch
* @description 针对表【tab_order_zch_hwz_gjc】的数据库操作Mapper
* @createDate 2023-06-17 19:42:29
* @Entity .domain.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}




