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
public class Order {
    private Long orderId_zch_hwz_gjc;
    private Long homeId_zch_hwz_gjc;
    private String DynamicDoorPassword_zch_hwz_gjc;
    private Date creationTime_zch_hwz_gjc;
    private Date endTime_zch_hwz_gjc;
    private Date checkInTime_zch_hwz_gjc;
    private Date checkOutTime_zch_hwz_gjc;
    private BigDecimal orderPayment_zch_hwz_gjc;
    private BigDecimal orderDeposit_zch_hwz_gjc;
    private String maintainStatus_zch_hwz_gjc;
    private String orderState_zch_hwz_gjc;
    private Long userId_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public Order(Long orderId_zch_hwz_gjc, Long homeId_zch_hwz_gjc, String dynamicDoorPassword_zch_hwz_gjc, Date creationTime_zch_hwz_gjc, Date endTime_zch_hwz_gjc, Date checkInTime_zch_hwz_gjc, Date checkOutTime_zch_hwz_gjc, BigDecimal orderPayment_zch_hwz_gjc, BigDecimal orderDeposit_zch_hwz_gjc, String maintainStatus_zch_hwz_gjc, String orderState_zch_hwz_gjc, Long userId_zch_hwz_gjc) {
        this.orderId_zch_hwz_gjc = orderId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        DynamicDoorPassword_zch_hwz_gjc = dynamicDoorPassword_zch_hwz_gjc;
        this.creationTime_zch_hwz_gjc = creationTime_zch_hwz_gjc;
        this.endTime_zch_hwz_gjc = endTime_zch_hwz_gjc;
        this.checkInTime_zch_hwz_gjc = checkInTime_zch_hwz_gjc;
        this.checkOutTime_zch_hwz_gjc = checkOutTime_zch_hwz_gjc;
        this.orderPayment_zch_hwz_gjc = orderPayment_zch_hwz_gjc;
        this.orderDeposit_zch_hwz_gjc = orderDeposit_zch_hwz_gjc;
        this.maintainStatus_zch_hwz_gjc = maintainStatus_zch_hwz_gjc;
        this.orderState_zch_hwz_gjc = orderState_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
    }
}
