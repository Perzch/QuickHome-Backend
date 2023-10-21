package com.quickhome.pojo;

import com.quickhome.domain.Coupon;
import com.quickhome.domain.UsersAndCoupons;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/10/21 23:44
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PojoCoupon {
    private Coupon coupon;
    private UsersAndCoupons usersAndCoupons;
}
