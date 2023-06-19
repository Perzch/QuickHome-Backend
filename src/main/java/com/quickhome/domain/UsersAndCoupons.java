package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_usersAndCoupons_zch_hwz_gjc
 */
@TableName(value ="tab_usersAndCoupons_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UsersAndCoupons implements Serializable {
    /**
     * 
     */
    @TableId(value = "UACID_zch_hwz_gjc", type = IdType.AUTO)
    private Long UACID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "condition_zch_hwz_gjc")
    private String condition_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "couponId_zch_hwz_gjc")
    private Long couponId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "standby1_zch_hwz_gjc")
    private String standby1_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "standby2_zch_hwz_gjc")
    private String standby2_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "standby3_zch_hwz_gjc")
    private String standby3_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "visible_zch_hwz_gjc")
    private Integer visible_zch_hwz_gjc;

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
        UsersAndCoupons other = (UsersAndCoupons) that;
        return (this.getUACID_zch_hwz_gjc() == null ? other.getUACID_zch_hwz_gjc() == null : this.getUACID_zch_hwz_gjc().equals(other.getUACID_zch_hwz_gjc()))
            && (this.getCondition_zch_hwz_gjc() == null ? other.getCondition_zch_hwz_gjc() == null : this.getCondition_zch_hwz_gjc().equals(other.getCondition_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getCouponId_zch_hwz_gjc() == null ? other.getCouponId_zch_hwz_gjc() == null : this.getCouponId_zch_hwz_gjc().equals(other.getCouponId_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUACID_zch_hwz_gjc() == null) ? 0 : getUACID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCondition_zch_hwz_gjc() == null) ? 0 : getCondition_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCouponId_zch_hwz_gjc() == null) ? 0 : getCouponId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby1_zch_hwz_gjc() == null) ? 0 : getStandby1_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby2_zch_hwz_gjc() == null) ? 0 : getStandby2_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby3_zch_hwz_gjc() == null) ? 0 : getStandby3_zch_hwz_gjc().hashCode());
        result = prime * result + ((getVisible_zch_hwz_gjc() == null) ? 0 : getVisible_zch_hwz_gjc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", UACID_zch_hwz_gjc=").append(UACID_zch_hwz_gjc);
        sb.append(", condition_zch_hwz_gjc=").append(condition_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", couponId_zch_hwz_gjc=").append(couponId_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}