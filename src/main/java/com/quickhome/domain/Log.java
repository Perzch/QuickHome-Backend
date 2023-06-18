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
 * @TableName tab_log_zch_hwz_gjc
 */
@TableName(value ="tab_log_zch_hwz_gjc")
@Data
public class Log implements Serializable {
    /**
     * 
     */
    @TableId(value = "logId_zch_hwz_gjc", type = IdType.AUTO)
    private Long logId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userPerformingId_zch_hwz_gjc")
    private Long userPerformingId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "executionTime_zch_hwz_gjc")
    private Date executionTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "executionContent_zch_hwz_gjc")
    private String executionContent_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "deviceId_zch_hwz_gjc")
    private String deviceId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "executionPlace_zch_hwz_gjc")
    private String executionPlace_zch_hwz_gjc;

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
        Log other = (Log) that;
        return (this.getLogId_zch_hwz_gjc() == null ? other.getLogId_zch_hwz_gjc() == null : this.getLogId_zch_hwz_gjc().equals(other.getLogId_zch_hwz_gjc()))
            && (this.getUserPerformingId_zch_hwz_gjc() == null ? other.getUserPerformingId_zch_hwz_gjc() == null : this.getUserPerformingId_zch_hwz_gjc().equals(other.getUserPerformingId_zch_hwz_gjc()))
            && (this.getExecutionTime_zch_hwz_gjc() == null ? other.getExecutionTime_zch_hwz_gjc() == null : this.getExecutionTime_zch_hwz_gjc().equals(other.getExecutionTime_zch_hwz_gjc()))
            && (this.getExecutionContent_zch_hwz_gjc() == null ? other.getExecutionContent_zch_hwz_gjc() == null : this.getExecutionContent_zch_hwz_gjc().equals(other.getExecutionContent_zch_hwz_gjc()))
            && (this.getDeviceId_zch_hwz_gjc() == null ? other.getDeviceId_zch_hwz_gjc() == null : this.getDeviceId_zch_hwz_gjc().equals(other.getDeviceId_zch_hwz_gjc()))
            && (this.getExecutionPlace_zch_hwz_gjc() == null ? other.getExecutionPlace_zch_hwz_gjc() == null : this.getExecutionPlace_zch_hwz_gjc().equals(other.getExecutionPlace_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId_zch_hwz_gjc() == null) ? 0 : getLogId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserPerformingId_zch_hwz_gjc() == null) ? 0 : getUserPerformingId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getExecutionTime_zch_hwz_gjc() == null) ? 0 : getExecutionTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getExecutionContent_zch_hwz_gjc() == null) ? 0 : getExecutionContent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDeviceId_zch_hwz_gjc() == null) ? 0 : getDeviceId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getExecutionPlace_zch_hwz_gjc() == null) ? 0 : getExecutionPlace_zch_hwz_gjc().hashCode());
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
        sb.append(", logId_zch_hwz_gjc=").append(logId_zch_hwz_gjc);
        sb.append(", userPerformingId_zch_hwz_gjc=").append(userPerformingId_zch_hwz_gjc);
        sb.append(", executionTime_zch_hwz_gjc=").append(executionTime_zch_hwz_gjc);
        sb.append(", executionContent_zch_hwz_gjc=").append(executionContent_zch_hwz_gjc);
        sb.append(", deviceId_zch_hwz_gjc=").append(deviceId_zch_hwz_gjc);
        sb.append(", executionPlace_zch_hwz_gjc=").append(executionPlace_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}