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
public class UserInformation {
    private long UIId_zch_hwz_gjc;
    private long userId_zch_hwz_gjc;
    private String userGender_zch_hwz_gjc;
    private long userHeadId_zch_hwz_gjc;
    private Date userBirthday_zch_hwz_gjc;
    private String userSignature_zch_hwz_gjc;
    private String idCardType_zch_hwz_gjc;
    private String idCardNumber_zch_hwz_gjc;
    private String authenticationStatus_zch_hwz_gjc;
    private Date authenticationTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public UserInformation(long UIId_zch_hwz_gjc, long userId_zch_hwz_gjc, String userGender_zch_hwz_gjc, long userHeadId_zch_hwz_gjc, Date userBirthday_zch_hwz_gjc, String userSignature_zch_hwz_gjc, String idCardType_zch_hwz_gjc, String idCardNumber_zch_hwz_gjc, String authenticationStatus_zch_hwz_gjc, Date authenticationTime_zch_hwz_gjc) {
        this.UIId_zch_hwz_gjc = UIId_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.userGender_zch_hwz_gjc = userGender_zch_hwz_gjc;
        this.userHeadId_zch_hwz_gjc = userHeadId_zch_hwz_gjc;
        this.userBirthday_zch_hwz_gjc = userBirthday_zch_hwz_gjc;
        this.userSignature_zch_hwz_gjc = userSignature_zch_hwz_gjc;
        this.idCardType_zch_hwz_gjc = idCardType_zch_hwz_gjc;
        this.idCardNumber_zch_hwz_gjc = idCardNumber_zch_hwz_gjc;
        this.authenticationStatus_zch_hwz_gjc = authenticationStatus_zch_hwz_gjc;
        this.authenticationTime_zch_hwz_gjc = authenticationTime_zch_hwz_gjc;
    }
}
