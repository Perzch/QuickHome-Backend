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
 * @TableName tab_deviceControlRecord_zch_hwz_gjc
 */
@TableName(value ="tab_deviceControlRecord_zch_hwz_gjc")
@Data
public class DeviceControlRecord implements Serializable {
    /**
     * 
     */
    @TableId(value = "recordID_zch_hwz_gjc", type = IdType.AUTO)
    private Long recordID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userID_zch_hwz_gjc")
    private Long userID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "deviceID_zch_hwz_gjc")
    private Long deviceID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "controlTime_zch_hwz_gjc")
    private Date controlTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "controlType_zch_hwz_gjc")
    private String controlType_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "controlContent_zch_hwz_gjc")
    private String controlContent_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "deviceReservationTime_zch_hwz_gjc")
    private Date deviceReservationTime_zch_hwz_gjc;

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
        DeviceControlRecord other = (DeviceControlRecord) that;
        return (this.getRecordID_zch_hwz_gjc() == null ? other.getRecordID_zch_hwz_gjc() == null : this.getRecordID_zch_hwz_gjc().equals(other.getRecordID_zch_hwz_gjc()))
            && (this.getUserID_zch_hwz_gjc() == null ? other.getUserID_zch_hwz_gjc() == null : this.getUserID_zch_hwz_gjc().equals(other.getUserID_zch_hwz_gjc()))
            && (this.getDeviceID_zch_hwz_gjc() == null ? other.getDeviceID_zch_hwz_gjc() == null : this.getDeviceID_zch_hwz_gjc().equals(other.getDeviceID_zch_hwz_gjc()))
            && (this.getControlTime_zch_hwz_gjc() == null ? other.getControlTime_zch_hwz_gjc() == null : this.getControlTime_zch_hwz_gjc().equals(other.getControlTime_zch_hwz_gjc()))
            && (this.getControlType_zch_hwz_gjc() == null ? other.getControlType_zch_hwz_gjc() == null : this.getControlType_zch_hwz_gjc().equals(other.getControlType_zch_hwz_gjc()))
            && (this.getControlContent_zch_hwz_gjc() == null ? other.getControlContent_zch_hwz_gjc() == null : this.getControlContent_zch_hwz_gjc().equals(other.getControlContent_zch_hwz_gjc()))
            && (this.getDeviceReservationTime_zch_hwz_gjc() == null ? other.getDeviceReservationTime_zch_hwz_gjc() == null : this.getDeviceReservationTime_zch_hwz_gjc().equals(other.getDeviceReservationTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordID_zch_hwz_gjc() == null) ? 0 : getRecordID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserID_zch_hwz_gjc() == null) ? 0 : getUserID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceID_zch_hwz_gjc() == null) ? 0 : getDeviceID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getControlTime_zch_hwz_gjc() == null) ? 0 : getControlTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getControlType_zch_hwz_gjc() == null) ? 0 : getControlType_zch_hwz_gjc().hashCode());
        result = prime * result + ((getControlContent_zch_hwz_gjc() == null) ? 0 : getControlContent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceReservationTime_zch_hwz_gjc() == null) ? 0 : getDeviceReservationTime_zch_hwz_gjc().hashCode());
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
        sb.append(", recordID_zch_hwz_gjc=").append(recordID_zch_hwz_gjc);
        sb.append(", userID_zch_hwz_gjc=").append(userID_zch_hwz_gjc);
        sb.append(", deviceID_zch_hwz_gjc=").append(deviceID_zch_hwz_gjc);
        sb.append(", controlTime_zch_hwz_gjc=").append(controlTime_zch_hwz_gjc);
        sb.append(", controlType_zch_hwz_gjc=").append(controlType_zch_hwz_gjc);
        sb.append(", controlContent_zch_hwz_gjc=").append(controlContent_zch_hwz_gjc);
        sb.append(", deviceReservationTime_zch_hwz_gjc=").append(deviceReservationTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}