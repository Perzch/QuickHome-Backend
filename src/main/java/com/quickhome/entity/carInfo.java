package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class carInfo {
    private long carID_zch_hwz_gjc;
    private String brand_zch_hwz_gjc;
    private String model_zch_hwz_gjc;
    private String licensePlateNumber_zch_hwz_gjc;
    private String carColor_zch_hwz_gjc;
    private String entryTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;
}
