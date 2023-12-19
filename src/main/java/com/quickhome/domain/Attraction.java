package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @TableName tab_attraction_zch_hwz_gjc
 */
@TableName(value ="tab_attraction_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class Attraction implements Serializable {
    /**
     * 景点编号
     */
    @TableId(value = "attractionId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("attractionId")
    private Long attractionId_zch_hwz_gjc;

    /**
     * 景点名称
     */
    @TableField(value = "attractionName_zch_hwz_gjc")
    @JsonProperty("attractionName")
    private String attractionName_zch_hwz_gjc;

    /**
     * 景点介绍
     */
    @TableField(value = "attractionInformation_zch_hwz_gjc")
    @JsonProperty("attractionInformation")
    private String attractionInformation_zch_hwz_gjc;

    /**
     * 景点开放时间
     */
    @TableField(value = "openingTime_zch_hwz_gjc")
    @JsonProperty("openingTime")
    private LocalTime openingTime_zch_hwz_gjc;

    /**
     * 景点关闭时间
     */
    @TableField(value = "closingTime_zch_hwz_gjc")
    @JsonProperty("closingTime")
    private LocalTime closingTime_zch_hwz_gjc;

    /**
     * 信息录入时间
     */
    @TableField(value = "attractionInDate_zch_hwz_gjc")
    @JsonProperty("attractionInDate")
    private Date attractionInDate_zch_hwz_gjc;

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
        Attraction other = (Attraction) that;
        return (this.getAttractionId_zch_hwz_gjc() == null ? other.getAttractionId_zch_hwz_gjc() == null : this.getAttractionId_zch_hwz_gjc().equals(other.getAttractionId_zch_hwz_gjc()))
            && (this.getAttractionName_zch_hwz_gjc() == null ? other.getAttractionName_zch_hwz_gjc() == null : this.getAttractionName_zch_hwz_gjc().equals(other.getAttractionName_zch_hwz_gjc()))
            && (this.getAttractionInformation_zch_hwz_gjc() == null ? other.getAttractionInformation_zch_hwz_gjc() == null : this.getAttractionInformation_zch_hwz_gjc().equals(other.getAttractionInformation_zch_hwz_gjc()))
            && (this.getOpeningTime_zch_hwz_gjc() == null ? other.getOpeningTime_zch_hwz_gjc() == null : this.getOpeningTime_zch_hwz_gjc().equals(other.getOpeningTime_zch_hwz_gjc()))
            && (this.getClosingTime_zch_hwz_gjc() == null ? other.getClosingTime_zch_hwz_gjc() == null : this.getClosingTime_zch_hwz_gjc().equals(other.getClosingTime_zch_hwz_gjc()))
            && (this.getAttractionInDate_zch_hwz_gjc() == null ? other.getAttractionInDate_zch_hwz_gjc() == null : this.getAttractionInDate_zch_hwz_gjc().equals(other.getAttractionInDate_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getVersion_zch_hwz_gjc() == null ? other.getVersion_zch_hwz_gjc() == null : this.getVersion_zch_hwz_gjc().equals(other.getVersion_zch_hwz_gjc()))
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttractionId_zch_hwz_gjc() == null) ? 0 : getAttractionId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionName_zch_hwz_gjc() == null) ? 0 : getAttractionName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionInformation_zch_hwz_gjc() == null) ? 0 : getAttractionInformation_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOpeningTime_zch_hwz_gjc() == null) ? 0 : getOpeningTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getClosingTime_zch_hwz_gjc() == null) ? 0 : getClosingTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionInDate_zch_hwz_gjc() == null) ? 0 : getAttractionInDate_zch_hwz_gjc().hashCode());
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
        sb.append(", attractionId_zch_hwz_gjc=").append(attractionId_zch_hwz_gjc);
        sb.append(", attractionName_zch_hwz_gjc=").append(attractionName_zch_hwz_gjc);
        sb.append(", attractionInformation_zch_hwz_gjc=").append(attractionInformation_zch_hwz_gjc);
        sb.append(", openingTime_zch_hwz_gjc=").append(openingTime_zch_hwz_gjc);
        sb.append(", closingTime_zch_hwz_gjc=").append(closingTime_zch_hwz_gjc);
        sb.append(", attractionInDate_zch_hwz_gjc=").append(attractionInDate_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", version_zch_hwz_gjc=").append(version_zch_hwz_gjc);
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
