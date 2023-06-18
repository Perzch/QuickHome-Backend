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
 * @TableName tab_carReservation_zch_hwz_gjc
 */
@TableName(value ="tab_carReservation_zch_hwz_gjc")
@Data
public class CarReservation implements Serializable {
    /**
     * 
     */
    @TableId(value = "reservationID_zch_hwz_gjc", type = IdType.AUTO)
    private Long reservationID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "driverID_zch_hwz_gjc")
    private Long driverID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "carID_zch_hwz_gjc")
    private Long carID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "carReservationTime_zch_hwz_gjc")
    private Date carReservationTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "reservationStatus_zch_hwz_gjc")
    private String reservationStatus_zch_hwz_gjc;

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
        CarReservation other = (CarReservation) that;
        return (this.getReservationID_zch_hwz_gjc() == null ? other.getReservationID_zch_hwz_gjc() == null : this.getReservationID_zch_hwz_gjc().equals(other.getReservationID_zch_hwz_gjc()))
            && (this.getDriverID_zch_hwz_gjc() == null ? other.getDriverID_zch_hwz_gjc() == null : this.getDriverID_zch_hwz_gjc().equals(other.getDriverID_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getCarID_zch_hwz_gjc() == null ? other.getCarID_zch_hwz_gjc() == null : this.getCarID_zch_hwz_gjc().equals(other.getCarID_zch_hwz_gjc()))
            && (this.getCarReservationTime_zch_hwz_gjc() == null ? other.getCarReservationTime_zch_hwz_gjc() == null : this.getCarReservationTime_zch_hwz_gjc().equals(other.getCarReservationTime_zch_hwz_gjc()))
            && (this.getReservationStatus_zch_hwz_gjc() == null ? other.getReservationStatus_zch_hwz_gjc() == null : this.getReservationStatus_zch_hwz_gjc().equals(other.getReservationStatus_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReservationID_zch_hwz_gjc() == null) ? 0 : getReservationID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDriverID_zch_hwz_gjc() == null) ? 0 : getDriverID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCarID_zch_hwz_gjc() == null) ? 0 : getCarID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCarReservationTime_zch_hwz_gjc() == null) ? 0 : getCarReservationTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getReservationStatus_zch_hwz_gjc() == null) ? 0 : getReservationStatus_zch_hwz_gjc().hashCode());
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
        sb.append(", reservationID_zch_hwz_gjc=").append(reservationID_zch_hwz_gjc);
        sb.append(", driverID_zch_hwz_gjc=").append(driverID_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", carID_zch_hwz_gjc=").append(carID_zch_hwz_gjc);
        sb.append(", carReservationTime_zch_hwz_gjc=").append(carReservationTime_zch_hwz_gjc);
        sb.append(", reservationStatus_zch_hwz_gjc=").append(reservationStatus_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}