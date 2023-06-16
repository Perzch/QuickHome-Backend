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
public class DeviceControlRecord {
    private long recordID_zch_hwz_gjc;
    private long userID_zch_hwz_gjc;
    private long deviceID_zch_hwz_gjc;
    private Date controlTime_zch_hwz_gjc;
    private String controlType_zch_hwz_gjc;
    private String controlContent_zch_hwz_gjc;
    private Date deviceReservationTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public DeviceControlRecord(long recordID_zch_hwz_gjc, long userID_zch_hwz_gjc, long deviceID_zch_hwz_gjc, Date controlTime_zch_hwz_gjc, String controlType_zch_hwz_gjc, String controlContent_zch_hwz_gjc, Date deviceReservationTime_zch_hwz_gjc) {
        this.recordID_zch_hwz_gjc = recordID_zch_hwz_gjc;
        this.userID_zch_hwz_gjc = userID_zch_hwz_gjc;
        this.deviceID_zch_hwz_gjc = deviceID_zch_hwz_gjc;
        this.controlTime_zch_hwz_gjc = controlTime_zch_hwz_gjc;
        this.controlType_zch_hwz_gjc = controlType_zch_hwz_gjc;
        this.controlContent_zch_hwz_gjc = controlContent_zch_hwz_gjc;
        this.deviceReservationTime_zch_hwz_gjc = deviceReservationTime_zch_hwz_gjc;
    }
}
