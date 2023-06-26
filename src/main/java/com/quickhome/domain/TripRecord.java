package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @TableName tab_triprecord_zch_hwz_gjc
 */
@TableName(value ="tab_triprecord_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class TripRecord implements Serializable {
    /**
     * 记录编号
     */
    @TableId(value = "recordID_zch_hwz_gjc", type = IdType.AUTO)
    private Long recordID_zch_hwz_gjc;

    /**
     * 预约编号
     */
    @TableField(value = "reservationID_zch_hwz_gjc")
    private Long reservationID_zch_hwz_gjc;

    /**
     * 起点
     */
    @TableField(value = "startingPoint_zch_hwz_gjc")
    private String startingPoint_zch_hwz_gjc;

    /**
     * 终点
     */
    @TableField(value = "destination_zch_hwz_gjc")
    private String destination_zch_hwz_gjc;

    /**
     * 开始时间
     */
    @TableField(value = "startingTime_zch_hwz_gjc")
    private Date startingTime_zch_hwz_gjc;

    /**
     * 结束时间
     */
    @TableField(value = "endTime_zch_hwz_gjc")
    private Date endTime_zch_hwz_gjc;

    /**
     * 行程距离
     */
    @TableField(value = "distanceTraveled_zch_hwz_gjc")
    private Double distanceTraveled_zch_hwz_gjc;

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
        TripRecord other = (TripRecord) that;
        return (this.getRecordID_zch_hwz_gjc() == null ? other.getRecordID_zch_hwz_gjc() == null : this.getRecordID_zch_hwz_gjc().equals(other.getRecordID_zch_hwz_gjc()))
            && (this.getReservationID_zch_hwz_gjc() == null ? other.getReservationID_zch_hwz_gjc() == null : this.getReservationID_zch_hwz_gjc().equals(other.getReservationID_zch_hwz_gjc()))
            && (this.getStartingPoint_zch_hwz_gjc() == null ? other.getStartingPoint_zch_hwz_gjc() == null : this.getStartingPoint_zch_hwz_gjc().equals(other.getStartingPoint_zch_hwz_gjc()))
            && (this.getDestination_zch_hwz_gjc() == null ? other.getDestination_zch_hwz_gjc() == null : this.getDestination_zch_hwz_gjc().equals(other.getDestination_zch_hwz_gjc()))
            && (this.getStartingTime_zch_hwz_gjc() == null ? other.getStartingTime_zch_hwz_gjc() == null : this.getStartingTime_zch_hwz_gjc().equals(other.getStartingTime_zch_hwz_gjc()))
            && (this.getEndTime_zch_hwz_gjc() == null ? other.getEndTime_zch_hwz_gjc() == null : this.getEndTime_zch_hwz_gjc().equals(other.getEndTime_zch_hwz_gjc()))
            && (this.getDistanceTraveled_zch_hwz_gjc() == null ? other.getDistanceTraveled_zch_hwz_gjc() == null : this.getDistanceTraveled_zch_hwz_gjc().equals(other.getDistanceTraveled_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecordID_zch_hwz_gjc() == null) ? 0 : getRecordID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getReservationID_zch_hwz_gjc() == null) ? 0 : getReservationID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStartingPoint_zch_hwz_gjc() == null) ? 0 : getStartingPoint_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDestination_zch_hwz_gjc() == null) ? 0 : getDestination_zch_hwz_gjc().hashCode());
        result = prime * result + ((getStartingTime_zch_hwz_gjc() == null) ? 0 : getStartingTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getEndTime_zch_hwz_gjc() == null) ? 0 : getEndTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDistanceTraveled_zch_hwz_gjc() == null) ? 0 : getDistanceTraveled_zch_hwz_gjc().hashCode());
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
        sb.append(", recordID_zch_hwz_gjc=").append(recordID_zch_hwz_gjc);
        sb.append(", reservationID_zch_hwz_gjc=").append(reservationID_zch_hwz_gjc);
        sb.append(", startingPoint_zch_hwz_gjc=").append(startingPoint_zch_hwz_gjc);
        sb.append(", destination_zch_hwz_gjc=").append(destination_zch_hwz_gjc);
        sb.append(", startingTime_zch_hwz_gjc=").append(startingTime_zch_hwz_gjc);
        sb.append(", endTime_zch_hwz_gjc=").append(endTime_zch_hwz_gjc);
        sb.append(", distanceTraveled_zch_hwz_gjc=").append(distanceTraveled_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}