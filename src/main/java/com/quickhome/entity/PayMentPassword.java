package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PayMentPassword {
    private long passwordID_zch_hwz_gjc;
    private long accountID_zch_hwz_gjc;
    private String paymentPassword_zch_hwz_gjc;
    private Date setTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public PayMentPassword(long passwordID_zch_hwz_gjc, long accountID_zch_hwz_gjc, String paymentPassword_zch_hwz_gjc, Date setTime_zch_hwz_gjc) {
        this.passwordID_zch_hwz_gjc = passwordID_zch_hwz_gjc;
        this.accountID_zch_hwz_gjc = accountID_zch_hwz_gjc;
        this.paymentPassword_zch_hwz_gjc = paymentPassword_zch_hwz_gjc;
        this.setTime_zch_hwz_gjc = setTime_zch_hwz_gjc;
    }
}
