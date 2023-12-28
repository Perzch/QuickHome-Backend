package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @TableName tab_home_zch_hwz_gjc
 */
@TableName(value ="tab_home_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class Home implements Serializable {
    /**
     * 房屋编号
     */
    @TableId(value = "homeId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("homeId")
    private Long homeId_zch_hwz_gjc;

    /**
     * 房屋名称
     */
    @TableField(value = "homeName_zch_hwz_gjc")
    @JsonProperty("homeName")
    private String homeName_zch_hwz_gjc;

    /**
     * 房屋类型
     */
    @TableField(value = "homeType_zch_hwz_gjc")
    @JsonProperty("homeType")
    private String homeType_zch_hwz_gjc;

    /**
     * 每日租金
     */
    @TableField(value = "homeDayRent_zch_hwz_gjc")
    @JsonProperty("homeDayRent")
    private Double homeDayRent_zch_hwz_gjc;

    /**
     * 房屋状态
     */
    @TableField(value = "homeState_zch_hwz_gjc")
    @JsonProperty("homeState")
    private String homeState_zch_hwz_gjc;

    /**
     * 房屋地址
     */
    @TableField(value = "homeAddress_zch_hwz_gjc")
    @JsonProperty("homeAddress")
    private String homeAddress_zch_hwz_gjc;

    /**
     * 备用字段1
     */
    @TableField(value = "homeImages_zch_hwz_gjc")
    @JsonProperty("homeImages")
    private String homeImages_zch_hwz_gjc;

    @TableField(exist = false)
    private String[] homeImageList;

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
        Home other = (Home) that;
        return (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getHomeName_zch_hwz_gjc() == null ? other.getHomeName_zch_hwz_gjc() == null : this.getHomeName_zch_hwz_gjc().equals(other.getHomeName_zch_hwz_gjc()))
            && (this.getHomeType_zch_hwz_gjc() == null ? other.getHomeType_zch_hwz_gjc() == null : this.getHomeType_zch_hwz_gjc().equals(other.getHomeType_zch_hwz_gjc()))
            && (this.getHomeDayRent_zch_hwz_gjc() == null ? other.getHomeDayRent_zch_hwz_gjc() == null : this.getHomeDayRent_zch_hwz_gjc().equals(other.getHomeDayRent_zch_hwz_gjc()))
            && (this.getHomeState_zch_hwz_gjc() == null ? other.getHomeState_zch_hwz_gjc() == null : this.getHomeState_zch_hwz_gjc().equals(other.getHomeState_zch_hwz_gjc()))
            && (this.getHomeAddress_zch_hwz_gjc() == null ? other.getHomeAddress_zch_hwz_gjc() == null : this.getHomeAddress_zch_hwz_gjc().equals(other.getHomeAddress_zch_hwz_gjc()))
            && (this.getHomeImages_zch_hwz_gjc() == null ? other.getHomeImages_zch_hwz_gjc() == null : this.getHomeImages_zch_hwz_gjc().equals(other.getHomeImages_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeName_zch_hwz_gjc() == null) ? 0 : getHomeName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeType_zch_hwz_gjc() == null) ? 0 : getHomeType_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeDayRent_zch_hwz_gjc() == null) ? 0 : getHomeDayRent_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeState_zch_hwz_gjc() == null) ? 0 : getHomeState_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeAddress_zch_hwz_gjc() == null) ? 0 : getHomeAddress_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeImages_zch_hwz_gjc() == null) ? 0 : getHomeImages_zch_hwz_gjc().hashCode());
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
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", homeName_zch_hwz_gjc=").append(homeName_zch_hwz_gjc);
        sb.append(", homeType_zch_hwz_gjc=").append(homeType_zch_hwz_gjc);
        sb.append(", homeDayRent_zch_hwz_gjc=").append(homeDayRent_zch_hwz_gjc);
        sb.append(", homeState_zch_hwz_gjc=").append(homeState_zch_hwz_gjc);
        sb.append(", homeAddress_zch_hwz_gjc=").append(homeAddress_zch_hwz_gjc);
        sb.append(", homeImages_zch_hwz_gjc=").append(homeImages_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
