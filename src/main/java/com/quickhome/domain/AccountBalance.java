package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_accountbalance_zch_hwz_gjc
 */
@TableName(value ="tab_accountbalance_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class AccountBalance implements Serializable {
    /**
     * 金额表编号
     */
    @TableId(value = "bid_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("bid")
    private Long bid_zch_hwz_gjc;

    /**
     * 用户编号
     */
    @TableField(value = "userId_zch_hwz_gjc")
    @JsonProperty("userId")
    private Long userId_zch_hwz_gjc;

    /**
     * 用户账户余额
     */
    @TableField(value = "userBalance_zch_hwz_gjc")
    @JsonProperty("userBalance")
    private Double userBalance_zch_hwz_gjc;

    /**
     * 最后修改时间
     */
    @TableField(value = "lastModifiedDate_zch_hwz_gjc")
    @JsonProperty("lastModifiedDate")
    private Date lastModifiedDate_zch_hwz_gjc;

    /**
     * 开户时间
     */
    @TableField(value = "openTime_zch_hwz_gjc")
    @JsonProperty("openTime")
    private Date openTime_zch_hwz_gjc;

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
        AccountBalance other = (AccountBalance) that;
        return (this.getBid_zch_hwz_gjc() == null ? other.getBid_zch_hwz_gjc() == null : this.getBid_zch_hwz_gjc().equals(other.getBid_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getUserBalance_zch_hwz_gjc() == null ? other.getUserBalance_zch_hwz_gjc() == null : this.getUserBalance_zch_hwz_gjc().equals(other.getUserBalance_zch_hwz_gjc()))
            && (this.getLastModifiedDate_zch_hwz_gjc() == null ? other.getLastModifiedDate_zch_hwz_gjc() == null : this.getLastModifiedDate_zch_hwz_gjc().equals(other.getLastModifiedDate_zch_hwz_gjc()))
            && (this.getOpenTime_zch_hwz_gjc() == null ? other.getOpenTime_zch_hwz_gjc() == null : this.getOpenTime_zch_hwz_gjc().equals(other.getOpenTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getBid_zch_hwz_gjc() == null) ? 0 : getBid_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserBalance_zch_hwz_gjc() == null) ? 0 : getUserBalance_zch_hwz_gjc().hashCode());
        result = prime * result + ((getLastModifiedDate_zch_hwz_gjc() == null) ? 0 : getLastModifiedDate_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOpenTime_zch_hwz_gjc() == null) ? 0 : getOpenTime_zch_hwz_gjc().hashCode());
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
        sb.append(", bid_zch_hwz_gjc=").append(bid_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", userBalance_zch_hwz_gjc=").append(userBalance_zch_hwz_gjc);
        sb.append(", lastModifiedDate_zch_hwz_gjc=").append(lastModifiedDate_zch_hwz_gjc);
        sb.append(", openTime_zch_hwz_gjc=").append(openTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}