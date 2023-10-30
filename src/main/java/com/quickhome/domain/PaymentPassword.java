package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.*;

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
 * @TableName tab_paymentpassword_zch_hwz_gjc
 */
@TableName(value ="tab_paymentpassword_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class PaymentPassword implements Serializable {
    /**
     * 支付密码编号
     */
    @TableId(value = "passwordID_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("passwordID")
    private Long passwordID_zch_hwz_gjc;

    /**
     * 账号编号
     */
    @TableField(value = "userID_zch_hwz_gjc")
    @JsonProperty("userID")
    private Long userID_zch_hwz_gjc;

    /**
     * 支付密码
     */
    @TableField(value = "paymentPassword_zch_hwz_gjc")
    @JsonProperty("paymentPassword")
    private String paymentPassword_zch_hwz_gjc;

    /**
     * 设置时间
     */
    @TableField(value = "setTime_zch_hwz_gjc")
    @JsonProperty("setTime")
    private Date setTime_zch_hwz_gjc;

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
     * 乐观锁
     */
    @JsonProperty("version")
    @Version
    @TableField(value = "version_zch_hwz_gjc")
    private Integer version_zch_hwz_gjc;


    /**
     * 逻辑删除（默认0，逻辑删除1）
     */
    @TableLogic
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
        PaymentPassword other = (PaymentPassword) that;
        return (this.getPasswordID_zch_hwz_gjc() == null ? other.getPasswordID_zch_hwz_gjc() == null : this.getPasswordID_zch_hwz_gjc().equals(other.getPasswordID_zch_hwz_gjc()))
            && (this.getUserID_zch_hwz_gjc() == null ? other.getUserID_zch_hwz_gjc() == null : this.getUserID_zch_hwz_gjc().equals(other.getUserID_zch_hwz_gjc()))
            && (this.getPaymentPassword_zch_hwz_gjc() == null ? other.getPaymentPassword_zch_hwz_gjc() == null : this.getPaymentPassword_zch_hwz_gjc().equals(other.getPaymentPassword_zch_hwz_gjc()))
            && (this.getSetTime_zch_hwz_gjc() == null ? other.getSetTime_zch_hwz_gjc() == null : this.getSetTime_zch_hwz_gjc().equals(other.getSetTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPasswordID_zch_hwz_gjc() == null) ? 0 : getPasswordID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserID_zch_hwz_gjc() == null) ? 0 : getUserID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getPaymentPassword_zch_hwz_gjc() == null) ? 0 : getPaymentPassword_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSetTime_zch_hwz_gjc() == null) ? 0 : getSetTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby1_zch_hwz_gjc() == null) ? 0 : getStandby1_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStandby2_zch_hwz_gjc() == null) ? 0 : getStandby2_zch_hwz_gjc().hashCode());
        result = prime * result + ((getVersion_zch_hwz_gjc() == null) ? 0 : getVersion_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", passwordID_zch_hwz_gjc=").append(passwordID_zch_hwz_gjc);
        sb.append(", userID_zch_hwz_gjc=").append(userID_zch_hwz_gjc);
        sb.append(", paymentPassword_zch_hwz_gjc=").append(paymentPassword_zch_hwz_gjc);
        sb.append(", setTime_zch_hwz_gjc=").append(setTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}