package com.quickhome.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.quickhome.domain.UsersAndCoupons;
import com.quickhome.service.UsersAndCouponsService;
import com.quickhome.mapper.UsersAndCouponsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author Tim-h
* @description 针对表【tab_usersandcoupons_zch_hwz_gjc】的数据库操作Service实现
* @createDate 2023-06-21 09:49:30
*/
@Service
public class UsersAndCouponsServiceImpl extends ServiceImpl<UsersAndCouponsMapper, UsersAndCoupons>
    implements UsersAndCouponsService {
    @Autowired
    private UsersAndCouponsMapper usersAndCouponsMapper;

    public boolean addUserCoupon(UsersAndCoupons usersAndCoupons) {
        return usersAndCouponsMapper.insert(usersAndCoupons) > 0;
    }

    public boolean useCoupon(Long couponId) {
        UpdateWrapper<UsersAndCoupons> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("UACID_zch_hwz_gjc", couponId)
                .set("condition_zch_hwz_gjc", "已使用")
                .set("deleted_zch_hwz_gjc", 1);
        return usersAndCouponsMapper.update(null, updateWrapper) > 0;
    }

}




