package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long userId_zch_hwz_gjc;
    private String userAccount_zch_hwz_gjc;
    private String userName_zch_hwz_gjc;
    private String userPwd_zch_hwz_gjc;
    private String userEmail_zch_hwz_gjc;
    private String userPhone_zch_hwz_gjc;
    private Date userInDate_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public User(long userId_zch_hwz_gjc, String userAccount_zch_hwz_gjc, String userName_zch_hwz_gjc, String userPwd_zch_hwz_gjc, String userEmail_zch_hwz_gjc, String userPhone_zch_hwz_gjc, Date userInDate_zch_hwz_gjc) {
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.userAccount_zch_hwz_gjc = userAccount_zch_hwz_gjc;
        this.userName_zch_hwz_gjc = userName_zch_hwz_gjc;
        this.userPwd_zch_hwz_gjc = userPwd_zch_hwz_gjc;
        this.userEmail_zch_hwz_gjc = userEmail_zch_hwz_gjc;
        this.userPhone_zch_hwz_gjc = userPhone_zch_hwz_gjc;
        this.userInDate_zch_hwz_gjc = userInDate_zch_hwz_gjc;
    }
}
