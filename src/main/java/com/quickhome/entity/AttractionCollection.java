package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttractionCollection {
    private long aFavoriteRecordsId_zch_hwz_gjc;
    private long userID_zch_hwz_gjc;
    private long attractionsId_zch_hwz_gjc;
    private Date collectionTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public AttractionCollection(long aFavoriteRecordsId_zch_hwz_gjc, long userID_zch_hwz_gjc, long attractionsId_zch_hwz_gjc, Date collectionTime_zch_hwz_gjc) {
        this.aFavoriteRecordsId_zch_hwz_gjc = aFavoriteRecordsId_zch_hwz_gjc;
        this.userID_zch_hwz_gjc = userID_zch_hwz_gjc;
        this.attractionsId_zch_hwz_gjc = attractionsId_zch_hwz_gjc;
        this.collectionTime_zch_hwz_gjc = collectionTime_zch_hwz_gjc;
    }
}
