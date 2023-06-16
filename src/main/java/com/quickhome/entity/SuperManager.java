package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SuperManager {
    private long superManagerId_zch_hwz_gjc;
    private String superManagerAccount_zch_hwz_gjc;
    private String superManagerPwd_zch_hwz_gjc;
    private Date createTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public SuperManager(long superManagerId_zch_hwz_gjc, String superManagerAccount_zch_hwz_gjc, String superManagerPwd_zch_hwz_gjc, Date createTime_zch_hwz_gjc) {
        this.superManagerId_zch_hwz_gjc = superManagerId_zch_hwz_gjc;
        this.superManagerAccount_zch_hwz_gjc = superManagerAccount_zch_hwz_gjc;
        this.superManagerPwd_zch_hwz_gjc = superManagerPwd_zch_hwz_gjc;
        this.createTime_zch_hwz_gjc = createTime_zch_hwz_gjc;
    }
}
