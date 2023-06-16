package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DiverInfo {
    long driverID_zch_hwz_gjc;
    String driverName_zch_hwz_gjc;
    String contactPhoneNumber_zch_hwz_gjc;
    String idNumber_zch_hwz_gjc;
    String licenseNumber_zch_hwz_gjc;
    String standby1_zch_hwz_gjc;
    String standby2_zch_hwz_gjc;
    String standby3_zch_hwz_gjc;
    int visible_zch_hwz_gjc;

    public DiverInfo(long driverID_zch_hwz_gjc, String driverName_zch_hwz_gjc, String contactPhoneNumber_zch_hwz_gjc, String idNumber_zch_hwz_gjc, String licenseNumber_zch_hwz_gjc) {
        this.driverID_zch_hwz_gjc = driverID_zch_hwz_gjc;
        this.driverName_zch_hwz_gjc = driverName_zch_hwz_gjc;
        this.contactPhoneNumber_zch_hwz_gjc = contactPhoneNumber_zch_hwz_gjc;
        this.idNumber_zch_hwz_gjc = idNumber_zch_hwz_gjc;
        this.licenseNumber_zch_hwz_gjc = licenseNumber_zch_hwz_gjc;
    }
}
