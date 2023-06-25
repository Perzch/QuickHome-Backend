package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_coupon_zch_hwz_gjc
 */
@TableName(value ="tab_coupon_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class Coupon implements Serializable {
    /**
     * 优惠券编号
     */
    @TableId(value = "couponId_zch_hwz_gjc", type = IdType.AUTO)
    private Long couponId_zch_hwz_gjc;

    /**
     * 优惠券名称
     */
    @TableField(value = "couponName_zch_hwz_gjc")
    private String couponName_zch_hwz_gjc;

    /**
     * 优惠方式
     */
    @TableField(value = "discountMethod_zch_hwz_gjc")
    private String discountMethod_zch_hwz_gjc;

    /**
     * 优惠力度
     */
    @TableField(value = "discountIntensity_zch_hwz_gjc")
    private Double discountIntensity_zch_hwz_gjc;

    /**
     * 使用门槛
     */
    @TableField(value = "useThreshold_zch_hwz_gjc")
    private Double useThreshold_zch_hwz_gjc;

    /**
     * 适用范围
     */
    @TableField(value = "applicableScope_zch_hwz_gjc")
    private String applicableScope_zch_hwz_gjc;

    /**
     * 优惠信息
     */
    @TableField(value = "discountInformation_zch_hwz_gjc")
    private String discountInformation_zch_hwz_gjc;

    /**
     * 最早使用时间
     */
    @TableField(value = "earliestUseTime_zch_hwz_gjc")
    private Date earliestUseTime_zch_hwz_gjc;

    /**
     * 最晚使用时间
     */
    @TableField(value = "latestUseTime_zch_hwz_gjc")
    private Date latestUseTime_zch_hwz_gjc;

    /**
     * 备用字段1
     */
    @TableField(value = "standby1_zch_hwz_gjc")
    private String standby1_zch_hwz_gjc;

    /**
     * 备用字段2
     */
    @TableField(value = "standby2_zch_hwz_gjc")
    private String standby2_zch_hwz_gjc;

    /**
     * 备用字段3
     */
    @TableField(value = "standby3_zch_hwz_gjc")
    private String standby3_zch_hwz_gjc;

    /**
     * 逻辑删除（默认0，逻辑删除1）
     */
    @TableField(value = "deleted_zch_hwz_gjc")
    private Integer deleted_zch_hwz_gjc;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Coupon other = (Coupon) that;
        return (this.getCouponId_zch_hwz_gjc() == null ? other.getCouponId_zch_hwz_gjc() == null : this.getCouponId_zch_hwz_gjc().equals(other.getCouponId_zch_hwz_gjc()))
            && (this.getCouponName_zch_hwz_gjc() == null ? other.getCouponName_zch_hwz_gjc() == null : this.getCouponName_zch_hwz_gjc().equals(other.getCouponName_zch_hwz_gjc()))
            && (this.getDiscountMethod_zch_hwz_gjc() == null ? other.getDiscountMethod_zch_hwz_gjc() == null : this.getDiscountMethod_zch_hwz_gjc().equals(other.getDiscountMethod_zch_hwz_gjc()))
            && (this.getDiscountIntensity_zch_hwz_gjc() == null ? other.getDiscountIntensity_zch_hwz_gjc() == null : this.getDiscountIntensity_zch_hwz_gjc().equals(other.getDiscountIntensity_zch_hwz_gjc()))
            && (this.getUseThreshold_zch_hwz_gjc() == null ? other.getUseThreshold_zch_hwz_gjc() == null : this.getUseThreshold_zch_hwz_gjc().equals(other.getUseThreshold_zch_hwz_gjc()))
            && (this.getApplicableScope_zch_hwz_gjc() == null ? other.getApplicableScope_zch_hwz_gjc() == null : this.getApplicableScope_zch_hwz_gjc().equals(other.getApplicableScope_zch_hwz_gjc()))
            && (this.getDiscountInformation_zch_hwz_gjc() == null ? other.getDiscountInformation_zch_hwz_gjc() == null : this.getDiscountInformation_zch_hwz_gjc().equals(other.getDiscountInformation_zch_hwz_gjc()))
            && (this.getEarliestUseTime_zch_hwz_gjc() == null ? other.getEarliestUseTime_zch_hwz_gjc() == null : this.getEarliestUseTime_zch_hwz_gjc().equals(other.getEarliestUseTime_zch_hwz_gjc()))
            && (this.getLatestUseTime_zch_hwz_gjc() == null ? other.getLatestUseTime_zch_hwz_gjc() == null : this.getLatestUseTime_zch_hwz_gjc().equals(other.getLatestUseTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCouponId_zch_hwz_gjc() == null) ? 0 : getCouponId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCouponName_zch_hwz_gjc() == null) ? 0 : getCouponName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDiscountMethod_zch_hwz_gjc() == null) ? 0 : getDiscountMethod_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDiscountIntensity_zch_hwz_gjc() == null) ? 0 : getDiscountIntensity_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUseThreshold_zch_hwz_gjc() == null) ? 0 : getUseThreshold_zch_hwz_gjc().hashCode());
        result = prime * result + ((getApplicableScope_zch_hwz_gjc() == null) ? 0 : getApplicableScope_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDiscountInformation_zch_hwz_gjc() == null) ? 0 : getDiscountInformation_zch_hwz_gjc().hashCode());
        result = prime * result + ((getEarliestUseTime_zch_hwz_gjc() == null) ? 0 : getEarliestUseTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getLatestUseTime_zch_hwz_gjc() == null) ? 0 : getLatestUseTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby1_zch_hwz_gjc() == null) ? 0 : getStandby1_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby2_zch_hwz_gjc() == null) ? 0 : getStandby2_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby3_zch_hwz_gjc() == null) ? 0 : getStandby3_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", couponId_zch_hwz_gjc=").append(couponId_zch_hwz_gjc);
        sb.append(", couponName_zch_hwz_gjc=").append(couponName_zch_hwz_gjc);
        sb.append(", discountMethod_zch_hwz_gjc=").append(discountMethod_zch_hwz_gjc);
        sb.append(", discountIntensity_zch_hwz_gjc=").append(discountIntensity_zch_hwz_gjc);
        sb.append(", useThreshold_zch_hwz_gjc=").append(useThreshold_zch_hwz_gjc);
        sb.append(", applicableScope_zch_hwz_gjc=").append(applicableScope_zch_hwz_gjc);
        sb.append(", discountInformation_zch_hwz_gjc=").append(discountInformation_zch_hwz_gjc);
        sb.append(", earliestUseTime_zch_hwz_gjc=").append(earliestUseTime_zch_hwz_gjc);
        sb.append(", latestUseTime_zch_hwz_gjc=").append(latestUseTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}