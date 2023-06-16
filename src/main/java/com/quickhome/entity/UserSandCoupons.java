package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserSandCoupons {
    private long UACID_zch_hwz_gjc;
    private String condition_zch_hwz_gjc;
    private long userId_zch_hwz_gjc;
    private long couponId_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public UserSandCoupons(long UACID_zch_hwz_gjc, String condition_zch_hwz_gjc, long userId_zch_hwz_gjc, long couponId_zch_hwz_gjc) {
        this.UACID_zch_hwz_gjc = UACID_zch_hwz_gjc;
        this.condition_zch_hwz_gjc = condition_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.couponId_zch_hwz_gjc = couponId_zch_hwz_gjc;
    }
}
