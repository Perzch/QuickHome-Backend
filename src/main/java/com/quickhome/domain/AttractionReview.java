package com.quickhome.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName tab_attractionReview_zch_hwz_gjc
 */
@TableName(value ="tab_attractionReview_zch_hwz_gjc")
@Data
public class AttractionReview implements Serializable {
    /**
     * 
     */
    @TableId(value = "attractionReviewId_zch_hwz_gjc", type = IdType.AUTO)
    private Long attractionReviewId_zch_hwz_gjc;

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
    @TableField(value = "attractionsId_zch_hwz_gjc")
    private Long attractionsId_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "reviewTime_zch_hwz_gjc")
    private Date reviewTime_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "attractionLikeCount_zch_hwz_gjc")
    private Integer attractionLikeCount_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "attractionReviewRating_zch_hwz_gjc")
    private Integer attractionReviewRating_zch_hwz_gjc;

    /**
     * 
     */
    @TableField(value = "secondAttractionReviewId_zch_hwz_gjc")
    private Long secondAttractionReviewId_zch_hwz_gjc;

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
        AttractionReview other = (AttractionReview) that;
        return (this.getAttractionReviewId_zch_hwz_gjc() == null ? other.getAttractionReviewId_zch_hwz_gjc() == null : this.getAttractionReviewId_zch_hwz_gjc().equals(other.getAttractionReviewId_zch_hwz_gjc()))
            && (this.getComments_zch_hwz_gjc() == null ? other.getComments_zch_hwz_gjc() == null : this.getComments_zch_hwz_gjc().equals(other.getComments_zch_hwz_gjc()))
            && (this.getUserId_zch_hwz_gjc() == null ? other.getUserId_zch_hwz_gjc() == null : this.getUserId_zch_hwz_gjc().equals(other.getUserId_zch_hwz_gjc()))
            && (this.getAttractionsId_zch_hwz_gjc() == null ? other.getAttractionsId_zch_hwz_gjc() == null : this.getAttractionsId_zch_hwz_gjc().equals(other.getAttractionsId_zch_hwz_gjc()))
            && (this.getReviewTime_zch_hwz_gjc() == null ? other.getReviewTime_zch_hwz_gjc() == null : this.getReviewTime_zch_hwz_gjc().equals(other.getReviewTime_zch_hwz_gjc()))
            && (this.getAttractionLikeCount_zch_hwz_gjc() == null ? other.getAttractionLikeCount_zch_hwz_gjc() == null : this.getAttractionLikeCount_zch_hwz_gjc().equals(other.getAttractionLikeCount_zch_hwz_gjc()))
            && (this.getAttractionReviewRating_zch_hwz_gjc() == null ? other.getAttractionReviewRating_zch_hwz_gjc() == null : this.getAttractionReviewRating_zch_hwz_gjc().equals(other.getAttractionReviewRating_zch_hwz_gjc()))
            && (this.getSecondAttractionReviewId_zch_hwz_gjc() == null ? other.getSecondAttractionReviewId_zch_hwz_gjc() == null : this.getSecondAttractionReviewId_zch_hwz_gjc().equals(other.getSecondAttractionReviewId_zch_hwz_gjc()))
            && (this.getStandby1_zch_hwz_gjc() == null ? other.getStandby1_zch_hwz_gjc() == null : this.getStandby1_zch_hwz_gjc().equals(other.getStandby1_zch_hwz_gjc()))
            && (this.getStandby2_zch_hwz_gjc() == null ? other.getStandby2_zch_hwz_gjc() == null : this.getStandby2_zch_hwz_gjc().equals(other.getStandby2_zch_hwz_gjc()))
            && (this.getStandby3_zch_hwz_gjc() == null ? other.getStandby3_zch_hwz_gjc() == null : this.getStandby3_zch_hwz_gjc().equals(other.getStandby3_zch_hwz_gjc()))
            && (this.getVisible_zch_hwz_gjc() == null ? other.getVisible_zch_hwz_gjc() == null : this.getVisible_zch_hwz_gjc().equals(other.getVisible_zch_hwz_gjc()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAttractionReviewId_zch_hwz_gjc() == null) ? 0 : getAttractionReviewId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getComments_zch_hwz_gjc() == null) ? 0 : getComments_zch_hwz_gjc().hashCode());
        result = prime * result + ((getUserId_zch_hwz_gjc() == null) ? 0 : getUserId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionsId_zch_hwz_gjc() == null) ? 0 : getAttractionsId_zch_hwz_gjc().hashCode());
        result = prime * result + ((getReviewTime_zch_hwz_gjc() == null) ? 0 : getReviewTime_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionLikeCount_zch_hwz_gjc() == null) ? 0 : getAttractionLikeCount_zch_hwz_gjc().hashCode());
        result = prime * result + ((getAttractionReviewRating_zch_hwz_gjc() == null) ? 0 : getAttractionReviewRating_zch_hwz_gjc().hashCode());
        result = prime * result + ((getSecondAttractionReviewId_zch_hwz_gjc() == null) ? 0 : getSecondAttractionReviewId_zch_hwz_gjc().hashCode());
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
        sb.append(", attractionReviewId_zch_hwz_gjc=").append(attractionReviewId_zch_hwz_gjc);
        sb.append(", comments_zch_hwz_gjc=").append(comments_zch_hwz_gjc);
        sb.append(", userId_zch_hwz_gjc=").append(userId_zch_hwz_gjc);
        sb.append(", attractionsId_zch_hwz_gjc=").append(attractionsId_zch_hwz_gjc);
        sb.append(", reviewTime_zch_hwz_gjc=").append(reviewTime_zch_hwz_gjc);
        sb.append(", attractionLikeCount_zch_hwz_gjc=").append(attractionLikeCount_zch_hwz_gjc);
        sb.append(", attractionReviewRating_zch_hwz_gjc=").append(attractionReviewRating_zch_hwz_gjc);
        sb.append(", secondAttractionReviewId_zch_hwz_gjc=").append(secondAttractionReviewId_zch_hwz_gjc);
        sb.append(", standby1_zch_hwz_gjc=").append(standby1_zch_hwz_gjc);
        sb.append(", standby2_zch_hwz_gjc=").append(standby2_zch_hwz_gjc);
        sb.append(", standby3_zch_hwz_gjc=").append(standby3_zch_hwz_gjc);
        sb.append(", visible_zch_hwz_gjc=").append(visible_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}