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
 * @TableName tab_attractionreview_zch_hwz_gjc
 */
@TableName(value ="tab_attractionreview_zch_hwz_gjc")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties(value = { "standby1_zch_hwz_gjc","standby2_zch_hwz_gjc","standby3_zch_hwz_gjc","deleted_zch_hwz_gjc" })
public class AttractionReview implements Serializable {
    /**
     * 景点评论编号
     */
    @TableId(value = "attractionReviewId_zch_hwz_gjc", type = IdType.AUTO)
    @JsonProperty("attractionReviewId")
    private Long attractionReviewId_zch_hwz_gjc;

    /**
     * 评论内容
     */
    @TableField(value = "comments_zch_hwz_gjc")
    @JsonProperty("comments")
    private String comments_zch_hwz_gjc;

    /**
     * 用户编号
     */
    @TableField(value = "userId_zch_hwz_gjc")
    @JsonProperty("userId")
    private Long userId_zch_hwz_gjc;

    /**
     * 景点编号
     */
    @TableField(value = "attractionsId_zch_hwz_gjc")
    @JsonProperty("attractionsId")
    private Long attractionsId_zch_hwz_gjc;

    /**
     * 评论时间
     */
    @TableField(value = "reviewTime_zch_hwz_gjc")
    @JsonProperty("reviewTime")
    private Date reviewTime_zch_hwz_gjc;

    /**
     * 点赞数
     */
    @TableField(value = "attractionLikeCount_zch_hwz_gjc")
    @JsonProperty("attractionLikeCount")
    private Integer attractionLikeCount_zch_hwz_gjc;

    /**
     * 评分
     */
    @TableField(value = "attractionReviewRating_zch_hwz_gjc")
    @JsonProperty("attractionReviewRating")
    private Integer attractionReviewRating_zch_hwz_gjc;

    /**
     * 二级评论编号
     */
    @TableField(value = "secondAttractionReviewId_zch_hwz_gjc")
    @JsonProperty("secondAttractionReviewId")
    private Long secondAttractionReviewId_zch_hwz_gjc;

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
            && (this.getDeleted_zch_hwz_gjc() == null ? other.getDeleted_zch_hwz_gjc() == null : this.getDeleted_zch_hwz_gjc().equals(other.getDeleted_zch_hwz_gjc()));
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
        result = prime * result + ((getDeleted_zch_hwz_gjc() == null) ? 0 : getDeleted_zch_hwz_gjc().hashCode());
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
        sb.append(", deleted_zch_hwz_gjc=").append(deleted_zch_hwz_gjc);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}