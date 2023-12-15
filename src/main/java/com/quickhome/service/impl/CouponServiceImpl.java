package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.Coupon;
import com.quickhome.domain.User;
import com.quickhome.domain.UsersAndCoupons;
import com.quickhome.mapper.UserMapper;
import com.quickhome.mapper.UsersAndCouponsMapper;
import com.quickhome.service.CouponService;
import com.quickhome.mapper.CouponMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Tim-h
 * @description 针对表【tab_coupon_zch_hwz_gjc】的数据库操作Service实现
 * @createDate 2023-06-21 09:46:26
 */
@Transactional
@Service
public class CouponServiceImpl extends ServiceImpl<CouponMapper, Coupon>
        implements CouponService {

    @Autowired
    private CouponMapper couponMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UsersAndCouponsMapper usersAndCouponsMapper;

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

    @Override
    public boolean releaseCouponsToUsers(Long couponId, List<Long> userIds) {
        try {
            if (userIds == null || userIds.isEmpty()) {
                // 获取所有用户的ID
                QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
                userQueryWrapper.select("userId_zch_hwz_gjc");
                List<User> users = userMapper.selectList(userQueryWrapper);
                userIds = users.stream().map(User::getUserId_zch_hwz_gjc).collect(Collectors.toList());
            }

            for (Long userId : userIds) {
                UsersAndCoupons usersAndCoupons = new UsersAndCoupons();
                usersAndCoupons.setUserId_zch_hwz_gjc(userId);
                usersAndCoupons.setCouponId_zch_hwz_gjc(couponId);
                usersAndCoupons.setCondition_zch_hwz_gjc("未使用");
                usersAndCouponsMapper.insert(usersAndCoupons);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}




