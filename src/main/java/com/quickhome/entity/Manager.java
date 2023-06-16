package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {
    private long managerId_zch_hwz_gjc;
    private String administratorCategory_zch_hwz_gjc;
    private String managerAccount_zch_hwz_gjc;
    private String managerPwd_zch_hwz_gjc;
    private String managerName_zch_hwz_gjc;
    private String managerPhone_zch_hwz_gjc;
    private String managerGender_zch_hwz_gjc;
    private Date managerInDate_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public Manager(long managerId_zch_hwz_gjc, String administratorCategory_zch_hwz_gjc, String managerAccount_zch_hwz_gjc, String managerPwd_zch_hwz_gjc, String managerName_zch_hwz_gjc, String managerPhone_zch_hwz_gjc, String managerGender_zch_hwz_gjc, Date managerInDate_zch_hwz_gjc) {
        this.managerId_zch_hwz_gjc = managerId_zch_hwz_gjc;
        this.administratorCategory_zch_hwz_gjc = administratorCategory_zch_hwz_gjc;
        this.managerAccount_zch_hwz_gjc = managerAccount_zch_hwz_gjc;
        this.managerPwd_zch_hwz_gjc = managerPwd_zch_hwz_gjc;
        this.managerName_zch_hwz_gjc = managerName_zch_hwz_gjc;
        this.managerPhone_zch_hwz_gjc = managerPhone_zch_hwz_gjc;
        this.managerGender_zch_hwz_gjc = managerGender_zch_hwz_gjc;
        this.managerInDate_zch_hwz_gjc = managerInDate_zch_hwz_gjc;
    }
}
