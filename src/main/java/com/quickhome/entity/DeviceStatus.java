package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceStatus {
    private long statusID_zch_hwz_gjc;
    private long deviceID_zch_hwz_gjc;
    private String deviceStatus_zch_hwz_gjc;
    private Date updateTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public DeviceStatus(long statusID_zch_hwz_gjc, long deviceID_zch_hwz_gjc, String deviceStatus_zch_hwz_gjc, Date updateTime_zch_hwz_gjc) {
        this.statusID_zch_hwz_gjc = statusID_zch_hwz_gjc;
        this.deviceID_zch_hwz_gjc = deviceID_zch_hwz_gjc;
        this.deviceStatus_zch_hwz_gjc = deviceStatus_zch_hwz_gjc;
        this.updateTime_zch_hwz_gjc = updateTime_zch_hwz_gjc;
    }
}
