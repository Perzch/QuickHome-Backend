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
 * @TableName tab_carUseStatus_zch_hwz_gjc
 */
@TableName(value ="tab_carUseStatus_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarUseStatus implements Serializable {
    /**
     * 
     */
    @TableId(value = "useStatusID_zch_hwz_gjc", type = IdType.AUTO)
    private Long useStatusID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "carID_zch_hwz_gjc")
    private Long carID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "useDate_zch_hwz_gjc")
    private Date useDate_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "useStatus_zch_hwz_gjc")
    private String useStatus_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "mileage_zch_hwz_gjc")
    private Integer mileage_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "oilVolume_zch_hwz_gjc")
    private Integer oilVolume_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "tireSituation_zch_hwz_gjc")
    private String tireSituation_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "otherMaintenance_zch_hwz_gjc")
    private String otherMaintenance_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "nextInspectionTime_zch_hwz_gjc")
    private Date nextInspectionTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "inspectRemark_zch_hwz_gjc")
    private String inspectRemark_zch_hwz_gjc;

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
        CarUseStatus other = (CarUseStatus) that;
        return (this.getUseStatusID_zch_hwz_gjc() == null ? other.getUseStatusID_zch_hwz_gjc() == null : this.getUseStatusID_zch_hwz_gjc().equals(other.getUseStatusID_zch_hwz_gjc()))
            && (this.getCarID_zch_hwz_gjc() == null ? other.getCarID_zch_hwz_gjc() == null : this.getCarID_zch_hwz_gjc().equals(other.getCarID_zch_hwz_gjc()))
            && (this.getUseDate_zch_hwz_gjc() == null ? other.getUseDate_zch_hwz_gjc() == null : this.getUseDate_zch_hwz_gjc().equals(other.getUseDate_zch_hwz_gjc()))
            && (this.getUseStatus_zch_hwz_gjc() == null ? other.getUseStatus_zch_hwz_gjc() == null : this.getUseStatus_zch_hwz_gjc().equals(other.getUseStatus_zch_hwz_gjc()))
            && (this.getMileage_zch_hwz_gjc() == null ? other.getMileage_zch_hwz_gjc() == null : this.getMileage_zch_hwz_gjc().equals(other.getMileage_zch_hwz_gjc()))
            && (this.getOilVolume_zch_hwz_gjc() == null ? other.getOilVolume_zch_hwz_gjc() == null : this.getOilVolume_zch_hwz_gjc().equals(other.getOilVolume_zch_hwz_gjc()))
            && (this.getTireSituation_zch_hwz_gjc() == null ? other.getTireSituation_zch_hwz_gjc() == null : this.getTireSituation_zch_hwz_gjc().equals(other.getTireSituation_zch_hwz_gjc()))
            && (this.getOtherMaintenance_zch_hwz_gjc() == null ? other.getOtherMaintenance_zch_hwz_gjc() == null : this.getOtherMaintenance_zch_hwz_gjc().equals(other.getOtherMaintenance_zch_hwz_gjc()))
            && (this.getNextInspectionTime_zch_hwz_gjc() == null ? other.getNextInspectionTime_zch_hwz_gjc() == null : this.getNextInspectionTime_zch_hwz_gjc().equals(other.getNextInspectionTime_zch_hwz_gjc()))
            && (this.getInspectRemark_zch_hwz_gjc() == null ? other.getInspectRemark_zch_hwz_gjc() == null : this.getInspectRemark_zch_hwz_gjc().equals(other.getInspectRemark_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
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
        result = prime * result + ((getOilVolume_zch_hwz_gjc() == null) ? 0 : getOilVolume_zch_hwz_gjc().hashCode());
        result = prime * result + ((getTireSituation_zch_hwz_gjc() == null) ? 0 : getTireSituation_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOtherMaintenance_zch_hwz_gjc() == null) ? 0 : getOtherMaintenance_zch_hwz_gjc().hashCode());
        result = prime * result + ((getNextInspectionTime_zch_hwz_gjc() == null) ? 0 : getNextInspectionTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getInspectRemark_zch_hwz_gjc() == null) ? 0 : getInspectRemark_zch_hwz_gjc().hashCode());
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
        sb.append(", useStatusID_zch_hwz_gjc=").append(useStatusID_zch_hwz_gjc);
        sb.append(", carID_zch_hwz_gjc=").append(carID_zch_hwz_gjc);
        sb.append(", useDate_zch_hwz_gjc=").append(useDate_zch_hwz_gjc);
        sb.append(", useStatus_zch_hwz_gjc=").append(useStatus_zch_hwz_gjc);
        sb.append(", mileage_zch_hwz_gjc=").append(mileage_zch_hwz_gjc);
        sb.append(", oilVolume_zch_hwz_gjc=").append(oilVolume_zch_hwz_gjc);
        sb.append(", tireSituation_zch_hwz_gjc=").append(tireSituation_zch_hwz_gjc);
        sb.append(", otherMaintenance_zch_hwz_gjc=").append(otherMaintenance_zch_hwz_gjc);
        sb.append(", nextInspectionTime_zch_hwz_gjc=").append(nextInspectionTime_zch_hwz_gjc);
        sb.append(", inspectRemark_zch_hwz_gjc=").append(inspectRemark_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}