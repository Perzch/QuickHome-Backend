package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CouponId {
    private long couponId_zch_hwz_gjc;
    private String couponName_zch_hwz_gjc;
    private String discountMethod_zch_hwz_gjc;
    private double discountIntensity_zch_hwz_gjc;
    private double useThreshold_zch_hwz_gjc;
    private String applicableScope_zch_hwz_gjc;
    private String discountInformation_zch_hwz_gjc;
    private Date earliestUseTime_zch_hwz_gjc;
    private Date latestUseTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public CouponId(long couponId_zch_hwz_gjc, String couponName_zch_hwz_gjc, String discountMethod_zch_hwz_gjc, double discountIntensity_zch_hwz_gjc, double useThreshold_zch_hwz_gjc, String applicableScope_zch_hwz_gjc, String discountInformation_zch_hwz_gjc, Date earliestUseTime_zch_hwz_gjc, Date latestUseTime_zch_hwz_gjc) {
        this.couponId_zch_hwz_gjc = couponId_zch_hwz_gjc;
        this.couponName_zch_hwz_gjc = couponName_zch_hwz_gjc;
        this.discountMethod_zch_hwz_gjc = discountMethod_zch_hwz_gjc;
        this.discountIntensity_zch_hwz_gjc = discountIntensity_zch_hwz_gjc;
        this.useThreshold_zch_hwz_gjc = useThreshold_zch_hwz_gjc;
        this.applicableScope_zch_hwz_gjc = applicableScope_zch_hwz_gjc;
        this.discountInformation_zch_hwz_gjc = discountInformation_zch_hwz_gjc;
        this.earliestUseTime_zch_hwz_gjc = earliestUseTime_zch_hwz_gjc;
        this.latestUseTime_zch_hwz_gjc = latestUseTime_zch_hwz_gjc;
    }
}
