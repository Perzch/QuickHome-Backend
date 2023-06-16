package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AttractionReview {
    private long attractionReviewId_zch_hwz_gjc;
    private String comments_zch_hwz_gjc;
    private long userId_zch_hwz_gjc;
    private long attractionsId_zch_hwz_gjc;
    private Date reviewTime_zch_hwz_gjc;
    private int attractionLikeCont_zch_hwz_gjc;
    private int attractionReviewRating_zch_hwz_gjc;
    private long secondAttractionReviewId_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public AttractionReview(long attractionReviewId_zch_hwz_gjc, String comments_zch_hwz_gjc, long userId_zch_hwz_gjc, long attractionsId_zch_hwz_gjc, Date reviewTime_zch_hwz_gjc, int attractionLikeCont_zch_hwz_gjc, int attractionReviewRating_zch_hwz_gjc, long secondAttractionReviewId_zch_hwz_gjc) {
        this.attractionReviewId_zch_hwz_gjc = attractionReviewId_zch_hwz_gjc;
        this.comments_zch_hwz_gjc = comments_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.attractionsId_zch_hwz_gjc = attractionsId_zch_hwz_gjc;
        this.reviewTime_zch_hwz_gjc = reviewTime_zch_hwz_gjc;
        this.attractionLikeCont_zch_hwz_gjc = attractionLikeCont_zch_hwz_gjc;
        this.attractionReviewRating_zch_hwz_gjc = attractionReviewRating_zch_hwz_gjc;
        this.secondAttractionReviewId_zch_hwz_gjc = secondAttractionReviewId_zch_hwz_gjc;
    }
}
