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
 * @TableName tab_attractions_zch_hwz_gjc
 */
@TableName(value ="tab_attractions_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Attractions implements Serializable {
    /**
     * 
     */
    @TableId(value = "attractionsId_zch_hwz_gjc", type = IdType.AUTO)
    private Long attractionsId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "attractionsName_zch_hwz_gjc")
    private String attractionsName_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "attractionInformation_zch_hwz_gjc")
    private String attractionInformation_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "openingTime_zch_hwz_gjc")
    private Date openingTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "closingTime_zch_hwz_gjc")
    private Date closingTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "attractionInDate_zch_hwz_gjc")
    private Date attractionInDate_zch_hwz_gjc;

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
        Attractions other = (Attractions) that;
        return (this.getAttractionsId_zch_hwz_gjc() == null ? other.getAttractionsId_zch_hwz_gjc() == null : this.getAttractionsId_zch_hwz_gjc().equals(other.getAttractionsId_zch_hwz_gjc()))
            && (this.getAttractionsName_zch_hwz_gjc() == null ? other.getAttractionsName_zch_hwz_gjc() == null : this.getAttractionsName_zch_hwz_gjc().equals(other.getAttractionsName_zch_hwz_gjc()))
            && (this.getAttractionInformation_zch_hwz_gjc() == null ? other.getAttractionInformation_zch_hwz_gjc() == null : this.getAttractionInformation_zch_hwz_gjc().equals(other.getAttractionInformation_zch_hwz_gjc()))
            && (this.getOpeningTime_zch_hwz_gjc() == null ? other.getOpeningTime_zch_hwz_gjc() == null : this.getOpeningTime_zch_hwz_gjc().equals(other.getOpeningTime_zch_hwz_gjc()))
            && (this.getClosingTime_zch_hwz_gjc() == null ? other.getClosingTime_zch_hwz_gjc() == null : this.getClosingTime_zch_hwz_gjc().equals(other.getClosingTime_zch_hwz_gjc()))
            && (this.getAttractionInDate_zch_hwz_gjc() == null ? other.getAttractionInDate_zch_hwz_gjc() == null : this.getAttractionInDate_zch_hwz_gjc().equals(other.getAttractionInDate_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttractionsId_zch_hwz_gjc() == null) ? 0 : getAttractionsId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionsName_zch_hwz_gjc() == null) ? 0 : getAttractionsName_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionInformation_zch_hwz_gjc() == null) ? 0 : getAttractionInformation_zch_hwz_gjc().hashCode());
        result = prime * result + ((getOpeningTime_zch_hwz_gjc() == null) ? 0 : getOpeningTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getClosingTime_zch_hwz_gjc() == null) ? 0 : getClosingTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionInDate_zch_hwz_gjc() == null) ? 0 : getAttractionInDate_zch_hwz_gjc().hashCode());
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
        sb.append(", attractionsId_zch_hwz_gjc=").append(attractionsId_zch_hwz_gjc);
        sb.append(", attractionsName_zch_hwz_gjc=").append(attractionsName_zch_hwz_gjc);
        sb.append(", attractionInformation_zch_hwz_gjc=").append(attractionInformation_zch_hwz_gjc);
        sb.append(", openingTime_zch_hwz_gjc=").append(openingTime_zch_hwz_gjc);
        sb.append(", closingTime_zch_hwz_gjc=").append(closingTime_zch_hwz_gjc);
        sb.append(", attractionInDate_zch_hwz_gjc=").append(attractionInDate_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}