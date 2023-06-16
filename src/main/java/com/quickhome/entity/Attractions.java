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
public class Attractions {
    private long attractionsId_zch_hwz_gjc;
    private String attractionsName_zch_hwz_gjc;
    private Date openingTime_zch_hwz_gjc;
    private Date closingTime_zch_hwz_gjc;
    private Date attractionInDate_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;
}
