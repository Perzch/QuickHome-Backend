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
 * @TableName tab_deviceStatus_zch_hwz_gjc
 */
@TableName(value ="tab_deviceStatus_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceStatus implements Serializable {
    /**
     * 
     */
    @TableId(value = "statusID_zch_hwz_gjc", type = IdType.AUTO)
    private Long statusID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "deviceID_zch_hwz_gjc")
    private Long deviceID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "deviceStatus_zch_hwz_gjc")
    private String deviceStatus_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "updateTime_zch_hwz_gjc")
    private Date updateTime_zch_hwz_gjc;

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
        DeviceStatus other = (DeviceStatus) that;
        return (this.getStatusID_zch_hwz_gjc() == null ? other.getStatusID_zch_hwz_gjc() == null : this.getStatusID_zch_hwz_gjc().equals(other.getStatusID_zch_hwz_gjc()))
            && (this.getDeviceID_zch_hwz_gjc() == null ? other.getDeviceID_zch_hwz_gjc() == null : this.getDeviceID_zch_hwz_gjc().equals(other.getDeviceID_zch_hwz_gjc()))
            && (this.getDeviceStatus_zch_hwz_gjc() == null ? other.getDeviceStatus_zch_hwz_gjc() == null : this.getDeviceStatus_zch_hwz_gjc().equals(other.getDeviceStatus_zch_hwz_gjc()))
            && (this.getUpdateTime_zch_hwz_gjc() == null ? other.getUpdateTime_zch_hwz_gjc() == null : this.getUpdateTime_zch_hwz_gjc().equals(other.getUpdateTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getStatusID_zch_hwz_gjc() == null) ? 0 : getStatusID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceID_zch_hwz_gjc() == null) ? 0 : getDeviceID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceStatus_zch_hwz_gjc() == null) ? 0 : getDeviceStatus_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUpdateTime_zch_hwz_gjc() == null) ? 0 : getUpdateTime_zch_hwz_gjc().hashCode());
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
        sb.append(", statusID_zch_hwz_gjc=").append(statusID_zch_hwz_gjc);
        sb.append(", deviceID_zch_hwz_gjc=").append(deviceID_zch_hwz_gjc);
        sb.append(", deviceStatus_zch_hwz_gjc=").append(deviceStatus_zch_hwz_gjc);
        sb.append(", updateTime_zch_hwz_gjc=").append(updateTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}