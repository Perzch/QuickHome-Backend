package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tab_carInfo_zch_hwz_gjc
 */
@TableName(value ="tab_carInfo_zch_hwz_gjc")
@Data
public class CarInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "carID_zch_hwz_gjc", type = IdType.AUTO)
    private Long carID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "brand_zch_hwz_gjc")
    private String brand_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "model_zch_hwz_gjc")
    private String model_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "licensePlateNumber_zch_hwz_gjc")
    private String licensePlateNumber_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "carColor_zch_hwz_gjc")
    private String carColor_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "entryTime_zch_hwz_gjc")
    private String entryTime_zch_hwz_gjc;

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
        CarInfo other = (CarInfo) that;
        return (this.getCarID_zch_hwz_gjc() == null ? other.getCarID_zch_hwz_gjc() == null : this.getCarID_zch_hwz_gjc().equals(other.getCarID_zch_hwz_gjc()))
            && (this.getBrand_zch_hwz_gjc() == null ? other.getBrand_zch_hwz_gjc() == null : this.getBrand_zch_hwz_gjc().equals(other.getBrand_zch_hwz_gjc()))
            && (this.getModel_zch_hwz_gjc() == null ? other.getModel_zch_hwz_gjc() == null : this.getModel_zch_hwz_gjc().equals(other.getModel_zch_hwz_gjc()))
            && (this.getLicensePlateNumber_zch_hwz_gjc() == null ? other.getLicensePlateNumber_zch_hwz_gjc() == null : this.getLicensePlateNumber_zch_hwz_gjc().equals(other.getLicensePlateNumber_zch_hwz_gjc()))
            && (this.getCarColor_zch_hwz_gjc() == null ? other.getCarColor_zch_hwz_gjc() == null : this.getCarColor_zch_hwz_gjc().equals(other.getCarColor_zch_hwz_gjc()))
            && (this.getEntryTime_zch_hwz_gjc() == null ? other.getEntryTime_zch_hwz_gjc() == null : this.getEntryTime_zch_hwz_gjc().equals(other.getEntryTime_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCarID_zch_hwz_gjc() == null) ? 0 : getCarID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getBrand_zch_hwz_gjc() == null) ? 0 : getBrand_zch_hwz_gjc().hashCode());
        result = prime * result + ((getModel_zch_hwz_gjc() == null) ? 0 : getModel_zch_hwz_gjc().hashCode());
        result = prime * result + ((getLicensePlateNumber_zch_hwz_gjc() == null) ? 0 : getLicensePlateNumber_zch_hwz_gjc().hashCode());
        result = prime * result + ((getCarColor_zch_hwz_gjc() == null) ? 0 : getCarColor_zch_hwz_gjc().hashCode());
        result = prime * result + ((getEntryTime_zch_hwz_gjc() == null) ? 0 : getEntryTime_zch_hwz_gjc().hashCode());
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
        sb.append(", carID_zch_hwz_gjc=").append(carID_zch_hwz_gjc);
        sb.append(", brand_zch_hwz_gjc=").append(brand_zch_hwz_gjc);
        sb.append(", model_zch_hwz_gjc=").append(model_zch_hwz_gjc);
        sb.append(", licensePlateNumber_zch_hwz_gjc=").append(licensePlateNumber_zch_hwz_gjc);
        sb.append(", carColor_zch_hwz_gjc=").append(carColor_zch_hwz_gjc);
        sb.append(", entryTime_zch_hwz_gjc=").append(entryTime_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}