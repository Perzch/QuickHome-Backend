package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_carorder_zch_hwz_gjc
 */
@TableName(value ="tab_carorder_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class CarOrder implements Serializable {
    /**
     * 订单编号
     */
    @TableId(value = "orderID_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("orderID")
    private Long orderID_zch_hwz_gjc;

    /**
     * 用户编号
     */
    @TableField(value = "userID_zch_hwz_gjc")
    @JsonProperty("userID")
    private Long userID_zch_hwz_gjc;

    /**
     * 汽车编号
     */
    @TableField(value = "carID_zch_hwz_gjc")
    @JsonProperty("carID")
    private Long carID_zch_hwz_gjc;

    /**
     * 司机编号
     */
    @TableField(value = "driverID_zch_hwz_gjc")
    @JsonProperty("driverID")
    private Long driverID_zch_hwz_gjc;

    /**
     * 下单时间
     */
    @TableField(value = "orderTime_zch_hwz_gjc")
    @JsonProperty("orderTime")
    private Date orderTime_zch_hwz_gjc;

    /**
     * 订单状态
     */
    @TableField(value = "orderStatus_zch_hwz_gjc")
    @JsonProperty("orderStatus")
    private String orderStatus_zch_hwz_gjc;

    /**
     * 订单金额
     */
    @TableField(value = "orderAmount_zch_hwz_gjc")
    @JsonProperty("orderAmount")
    private BigDecimal orderAmount_zch_hwz_gjc;

    /**
     * 行程记录编号
     */
    @TableField(value = "tripRecordID_zch_hwz_gjc")
    @JsonProperty("tripRecordID")
    private Long tripRecordID_zch_hwz_gjc;

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
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
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
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
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
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}