package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName tab_driverInfo_zch_hwz_gjc
 */
@TableName(value ="tab_driverInfo_zch_hwz_gjc")
@Data
public class DriverInfo implements Serializable {
    /**
     * 
     */
    @TableId(value = "driverID_zch_hwz_gjc", type = IdType.AUTO)
    private Long driverID_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "driverName_zch_hwz_gjc")
    private String driverName_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "contactPhoneNumber_zch_hwz_gjc")
    private String contactPhoneNumber_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "idNumber_zch_hwz_gjc")
    private String idNumber_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "licenseNumber_zch_hwz_gjc")
    private String licenseNumber_zch_hwz_gjc;

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
        DriverInfo other = (DriverInfo) that;
        return (this.getDriverID_zch_hwz_gjc() == null ? other.getDriverID_zch_hwz_gjc() == null : this.getDriverID_zch_hwz_gjc().equals(other.getDriverID_zch_hwz_gjc()))
            && (this.getDriverName_zch_hwz_gjc() == null ? other.getDriverName_zch_hwz_gjc() == null : this.getDriverName_zch_hwz_gjc().equals(other.getDriverName_zch_hwz_gjc()))
            && (this.getContactPhoneNumber_zch_hwz_gjc() == null ? other.getContactPhoneNumber_zch_hwz_gjc() == null : this.getContactPhoneNumber_zch_hwz_gjc().equals(other.getContactPhoneNumber_zch_hwz_gjc()))
            && (this.getIdNumber_zch_hwz_gjc() == null ? other.getIdNumber_zch_hwz_gjc() == null : this.getIdNumber_zch_hwz_gjc().equals(other.getIdNumber_zch_hwz_gjc()))
            && (this.getLicenseNumber_zch_hwz_gjc() == null ? other.getLicenseNumber_zch_hwz_gjc() == null : this.getLicenseNumber_zch_hwz_gjc().equals(other.getLicenseNumber_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDriverID_zch_hwz_gjc() == null) ? 0 : getDriverID_zch_hwz_gjc().hashCode());
        result = prime * result + ((getDriverName_zch_hwz_gjc() == null) ? 0 : getDriverName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getContactPhoneNumber_zch_hwz_gjc() == null) ? 0 : getContactPhoneNumber_zch_hwz_gjc().hashCode());
        result = prime * result + ((getIdNumber_zch_hwz_gjc() == null) ? 0 : getIdNumber_zch_hwz_gjc().hashCode());
        result = prime * result + ((getLicenseNumber_zch_hwz_gjc() == null) ? 0 : getLicenseNumber_zch_hwz_gjc().hashCode());
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
        sb.append(", driverID_zch_hwz_gjc=").append(driverID_zch_hwz_gjc);
        sb.append(", driverName_zch_hwz_gjc=").append(driverName_zch_hwz_gjc);
        sb.append(", contactPhoneNumber_zch_hwz_gjc=").append(contactPhoneNumber_zch_hwz_gjc);
        sb.append(", idNumber_zch_hwz_gjc=").append(idNumber_zch_hwz_gjc);
        sb.append(", licenseNumber_zch_hwz_gjc=").append(licenseNumber_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}