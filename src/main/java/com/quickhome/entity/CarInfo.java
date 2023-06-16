package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarInfo {
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

    public CarInfo(long carID_zch_hwz_gjc, String brand_zch_hwz_gjc, String model_zch_hwz_gjc, String licensePlateNumber_zch_hwz_gjc, String carColor_zch_hwz_gjc, String entryTime_zch_hwz_gjc) {
        this.carID_zch_hwz_gjc = carID_zch_hwz_gjc;
        this.brand_zch_hwz_gjc = brand_zch_hwz_gjc;
        this.model_zch_hwz_gjc = model_zch_hwz_gjc;
        this.licensePlateNumber_zch_hwz_gjc = licensePlateNumber_zch_hwz_gjc;
        this.carColor_zch_hwz_gjc = carColor_zch_hwz_gjc;
        this.entryTime_zch_hwz_gjc = entryTime_zch_hwz_gjc;
    }
}
