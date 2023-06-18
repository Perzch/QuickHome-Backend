package com.quickhome.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("tab_homeInformation_zch_hwz_gjc")
public class HomeInformation {
    @TableId(value = "homeId_zch_hwz_gjc")
    private long homeId_zch_hwz_gjc;
    @TableField(value = "homeName_zch_hwz_gjc")
    private String homeName_zch_hwz_gjc;
    @TableField(value = "homeType_zch_hwz_gjc")
    private String homeType_zch_hwz_gjc;
    @TableField(value = "homeArea_zch_hwz_gjc")
    private float homeArea_zch_hwz_gjc;
    @TableField(value = "homeDescribe_zch_hwz_gjc")
    private String homeDescribe_zch_hwz_gjc;
    @TableField(value = "maxPerson_zch_hwz_gjc")
    private int maxPerson_zch_hwz_gjc;
    @TableField(value = "homeFacilities_zch_hwz_gjc")
    private String homeFacilities_zch_hwz_gjc;
    @TableField(value = "homeDayRent_zch_hwz_gjc")
    private BigDecimal homeDayRent_zch_hwz_gjc;
    @TableField(value = "homeDeposit_zch_hwz_gjc")
    private BigDecimal homeDeposit_zch_hwz_gjc;
    @TableField(value = "homeState_zch_hwz_gjc")
    private String homeState_zch_hwz_gjc;
    @TableField(value = "homeAddress_zch_hwz_gjc")
    private String homeAddress_zch_hwz_gjc;
    @TableField(value = "homeInDate_zch_hwz_gjc")
    private Date homeInDate_zch_hwz_gjc;
    @TableField(value = "standby1_zch_hwz_gjc")
    private String standby1_zch_hwz_gjc;
    @TableField(value = "standby2_zch_hwz_gjc")
    private String standby2_zch_hwz_gjc;
    @TableField(value = "standby3_zch_hwz_gjc")
    private String standby3_zch_hwz_gjc;
    @TableField(value = "visible_zch_hwz_gjc")
    private int visible_zch_hwz_gjc;

    public HomeInformation(long homeId_zch_hwz_gjc, String homeName_zch_hwz_gjc, String homeType_zch_hwz_gjc, float homeArea_zch_hwz_gjc, String homeDescribe_zch_hwz_gjc, int maxPerson_zch_hwz_gjc, String homeFacilities_zch_hwz_gjc, BigDecimal homeDayRent_zch_hwz_gjc, BigDecimal homeDeposit_zch_hwz_gjc, String homeState_zch_hwz_gjc, String homeAddress_zch_hwz_gjc, Date homeInDate_zch_hwz_gjc) {
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.homeName_zch_hwz_gjc = homeName_zch_hwz_gjc;
        this.homeType_zch_hwz_gjc = homeType_zch_hwz_gjc;
        this.homeArea_zch_hwz_gjc = homeArea_zch_hwz_gjc;
        this.homeDescribe_zch_hwz_gjc = homeDescribe_zch_hwz_gjc;
        this.maxPerson_zch_hwz_gjc = maxPerson_zch_hwz_gjc;
        this.homeFacilities_zch_hwz_gjc = homeFacilities_zch_hwz_gjc;
        this.homeDayRent_zch_hwz_gjc = homeDayRent_zch_hwz_gjc;
        this.homeDeposit_zch_hwz_gjc = homeDeposit_zch_hwz_gjc;
        this.homeState_zch_hwz_gjc = homeState_zch_hwz_gjc;
        this.homeAddress_zch_hwz_gjc = homeAddress_zch_hwz_gjc;
        this.homeInDate_zch_hwz_gjc = homeInDate_zch_hwz_gjc;
    }
}
