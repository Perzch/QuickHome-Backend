package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tab_carOrder_zch_hwz_gjc
 */
@TableName(value ="tab_carOrder_zch_hwz_gjc")
@Data
public class CarOrder implements Serializable {
    /**
     * 
     */
    @TableId(value = "orderID_zch_hwz_gjc", type = IdType.AUTO)
    private Long orderID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userID_zch_hwz_gjc")
    private Long userID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "carID_zch_hwz_gjc")
    private Long carID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "driverID_zch_hwz_gjc")
    private Long driverID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "orderTime_zch_hwz_gjc")
    private Date orderTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "orderStatus_zch_hwz_gjc")
    private String orderStatus_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "orderAmount_zch_hwz_gjc")
    private BigDecimal orderAmount_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "tripRecordID_zch_hwz_gjc")
    private Long tripRecordID_zch_hwz_gjc;

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
        CarOrder other = (CarOrder) that;
        return (this.getOrderID_zch_hwz_gjc() == null ? other.getOrderID_zch_hwz_gjc() == null : this.getOrderID_zch_hwz_gjc().equals(other.getOrderID_zch_hwz_gjc()))
            && (this.getUserID_zch_hwz_gjc() == null ? other.getUserID_zch_hwz_gjc() == null : this.getUserID_zch_hwz_gjc().equals(other.getUserID_zch_hwz_gjc()))
            && (this.getCarID_zch_hwz_gjc() == null ? other.getCarID_zch_hwz_gjc() == null : this.getCarID_zch_hwz_gjc().equals(other.getCarID_zch_hwz_gjc()))
            && (this.getDriverID_zch_hwz_gjc() == null ? other.getDriverID_zch_hwz_gjc() == null : this.getDriverID_zch_hwz_gjc().equals(other.getDriverID_zch_hwz_gjc()))
            && (this.getOrderTime_zch_hwz_gjc() == null ? other.getOrderTime_zch_hwz_gjc() == null : this.getOrderTime_zch_hwz_gjc().equals(other.getOrderTime_zch_hwz_gjc()))
            && (this.getOrderStatus_zch_hwz_gjc() == null ? other.getOrderStatus_zch_hwz_gjc() == null : this.getOrderStatus_zch_hwz_gjc().equals(other.getOrderStatus_zch_hwz_gjc()))
            && (this.getOrderAmount_zch_hwz_gjc() == null ? other.getOrderAmount_zch_hwz_gjc() == null : this.getOrderAmount_zch_hwz_gjc().equals(other.getOrderAmount_zch_hwz_gjc()))
            && (this.getTripRecordID_zch_hwz_gjc() == null ? other.getTripRecordID_zch_hwz_gjc() == null : this.getTripRecordID_zch_hwz_gjc().equals(other.getTripRecordID_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOrderID_zch_hwz_gjc() == null) ? 0 : getOrderID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserID_zch_hwz_gjc() == null) ? 0 : getUserID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCarID_zch_hwz_gjc() == null) ? 0 : getCarID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDriverID_zch_hwz_gjc() == null) ? 0 : getDriverID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderTime_zch_hwz_gjc() == null) ? 0 : getOrderTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderStatus_zch_hwz_gjc() == null) ? 0 : getOrderStatus_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOrderAmount_zch_hwz_gjc() == null) ? 0 : getOrderAmount_zch_hwz_gjc().hashCode());
        result = prime * result + ((getTripRecordID_zch_hwz_gjc() == null) ? 0 : getTripRecordID_zch_hwz_gjc().hashCode());
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
        sb.append(", orderID_zch_hwz_gjc=").append(orderID_zch_hwz_gjc);
        sb.append(", userID_zch_hwz_gjc=").append(userID_zch_hwz_gjc);
        sb.append(", carID_zch_hwz_gjc=").append(carID_zch_hwz_gjc);
        sb.append(", driverID_zch_hwz_gjc=").append(driverID_zch_hwz_gjc);
        sb.append(", orderTime_zch_hwz_gjc=").append(orderTime_zch_hwz_gjc);
        sb.append(", orderStatus_zch_hwz_gjc=").append(orderStatus_zch_hwz_gjc);
        sb.append(", orderAmount_zch_hwz_gjc=").append(orderAmount_zch_hwz_gjc);
        sb.append(", tripRecordID_zch_hwz_gjc=").append(tripRecordID_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}