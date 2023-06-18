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
 * @TableName tab_paymentPassword_zch_hwz_gjc
 */
@TableName(value ="tab_paymentPassword_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentPassword implements Serializable {
    /**
     * 
     */
    @TableId(value = "passwordID_zch_hwz_gjc", type = IdType.AUTO)
    private Long passwordID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "accountID_zch_hwz_gjc")
    private Long accountID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "paymentPassword_zch_hwz_gjc")
    private String paymentPassword_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "setTime_zch_hwz_gjc")
    private Date setTime_zch_hwz_gjc;

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
        PaymentPassword other = (PaymentPassword) that;
        return (this.getPasswordID_zch_hwz_gjc() == null ? other.getPasswordID_zch_hwz_gjc() == null : this.getPasswordID_zch_hwz_gjc().equals(other.getPasswordID_zch_hwz_gjc()))
            && (this.getAccountID_zch_hwz_gjc() == null ? other.getAccountID_zch_hwz_gjc() == null : this.getAccountID_zch_hwz_gjc().equals(other.getAccountID_zch_hwz_gjc()))
            && (this.getPaymentPassword_zch_hwz_gjc() == null ? other.getPaymentPassword_zch_hwz_gjc() == null : this.getPaymentPassword_zch_hwz_gjc().equals(other.getPaymentPassword_zch_hwz_gjc()))
            && (this.getSetTime_zch_hwz_gjc() == null ? other.getSetTime_zch_hwz_gjc() == null : this.getSetTime_zch_hwz_gjc().equals(other.getSetTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPasswordID_zch_hwz_gjc() == null) ? 0 : getPasswordID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAccountID_zch_hwz_gjc() == null) ? 0 : getAccountID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getPaymentPassword_zch_hwz_gjc() == null) ? 0 : getPaymentPassword_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSetTime_zch_hwz_gjc() == null) ? 0 : getSetTime_zch_hwz_gjc().hashCode());
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
        sb.append(", passwordID_zch_hwz_gjc=").append(passwordID_zch_hwz_gjc);
        sb.append(", accountID_zch_hwz_gjc=").append(accountID_zch_hwz_gjc);
        sb.append(", paymentPassword_zch_hwz_gjc=").append(paymentPassword_zch_hwz_gjc);
        sb.append(", setTime_zch_hwz_gjc=").append(setTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}