package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tab_order_zch_hwz_gjc
 */
@TableName(value ="tab_order_zch_hwz_gjc")
@Data
public class Order implements Serializable {
    /**
     * 
     */
    @TableId(value = "orderId_zch_hwz_gjc", type = IdType.AUTO)
    private Long orderId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    private Long homeId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "DynamicDoorPassword_zch_hwz_gjc")
    private String dynamicDoorPassword_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "creationTime_zch_hwz_gjc")
    private Date creationTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "endTime_zch_hwz_gjc")
    private Date endTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "checkInTime_zch_hwz_gjc")
    private Date checkInTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "checkOutTime_zch_hwz_gjc")
    private Date checkOutTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "orderPayment_zch_hwz_gjc")
    private Double orderPayment_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "orderDeposit_zch_hwz_gjc")
    private Double orderDeposit_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "maintainStatus_zch_hwz_gjc")
    private String maintainStatus_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "orderState_zch_hwz_gjc")
    private String orderState_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

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
        Order other = (Order) that;
        return (this.getOrderId_zch_hwz_gjc() == null ? other.getOrderId_zch_hwz_gjc() == null : this.getOrderId_zch_hwz_gjc().equals(other.getOrderId_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getDynamicDoorPassword_zch_hwz_gjc() == null ? other.getDynamicDoorPassword_zch_hwz_gjc() == null : this.getDynamicDoorPassword_zch_hwz_gjc().equals(other.getDynamicDoorPassword_zch_hwz_gjc()))
            && (this.getCreationTime_zch_hwz_gjc() == null ? other.getCreationTime_zch_hwz_gjc() == null : this.getCreationTime_zch_hwz_gjc().equals(other.getCreationTime_zch_hwz_gjc()))
            && (this.getEndTime_zch_hwz_gjc() == null ? other.getEndTime_zch_hwz_gjc() == null : this.getEndTime_zch_hwz_gjc().equals(other.getEndTime_zch_hwz_gjc()))
            && (this.getCheckInTime_zch_hwz_gjc() == null ? other.getCheckInTime_zch_hwz_gjc() == null : this.getCheckInTime_zch_hwz_gjc().equals(other.getCheckInTime_zch_hwz_gjc()))
            && (this.getCheckOutTime_zch_hwz_gjc() == null ? other.getCheckOutTime_zch_hwz_gjc() == null : this.getCheckOutTime_zch_hwz_gjc().equals(other.getCheckOutTime_zch_hwz_gjc()))
            && (this.getOrderPayment_zch_hwz_gjc() == null ? other.getOrderPayment_zch_hwz_gjc() == null : this.getOrderPayment_zch_hwz_gjc().equals(other.getOrderPayment_zch_hwz_gjc()))
            && (this.getOrderDeposit_zch_hwz_gjc() == null ? other.getOrderDeposit_zch_hwz_gjc() == null : this.getOrderDeposit_zch_hwz_gjc().equals(other.getOrderDeposit_zch_hwz_gjc()))
            && (this.getMaintainStatus_zch_hwz_gjc() == null ? other.getMaintainStatus_zch_hwz_gjc() == null : this.getMaintainStatus_zch_hwz_gjc().equals(other.getMaintainStatus_zch_hwz_gjc()))
            && (this.getOrderState_zch_hwz_gjc() == null ? other.getOrderState_zch_hwz_gjc() == null : this.getOrderState_zch_hwz_gjc().equals(other.getOrderState_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderId_zch_hwz_gjc() == null) ? 0 : getOrderId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDynamicDoorPassword_zch_hwz_gjc() == null) ? 0 : getDynamicDoorPassword_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCreationTime_zch_hwz_gjc() == null) ? 0 : getCreationTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getEndTime_zch_hwz_gjc() == null) ? 0 : getEndTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCheckInTime_zch_hwz_gjc() == null) ? 0 : getCheckInTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCheckOutTime_zch_hwz_gjc() == null) ? 0 : getCheckOutTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderPayment_zch_hwz_gjc() == null) ? 0 : getOrderPayment_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderDeposit_zch_hwz_gjc() == null) ? 0 : getOrderDeposit_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMaintainStatus_zch_hwz_gjc() == null) ? 0 : getMaintainStatus_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderState_zch_hwz_gjc() == null) ? 0 : getOrderState_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
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
        sb.append(", orderId_zch_hwz_gjc=").append(orderId_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", dynamicDoorPassword_zch_hwz_gjc=").append(dynamicDoorPassword_zch_hwz_gjc);
        sb.append(", creationTime_zch_hwz_gjc=").append(creationTime_zch_hwz_gjc);
        sb.append(", endTime_zch_hwz_gjc=").append(endTime_zch_hwz_gjc);
        sb.append(", checkInTime_zch_hwz_gjc=").append(checkInTime_zch_hwz_gjc);
        sb.append(", checkOutTime_zch_hwz_gjc=").append(checkOutTime_zch_hwz_gjc);
        sb.append(", orderPayment_zch_hwz_gjc=").append(orderPayment_zch_hwz_gjc);
        sb.append(", orderDeposit_zch_hwz_gjc=").append(orderDeposit_zch_hwz_gjc);
        sb.append(", maintainStatus_zch_hwz_gjc=").append(maintainStatus_zch_hwz_gjc);
        sb.append(", orderState_zch_hwz_gjc=").append(orderState_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}