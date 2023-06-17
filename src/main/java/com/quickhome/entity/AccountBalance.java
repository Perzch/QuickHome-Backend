package com.quickhome.entity;

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
public class AccountBalance {
    private long bid_zch_hwz_gjc;
    private long userId_zch_hwz_hjc;
    private BigDecimal userBalance_zch_hwz_gjc;
    private BigDecimal userDeposit_zch_hwz_gjc;
    private Date lastModifiedDate_zch_hwz_gjc;
    private Date openTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public AccountBalance(long bid_zch_hwz_gjc, long userId_zch_hwz_hjc, BigDecimal userBalance_zch_hwz_gjc, BigDecimal userDeposit_zch_hwz_gjc, Date lastModifiedDate_zch_hwz_gjc, Date openTime_zch_hwz_gjc) {
        this.bid_zch_hwz_gjc = bid_zch_hwz_gjc;
        this.userId_zch_hwz_hjc = userId_zch_hwz_hjc;
        this.userBalance_zch_hwz_gjc = userBalance_zch_hwz_gjc;
        this.userDeposit_zch_hwz_gjc = userDeposit_zch_hwz_gjc;
        this.lastModifiedDate_zch_hwz_gjc = lastModifiedDate_zch_hwz_gjc;
        this.openTime_zch_hwz_gjc = openTime_zch_hwz_gjc;
    }
}
