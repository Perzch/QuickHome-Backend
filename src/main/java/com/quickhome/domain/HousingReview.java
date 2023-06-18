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
 * @TableName tab_housingReview_zch_hwz_gjc
 */
@TableName(value ="tab_housingReview_zch_hwz_gjc")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HousingReview implements Serializable {
    /**
     * 
     */
    @TableId(value = "housingReviewId_zch_hwz_gjc", type = IdType.AUTO)
    private Long housingReviewId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "comments_zch_hwz_gjc")
    private String comments_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "userId_zch_hwz_gjc")
    private Long userId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeId_zch_hwz_gjc")
    private Long homeId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "reviewTime_zch_hwz_gjc")
    private Date reviewTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "housingReviewRating_zch_hwz_gjc")
    private Integer housingReviewRating_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "homeLikeCount_zch_hwz_gjc")
    private Integer homeLikeCount_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "secondHousingReviewId_zch_hwz_gjc")
    private Long secondHousingReviewId_zch_hwz_gjc;

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
        HousingReview other = (HousingReview) that;
        return (this.getHousingReviewId_zch_hwz_gjc() == null ? other.getHousingReviewId_zch_hwz_gjc() == null : this.getHousingReviewId_zch_hwz_gjc().equals(other.getHousingReviewId_zch_hwz_gjc()))
            && (this.getComments_zch_hwz_gjc() == null ? other.getComments_zch_hwz_gjc() == null : this.getComments_zch_hwz_gjc().equals(other.getComments_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getHomeId_zch_hwz_gjc() == null ? other.getHomeId_zch_hwz_gjc() == null : this.getHomeId_zch_hwz_gjc().equals(other.getHomeId_zch_hwz_gjc()))
            && (this.getReviewTime_zch_hwz_gjc() == null ? other.getReviewTime_zch_hwz_gjc() == null : this.getReviewTime_zch_hwz_gjc().equals(other.getReviewTime_zch_hwz_gjc()))
            && (this.getHousingReviewRating_zch_hwz_gjc() == null ? other.getHousingReviewRating_zch_hwz_gjc() == null : this.getHousingReviewRating_zch_hwz_gjc().equals(other.getHousingReviewRating_zch_hwz_gjc()))
            && (this.getHomeLikeCount_zch_hwz_gjc() == null ? other.getHomeLikeCount_zch_hwz_gjc() == null : this.getHomeLikeCount_zch_hwz_gjc().equals(other.getHomeLikeCount_zch_hwz_gjc()))
            && (this.getSecondHousingReviewId_zch_hwz_gjc() == null ? other.getSecondHousingReviewId_zch_hwz_gjc() == null : this.getSecondHousingReviewId_zch_hwz_gjc().equals(other.getSecondHousingReviewId_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getHousingReviewId_zch_hwz_gjc() == null) ? 0 : getHousingReviewId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getComments_zch_hwz_gjc() == null) ? 0 : getComments_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeId_zch_hwz_gjc() == null) ? 0 : getHomeId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getReviewTime_zch_hwz_gjc() == null) ? 0 : getReviewTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHousingReviewRating_zch_hwz_gjc() == null) ? 0 : getHousingReviewRating_zch_hwz_gjc().hashCode());
        result = prime * result + ((getHomeLikeCount_zch_hwz_gjc() == null) ? 0 : getHomeLikeCount_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSecondHousingReviewId_zch_hwz_gjc() == null) ? 0 : getSecondHousingReviewId_zch_hwz_gjc().hashCode());
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
        sb.append(", housingReviewId_zch_hwz_gjc=").append(housingReviewId_zch_hwz_gjc);
        sb.append(", comments_zch_hwz_gjc=").append(comments_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", homeId_zch_hwz_gjc=").append(homeId_zch_hwz_gjc);
        sb.append(", reviewTime_zch_hwz_gjc=").append(reviewTime_zch_hwz_gjc);
        sb.append(", housingReviewRating_zch_hwz_gjc=").append(housingReviewRating_zch_hwz_gjc);
        sb.append(", homeLikeCount_zch_hwz_gjc=").append(homeLikeCount_zch_hwz_gjc);
        sb.append(", secondHousingReviewId_zch_hwz_gjc=").append(secondHousingReviewId_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}