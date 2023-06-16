package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseCollection {
    private long hFavoriteRecordsId_zch_hwz_gjc;
    private long userId_zch_hwz_gjc;
    private long homeId_zch_hwz_gjc;
    private Date collectionTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public HouseCollection(long hFavoriteRecordsId_zch_hwz_gjc, long userId_zch_hwz_gjc, long homeId_zch_hwz_gjc, Date collectionTime_zch_hwz_gjc) {
        this.hFavoriteRecordsId_zch_hwz_gjc = hFavoriteRecordsId_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.collectionTime_zch_hwz_gjc = collectionTime_zch_hwz_gjc;
    }
}
