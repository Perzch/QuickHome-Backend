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
public class SmartDevice {
    private long deviceID_zch_hwz_gjc;
    private long homeId_zch_hwz_gjc;
    private String deviceName_zch_hwz_gjc;
    private String deviceType_zch_hwz_gjc;
    private String brand_zch_hwz_gjc;
    private Date price_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public SmartDevice(long deviceID_zch_hwz_gjc, long homeId_zch_hwz_gjc, String deviceName_zch_hwz_gjc, String deviceType_zch_hwz_gjc, String brand_zch_hwz_gjc, Date price_zch_hwz_gjc) {
        this.deviceID_zch_hwz_gjc = deviceID_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.deviceName_zch_hwz_gjc = deviceName_zch_hwz_gjc;
        this.deviceType_zch_hwz_gjc = deviceType_zch_hwz_gjc;
        this.brand_zch_hwz_gjc = brand_zch_hwz_gjc;
        this.price_zch_hwz_gjc = price_zch_hwz_gjc;
    }
}
