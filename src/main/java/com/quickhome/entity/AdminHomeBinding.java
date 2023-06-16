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
public class AdminHomeBinding {
    private long bindingID_zch_hwz_gjc;
    private long managerID_zch_hwz_gjc;
    private long homeID_zch_hwz_gjc;
    private String bindingType_zch_hwz_gjc;
    private Date bindingTime_zch_hwz_gjc;
    private String bindingState_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public AdminHomeBinding(long bindingID_zch_hwz_gjc, long managerID_zch_hwz_gjc, long homeID_zch_hwz_gjc, String bindingType_zch_hwz_gjc, Date bindingTime_zch_hwz_gjc, String bindingState_zch_hwz_gjc) {
        this.bindingID_zch_hwz_gjc = bindingID_zch_hwz_gjc;
        this.managerID_zch_hwz_gjc = managerID_zch_hwz_gjc;
        this.homeID_zch_hwz_gjc = homeID_zch_hwz_gjc;
        this.bindingType_zch_hwz_gjc = bindingType_zch_hwz_gjc;
        this.bindingTime_zch_hwz_gjc = bindingTime_zch_hwz_gjc;
        this.bindingState_zch_hwz_gjc = bindingState_zch_hwz_gjc;
    }
}
