package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeInformation {
    private long homeId_zch_hwz_gjc;
    private String homeName_zch_hwz_gjc;
    private String homeType_zch_hwz_gjc;
    private float homeArea_zch_hwz_gjc;
    private String homeDescribe_zch_hwz_gjc;
    private int maxPerson_zch_hwz_gjc;
    private String homeFacilities_zch_hwz_gjc;
    private double homeDayRent_zch_hwz_gjc;
    private double homeDeposit_zch_hwz_gjc;
    private String homeState_zch_hwz_gjc;
    private String homeAddress_zch_hwz_gjc;
    private Date homeInDate_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

}
