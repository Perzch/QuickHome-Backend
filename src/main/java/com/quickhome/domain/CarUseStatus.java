package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
 * @TableName tab_carusestatus_zch_hwz_gjc
 */
@TableName(value ="tab_carusestatus_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class CarUseStatus implements Serializable {
    /**
     * 使用情况编号
     */
    @TableId(value = "useStatusID_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("useStatusID")
    private Long useStatusID_zch_hwz_gjc;

    /**
     * 汽车编号
     */
    @TableField(value = "carID_zch_hwz_gjc")
    @JsonProperty("carID")
    private Long carID_zch_hwz_gjc;

    /**
     * 使用日期
     */
    @TableField(value = "useDate_zch_hwz_gjc")
    @JsonProperty("useDate")
    private Date useDate_zch_hwz_gjc;

    /**
     * 使用情况
     */
    @TableField(value = "useStatus_zch_hwz_gjc")
    @JsonProperty("useStatus")
    private String useStatus_zch_hwz_gjc;

    /**
     * 里程
     */
    @TableField(value = "mileage_zch_hwz_gjc")
    @JsonProperty("mileage")
    private Integer mileage_zch_hwz_gjc;

    /**
     * 轮胎情况
     */
    @TableField(value = "tireSituation_zch_hwz_gjc")
    @JsonProperty("tireSituation")
    private String tireSituation_zch_hwz_gjc;

    /**
     * 其他维修情况
     */
    @TableField(value = "otherMaintenance_zch_hwz_gjc")
    @JsonProperty("otherMaintenance")
    private String otherMaintenance_zch_hwz_gjc;

    /**
     * 下次维修时间
     */
    @TableField(value = "nextInspectionTime_zch_hwz_gjc")
    @JsonProperty("nextInspectionTime")
    private Date nextInspectionTime_zch_hwz_gjc;

    /**
     * 维修备注
     */
    @TableField(value = "inspectRemark_zch_hwz_gjc")
    @JsonProperty("inspectRemark")
    private String inspectRemark_zch_hwz_gjc;

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
        CarUseStatus other = (CarUseStatus) that;
        return (this.getUseStatusID_zch_hwz_gjc() == null ? other.getUseStatusID_zch_hwz_gjc() == null : this.getUseStatusID_zch_hwz_gjc().equals(other.getUseStatusID_zch_hwz_gjc()))
            && (this.getCarID_zch_hwz_gjc() == null ? other.getCarID_zch_hwz_gjc() == null : this.getCarID_zch_hwz_gjc().equals(other.getCarID_zch_hwz_gjc()))
            && (this.getUseDate_zch_hwz_gjc() == null ? other.getUseDate_zch_hwz_gjc() == null : this.getUseDate_zch_hwz_gjc().equals(other.getUseDate_zch_hwz_gjc()))
            && (this.getUseStatus_zch_hwz_gjc() == null ? other.getUseStatus_zch_hwz_gjc() == null : this.getUseStatus_zch_hwz_gjc().equals(other.getUseStatus_zch_hwz_gjc()))
            && (this.getMileage_zch_hwz_gjc() == null ? other.getMileage_zch_hwz_gjc() == null : this.getMileage_zch_hwz_gjc().equals(other.getMileage_zch_hwz_gjc()))
            && (this.getTireSituation_zch_hwz_gjc() == null ? other.getTireSituation_zch_hwz_gjc() == null : this.getTireSituation_zch_hwz_gjc().equals(other.getTireSituation_zch_hwz_gjc()))
            && (this.getOtherMaintenance_zch_hwz_gjc() == null ? other.getOtherMaintenance_zch_hwz_gjc() == null : this.getOtherMaintenance_zch_hwz_gjc().equals(other.getOtherMaintenance_zch_hwz_gjc()))
            && (this.getNextInspectionTime_zch_hwz_gjc() == null ? other.getNextInspectionTime_zch_hwz_gjc() == null : this.getNextInspectionTime_zch_hwz_gjc().equals(other.getNextInspectionTime_zch_hwz_gjc()))
            && (this.getInspectRemark_zch_hwz_gjc() == null ? other.getInspectRemark_zch_hwz_gjc() == null : this.getInspectRemark_zch_hwz_gjc().equals(other.getInspectRemark_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUseStatusID_zch_hwz_gjc() == null) ? 0 : getUseStatusID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCarID_zch_hwz_gjc() == null) ? 0 : getCarID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUseDate_zch_hwz_gjc() == null) ? 0 : getUseDate_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUseStatus_zch_hwz_gjc() == null) ? 0 : getUseStatus_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMileage_zch_hwz_gjc() == null) ? 0 : getMileage_zch_hwz_gjc().hashCode());
        result = prime * result + ((getTireSituation_zch_hwz_gjc() == null) ? 0 : getTireSituation_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOtherMaintenance_zch_hwz_gjc() == null) ? 0 : getOtherMaintenance_zch_hwz_gjc().hashCode());
        result = prime * result + ((getNextInspectionTime_zch_hwz_gjc() == null) ? 0 : getNextInspectionTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getInspectRemark_zch_hwz_gjc() == null) ? 0 : getInspectRemark_zch_hwz_gjc().hashCode());
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
        sb.append(", useStatusID_zch_hwz_gjc=").append(useStatusID_zch_hwz_gjc);
        sb.append(", carID_zch_hwz_gjc=").append(carID_zch_hwz_gjc);
        sb.append(", useDate_zch_hwz_gjc=").append(useDate_zch_hwz_gjc);
        sb.append(", useStatus_zch_hwz_gjc=").append(useStatus_zch_hwz_gjc);
        sb.append(", mileage_zch_hwz_gjc=").append(mileage_zch_hwz_gjc);
        sb.append(", tireSituation_zch_hwz_gjc=").append(tireSituation_zch_hwz_gjc);
        sb.append(", otherMaintenance_zch_hwz_gjc=").append(otherMaintenance_zch_hwz_gjc);
        sb.append(", nextInspectionTime_zch_hwz_gjc=").append(nextInspectionTime_zch_hwz_gjc);
        sb.append(", inspectRemark_zch_hwz_gjc=").append(inspectRemark_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}