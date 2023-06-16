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
public class TripRecord {
    private long recordID_zch_hwz_gjc;
    private long reservationID_zch_hwz_gjc;
    private String startingPoint_zch_hwz_gjc;
    private String destination_zch_hwz_gjc;
    private Date startingTime_zch_hwz_gjc;
    private Date endTime_zch_hwz_gjc;
    private double distanceTraveled_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;
}
