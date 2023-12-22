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
 * @TableName tab_log_zch_hwz_gjc
 */
@TableName(value ="tab_log_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class Log implements Serializable {
    /**
     * 日志编号
     */
    @TableId(value = "logId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("logId")
    private Long logId_zch_hwz_gjc;

    /**
     * 用户执行编号
     */
    @TableField(value = "userPerformingId_zch_hwz_gjc")
    @JsonProperty("userPerformingId")
    private Long userPerformingId_zch_hwz_gjc;

    /**
     * 执行时间
     */
    @TableField(value = "executionTime_zch_hwz_gjc")
    @JsonProperty("executionTime")
    private Date executionTime_zch_hwz_gjc;

    /**
     * 执行内容
     */
    @TableField(value = "executionContent_zch_hwz_gjc")
    @JsonProperty("executionContent")
    private String executionContent_zch_hwz_gjc;

    /**
     * 设备编号
     */
    @TableField(value = "device_zch_hwz_gjc")
    @JsonProperty("device")
    private String device_zch_hwz_gjc;

    /**
     * 执行地点
     */
    @TableField(value = "executionPlace_zch_hwz_gjc")
    @JsonProperty("executionPlace")
    private String executionPlace_zch_hwz_gjc;

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
        Log other = (Log) that;
        return (this.getLogId_zch_hwz_gjc() == null ? other.getLogId_zch_hwz_gjc() == null : this.getLogId_zch_hwz_gjc().equals(other.getLogId_zch_hwz_gjc()))
            && (this.getUserPerformingId_zch_hwz_gjc() == null ? other.getUserPerformingId_zch_hwz_gjc() == null : this.getUserPerformingId_zch_hwz_gjc().equals(other.getUserPerformingId_zch_hwz_gjc()))
            && (this.getExecutionTime_zch_hwz_gjc() == null ? other.getExecutionTime_zch_hwz_gjc() == null : this.getExecutionTime_zch_hwz_gjc().equals(other.getExecutionTime_zch_hwz_gjc()))
            && (this.getExecutionContent_zch_hwz_gjc() == null ? other.getExecutionContent_zch_hwz_gjc() == null : this.getExecutionContent_zch_hwz_gjc().equals(other.getExecutionContent_zch_hwz_gjc()))
            && (this.getDevice_zch_hwz_gjc() == null ? other.getDevice_zch_hwz_gjc() == null : this.getDevice_zch_hwz_gjc().equals(other.getDevice_zch_hwz_gjc()))
            && (this.getExecutionPlace_zch_hwz_gjc() == null ? other.getExecutionPlace_zch_hwz_gjc() == null : this.getExecutionPlace_zch_hwz_gjc().equals(other.getExecutionPlace_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogId_zch_hwz_gjc() == null) ? 0 : getLogId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserPerformingId_zch_hwz_gjc() == null) ? 0 : getUserPerformingId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getExecutionTime_zch_hwz_gjc() == null) ? 0 : getExecutionTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getExecutionContent_zch_hwz_gjc() == null) ? 0 : getExecutionContent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDevice_zch_hwz_gjc() == null) ? 0 : getDevice_zch_hwz_gjc().hashCode());
        result = prime * result + ((getExecutionPlace_zch_hwz_gjc() == null) ? 0 : getExecutionPlace_zch_hwz_gjc().hashCode());
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
        sb.append(", logId_zch_hwz_gjc=").append(logId_zch_hwz_gjc);
        sb.append(", userPerformingId_zch_hwz_gjc=").append(userPerformingId_zch_hwz_gjc);
        sb.append(", executionTime_zch_hwz_gjc=").append(executionTime_zch_hwz_gjc);
        sb.append(", executionContent_zch_hwz_gjc=").append(executionContent_zch_hwz_gjc);
        sb.append(", device_zch_hwz_gjc=").append(device_zch_hwz_gjc);
        sb.append(", executionPlace_zch_hwz_gjc=").append(executionPlace_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
