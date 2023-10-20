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
 * @TableName tab_homeinformation_zch_hwz_gjc
 */
@TableName(value ="tab_homeinformation_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class HomeInformation implements Serializable {
    /**
     * 房屋信息编号
     */
    @TableId(value = "homeInfId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("homeInfId")
    private Long homeInfId_zch_hwz_gjc;

    /**
     * 房屋编号
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    @JsonProperty("homeId")
    private Long homeId_zch_hwz_gjc;

    /**
     * 房屋面积
     */
    @TableField(value = "homeArea_zch_hwz_gjc")
    @JsonProperty("homeArea")
    private Double homeArea_zch_hwz_gjc;

    /**
     * 房屋结构
     */
    @TableField(value = "houseStructure_zch_hwz_gjc")
    @JsonProperty("houseStructure")
    private String houseStructure_zch_hwz_gjc;

    /**
     * 最大入住人数
     */
    @TableField(value = "maxPerson_zch_hwz_gjc")
    @JsonProperty("maxPerson")
    private Integer maxPerson_zch_hwz_gjc;

    /**
     * 房屋押金
     */
    @TableField(value = "homeDeposit_zch_hwz_gjc")
    @JsonProperty("homeDeposit")
    private Double homeDeposit_zch_hwz_gjc;

    /**
     * 房屋注册日期
     */
    @TableField(value = "homeInDate_zch_hwz_gjc")
    @JsonProperty("homeInDate")
    private Date homeInDate_zch_hwz_gjc;

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
        HomeInformation other = (HomeInformation) that;
        return (this.getHomeInfId_zch_hwz_gjc() == null ? other.getHomeInfId_zch_hwz_gjc() == null : this.getHomeInfId_zch_hwz_gjc().equals(other.getHomeInfId_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getHomeArea_zch_hwz_gjc() == null ? other.getHomeArea_zch_hwz_gjc() == null : this.getHomeArea_zch_hwz_gjc().equals(other.getHomeArea_zch_hwz_gjc()))
            && (this.getHouseStructure_zch_hwz_gjc() == null ? other.getHouseStructure_zch_hwz_gjc() == null : this.getHouseStructure_zch_hwz_gjc().equals(other.getHouseStructure_zch_hwz_gjc()))
            && (this.getMaxPerson_zch_hwz_gjc() == null ? other.getMaxPerson_zch_hwz_gjc() == null : this.getMaxPerson_zch_hwz_gjc().equals(other.getMaxPerson_zch_hwz_gjc()))
            && (this.getHomeDeposit_zch_hwz_gjc() == null ? other.getHomeDeposit_zch_hwz_gjc() == null : this.getHomeDeposit_zch_hwz_gjc().equals(other.getHomeDeposit_zch_hwz_gjc()))
            && (this.getHomeInDate_zch_hwz_gjc() == null ? other.getHomeInDate_zch_hwz_gjc() == null : this.getHomeInDate_zch_hwz_gjc().equals(other.getHomeInDate_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHomeInfId_zch_hwz_gjc() == null) ? 0 : getHomeInfId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeArea_zch_hwz_gjc() == null) ? 0 : getHomeArea_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHouseStructure_zch_hwz_gjc() == null) ? 0 : getHouseStructure_zch_hwz_gjc().hashCode());
        result = prime * result + ((getMaxPerson_zch_hwz_gjc() == null) ? 0 : getMaxPerson_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeDeposit_zch_hwz_gjc() == null) ? 0 : getHomeDeposit_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeInDate_zch_hwz_gjc() == null) ? 0 : getHomeInDate_zch_hwz_gjc().hashCode());
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
        sb.append(", homeInfId_zch_hwz_gjc=").append(homeInfId_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", homeArea_zch_hwz_gjc=").append(homeArea_zch_hwz_gjc);
        sb.append(", houseStructure_zch_hwz_gjc=").append(houseStructure_zch_hwz_gjc);
        sb.append(", maxPerson_zch_hwz_gjc=").append(maxPerson_zch_hwz_gjc);
        sb.append(", homeDeposit_zch_hwz_gjc=").append(homeDeposit_zch_hwz_gjc);
        sb.append(", homeInDate_zch_hwz_gjc=").append(homeInDate_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}