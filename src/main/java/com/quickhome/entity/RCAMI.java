package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RCAMI {
    private long workItemId_zch_hwz_gjc;
    private Date informationCreatTime_zch_hwz_gjc;
    private Date completionProcessTime_zch_hwz_gjc;
    private String RCAMIInformation_zch_hwz_gjc;
    private String des_zch_hwz_gjc;
    private long workUserId_zch_hwz_gjc;
    private String completion_zch_hwz_gjc;
    private long publisherId_zch_hwz_gjc;
    private long homeId_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public RCAMI(long workItemId_zch_hwz_gjc, Date informationCreatTime_zch_hwz_gjc, Date completionProcessTime_zch_hwz_gjc, String RCAMIInformation_zch_hwz_gjc, String des_zch_hwz_gjc, long workUserId_zch_hwz_gjc, String completion_zch_hwz_gjc, long publisherId_zch_hwz_gjc, long homeId_zch_hwz_gjc) {
        this.workItemId_zch_hwz_gjc = workItemId_zch_hwz_gjc;
        this.informationCreatTime_zch_hwz_gjc = informationCreatTime_zch_hwz_gjc;
        this.completionProcessTime_zch_hwz_gjc = completionProcessTime_zch_hwz_gjc;
        this.RCAMIInformation_zch_hwz_gjc = RCAMIInformation_zch_hwz_gjc;
        this.des_zch_hwz_gjc = des_zch_hwz_gjc;
        this.workUserId_zch_hwz_gjc = workUserId_zch_hwz_gjc;
        this.completion_zch_hwz_gjc = completion_zch_hwz_gjc;
        this.publisherId_zch_hwz_gjc = publisherId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
    }
}
