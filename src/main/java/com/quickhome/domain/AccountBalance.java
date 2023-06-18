package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_accountBalance_zch_hwz_gjc
 */
@TableName(value ="tab_accountBalance_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalance implements Serializable {
    /**
     * 
     */
    @TableId(value = "bid_zch_hwz_gjc", type = IdType.AUTO)
    private Long bid_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userBalance_zch_hwz_gjc")
    private Double userBalance_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userDeposit_zch_hwz_gjc")
    private Double userDeposit_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "lastModifiedDate_zch_hwz_gjc")
    private Date lastModifiedDate_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "openTime_zch_hwz_gjc")
    private Date openTime_zch_hwz_gjc;

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
        AccountBalance other = (AccountBalance) that;
        return (this.getBid_zch_hwz_gjc() == null ? other.getBid_zch_hwz_gjc() == null : this.getBid_zch_hwz_gjc().equals(other.getBid_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getUserBalance_zch_hwz_gjc() == null ? other.getUserBalance_zch_hwz_gjc() == null : this.getUserBalance_zch_hwz_gjc().equals(other.getUserBalance_zch_hwz_gjc()))
            && (this.getUserDeposit_zch_hwz_gjc() == null ? other.getUserDeposit_zch_hwz_gjc() == null : this.getUserDeposit_zch_hwz_gjc().equals(other.getUserDeposit_zch_hwz_gjc()))
            && (this.getLastModifiedDate_zch_hwz_gjc() == null ? other.getLastModifiedDate_zch_hwz_gjc() == null : this.getLastModifiedDate_zch_hwz_gjc().equals(other.getLastModifiedDate_zch_hwz_gjc()))
            && (this.getOpenTime_zch_hwz_gjc() == null ? other.getOpenTime_zch_hwz_gjc() == null : this.getOpenTime_zch_hwz_gjc().equals(other.getOpenTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBid_zch_hwz_gjc() == null) ? 0 : getBid_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserBalance_zch_hwz_gjc() == null) ? 0 : getUserBalance_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserDeposit_zch_hwz_gjc() == null) ? 0 : getUserDeposit_zch_hwz_gjc().hashCode());
        result = prime * result + ((getLastModifiedDate_zch_hwz_gjc() == null) ? 0 : getLastModifiedDate_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOpenTime_zch_hwz_gjc() == null) ? 0 : getOpenTime_zch_hwz_gjc().hashCode());
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
        sb.append(", bid_zch_hwz_gjc=").append(bid_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", userBalance_zch_hwz_gjc=").append(userBalance_zch_hwz_gjc);
        sb.append(", userDeposit_zch_hwz_gjc=").append(userDeposit_zch_hwz_gjc);
        sb.append(", lastModifiedDate_zch_hwz_gjc=").append(lastModifiedDate_zch_hwz_gjc);
        sb.append(", openTime_zch_hwz_gjc=").append(openTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}