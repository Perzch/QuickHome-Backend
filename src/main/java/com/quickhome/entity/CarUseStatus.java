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
public class CarUseStatus {
    private long userStatusID_zch_hwz_gjc;
    private long carID_zch_hwz_gjc;
    private Date useDate_zch_hwz_gjc;
    private String userStatus_zch_hwz_gjc;
    private int mileage_zch_hwz_gjc;
    private int oilVolume_zch_hwz_gjc;
    private String tireSituation_zch_hwz_gjc;
    private String otherMaintenance_zch_hwz_gjc;
    private Date nextInspectionTime_zch_hwz_gjc;
    private String inspectRemark_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public CarUseStatus(long userStatusID_zch_hwz_gjc, long carID_zch_hwz_gjc, Date useDate_zch_hwz_gjc, String userStatus_zch_hwz_gjc, int mileage_zch_hwz_gjc, int oilVolume_zch_hwz_gjc, String tireSituation_zch_hwz_gjc, String otherMaintenance_zch_hwz_gjc, Date nextInspectionTime_zch_hwz_gjc, String inspectRemark_zch_hwz_gjc) {
        this.userStatusID_zch_hwz_gjc = userStatusID_zch_hwz_gjc;
        this.carID_zch_hwz_gjc = carID_zch_hwz_gjc;
        this.useDate_zch_hwz_gjc = useDate_zch_hwz_gjc;
        this.userStatus_zch_hwz_gjc = userStatus_zch_hwz_gjc;
        this.mileage_zch_hwz_gjc = mileage_zch_hwz_gjc;
        this.oilVolume_zch_hwz_gjc = oilVolume_zch_hwz_gjc;
        this.tireSituation_zch_hwz_gjc = tireSituation_zch_hwz_gjc;
        this.otherMaintenance_zch_hwz_gjc = otherMaintenance_zch_hwz_gjc;
        this.nextInspectionTime_zch_hwz_gjc = nextInspectionTime_zch_hwz_gjc;
        this.inspectRemark_zch_hwz_gjc = inspectRemark_zch_hwz_gjc;
    }
}
