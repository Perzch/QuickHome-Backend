package com.quickhome.service;

import com.quickhome.domain.UsersAndCoupons;
import com.baomidou.mybatisplus.extension.service.IService;
import com.quickhome.mapper.UsersAndCouponsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
* @author Tim-h
* @description 针对表【tab_usersandcoupons_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:49:30
*/
@Transactional
public interface UsersAndCouponsService extends IService<UsersAndCoupons> {

    public boolean addUserCoupon(UsersAndCoupons usersAndCoupons);

    public boolean useCoupon(Long couponId);
}
