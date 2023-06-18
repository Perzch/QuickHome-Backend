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
 * @TableName tab_homeInformation_zch_hwz_gjc
 */
@TableName(value ="tab_homeInformation_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HomeInformation implements Serializable {
    /**
     * 
     */
    @TableId(value = "homeId_zch_hwz_gjc", type = IdType.AUTO)
    private Long homeId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeName_zch_hwz_gjc")
    private String homeName_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeType_zch_hwz_gjc")
    private String homeType_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeArea_zch_hwz_gjc")
    private Double homeArea_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeDescribe_zch_hwz_gjc")
    private String homeDescribe_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "maxPerson_zch_hwz_gjc")
    private Integer maxPerson_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeFacilities_zch_hwz_gjc")
    private String homeFacilities_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeDayRent_zch_hwz_gjc")
    private Double homeDayRent_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeDeposit_zch_hwz_gjc")
    private Double homeDeposit_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeState_zch_hwz_gjc")
    private String homeState_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeAddress_zch_hwz_gjc")
    private String homeAddress_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeInDate_zch_hwz_gjc")
    private Date homeInDate_zch_hwz_gjc;

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
        HomeInformation other = (HomeInformation) that;
        return (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getHomeName_zch_hwz_gjc() == null ? other.getHomeName_zch_hwz_gjc() == null : this.getHomeName_zch_hwz_gjc().equals(other.getHomeName_zch_hwz_gjc()))
            && (this.getHomeType_zch_hwz_gjc() == null ? other.getHomeType_zch_hwz_gjc() == null : this.getHomeType_zch_hwz_gjc().equals(other.getHomeType_zch_hwz_gjc()))
            && (this.getHomeArea_zch_hwz_gjc() == null ? other.getHomeArea_zch_hwz_gjc() == null : this.getHomeArea_zch_hwz_gjc().equals(other.getHomeArea_zch_hwz_gjc()))
            && (this.getHomeDescribe_zch_hwz_gjc() == null ? other.getHomeDescribe_zch_hwz_gjc() == null : this.getHomeDescribe_zch_hwz_gjc().equals(other.getHomeDescribe_zch_hwz_gjc()))
            && (this.getMaxPerson_zch_hwz_gjc() == null ? other.getMaxPerson_zch_hwz_gjc() == null : this.getMaxPerson_zch_hwz_gjc().equals(other.getMaxPerson_zch_hwz_gjc()))
            && (this.getHomeFacilities_zch_hwz_gjc() == null ? other.getHomeFacilities_zch_hwz_gjc() == null : this.getHomeFacilities_zch_hwz_gjc().equals(other.getHomeFacilities_zch_hwz_gjc()))
            && (this.getHomeDayRent_zch_hwz_gjc() == null ? other.getHomeDayRent_zch_hwz_gjc() == null : this.getHomeDayRent_zch_hwz_gjc().equals(other.getHomeDayRent_zch_hwz_gjc()))
            && (this.getHomeDeposit_zch_hwz_gjc() == null ? other.getHomeDeposit_zch_hwz_gjc() == null : this.getHomeDeposit_zch_hwz_gjc().equals(other.getHomeDeposit_zch_hwz_gjc()))
            && (this.getHomeState_zch_hwz_gjc() == null ? other.getHomeState_zch_hwz_gjc() == null : this.getHomeState_zch_hwz_gjc().equals(other.getHomeState_zch_hwz_gjc()))
            && (this.getHomeAddress_zch_hwz_gjc() == null ? other.getHomeAddress_zch_hwz_gjc() == null : this.getHomeAddress_zch_hwz_gjc().equals(other.getHomeAddress_zch_hwz_gjc()))
            && (this.getHomeInDate_zch_hwz_gjc() == null ? other.getHomeInDate_zch_hwz_gjc() == null : this.getHomeInDate_zch_hwz_gjc().equals(other.getHomeInDate_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeName_zch_hwz_gjc() == null) ? 0 : getHomeName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeType_zch_hwz_gjc() == null) ? 0 : getHomeType_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeArea_zch_hwz_gjc() == null) ? 0 : getHomeArea_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeDescribe_zch_hwz_gjc() == null) ? 0 : getHomeDescribe_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMaxPerson_zch_hwz_gjc() == null) ? 0 : getMaxPerson_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeFacilities_zch_hwz_gjc() == null) ? 0 : getHomeFacilities_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeDayRent_zch_hwz_gjc() == null) ? 0 : getHomeDayRent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeDeposit_zch_hwz_gjc() == null) ? 0 : getHomeDeposit_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeState_zch_hwz_gjc() == null) ? 0 : getHomeState_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeAddress_zch_hwz_gjc() == null) ? 0 : getHomeAddress_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeInDate_zch_hwz_gjc() == null) ? 0 : getHomeInDate_zch_hwz_gjc().hashCode());
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
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", homeName_zch_hwz_gjc=").append(homeName_zch_hwz_gjc);
        sb.append(", homeType_zch_hwz_gjc=").append(homeType_zch_hwz_gjc);
        sb.append(", homeArea_zch_hwz_gjc=").append(homeArea_zch_hwz_gjc);
        sb.append(", homeDescribe_zch_hwz_gjc=").append(homeDescribe_zch_hwz_gjc);
        sb.append(", maxPerson_zch_hwz_gjc=").append(maxPerson_zch_hwz_gjc);
        sb.append(", homeFacilities_zch_hwz_gjc=").append(homeFacilities_zch_hwz_gjc);
        sb.append(", homeDayRent_zch_hwz_gjc=").append(homeDayRent_zch_hwz_gjc);
        sb.append(", homeDeposit_zch_hwz_gjc=").append(homeDeposit_zch_hwz_gjc);
        sb.append(", homeState_zch_hwz_gjc=").append(homeState_zch_hwz_gjc);
        sb.append(", homeAddress_zch_hwz_gjc=").append(homeAddress_zch_hwz_gjc);
        sb.append(", homeInDate_zch_hwz_gjc=").append(homeInDate_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}