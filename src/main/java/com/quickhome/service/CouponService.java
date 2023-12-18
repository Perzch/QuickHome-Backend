package com.quickhome.service;

import com.quickhome.domain.Coupon;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_coupon_zch_hwz_gjc】的数据库操作Service
* @createDate 2023-06-21 09:46:26
*/
@Transactional
public interface CouponService extends IService<Coupon> {
    public boolean addCoupon(Coupon coupon);

    public boolean deleteCoupon(Long couponId);

    public boolean updateCoupon(Coupon coupon);

    public Coupon getCoupon(Long couponId);

    public List<Coupon> getCouponsByCondition(String discountMethod);


    public boolean releaseCouponsToUsers(Long couponId, List<Long> userIds);
}
