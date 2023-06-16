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
public class HousingReview {
    private long housingReviewId_zch_hwz_gjc;
    private String comments_zch_hwz_gjc;
    private long userId_zch_hwz_gjc;
    private long homeId_zch_hwz_gjc;
    private Date reviewTime_zch_hwz_gjc;
    private int housingReviewRating_zch_hwz_gjc;
    private int homeLikeCount_zch_hwz_gjc;
    private long secondHousingReviewId_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public HousingReview(long housingReviewId_zch_hwz_gjc, String comments_zch_hwz_gjc, long userId_zch_hwz_gjc, long homeId_zch_hwz_gjc, Date reviewTime_zch_hwz_gjc, int housingReviewRating_zch_hwz_gjc, int homeLikeCount_zch_hwz_gjc, long secondHousingReviewId_zch_hwz_gjc) {
        this.housingReviewId_zch_hwz_gjc = housingReviewId_zch_hwz_gjc;
        this.comments_zch_hwz_gjc = comments_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.reviewTime_zch_hwz_gjc = reviewTime_zch_hwz_gjc;
        this.housingReviewRating_zch_hwz_gjc = housingReviewRating_zch_hwz_gjc;
        this.homeLikeCount_zch_hwz_gjc = homeLikeCount_zch_hwz_gjc;
        this.secondHousingReviewId_zch_hwz_gjc = secondHousingReviewId_zch_hwz_gjc;
    }
}
