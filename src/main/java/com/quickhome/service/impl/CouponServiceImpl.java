package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Coupon;
import com.quickhome.service.CouponService;
import com.quickhome.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Tim-h
* @description 针对表【tab_coupon_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:46:26
*/
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon>
    implements CouponService{

    @Autowired
    private CouponMapper couponMapper;

    public boolean addCoupon(Coupon coupon) {
        return couponMapper.insert(coupon) > 0;
    }

    public boolean deleteCoupon(Long couponId) {
        return couponMapper.deleteById(couponId) > 0;
    }

    public boolean updateCoupon(Coupon coupon) {
        return couponMapper.updateById(coupon) > 0;
    }

    public Coupon getCoupon(Long couponId) {
        return couponMapper.selectById(couponId);
    }

    public List<Coupon> getCouponsByCondition(String discountMethod) {
        QueryWrapper<Coupon> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("discountMethod_zch_hwz_gjc", discountMethod);
        return couponMapper.selectList(queryWrapper);
    }

}




