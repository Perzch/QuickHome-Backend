package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    Long orderId_zch_hwz_gjc;
    Long homeId_zch_hwz_gjc;
    String DynamicDoorPassword_zch_hwz_gjc;
    Date creationTime_zch_hwz_gjc;
    Date endTime_zch_hwz_gjc;
    Date checkInTime_zch_hwz_gjc;
    Date checkOutTime_zch_hwz_gjc;
    Double orderPayment_zch_hwz_gjc;
    Double orderDeposit_zch_hwz_gjc;
    String maintainStatus_zch_hwz_gjc;
    String orderState_zch_hwz_gjc;
    Long userId_zch_hwz_gjc;
    String standby1_zch_hwz_gjc;
    String standby2_zch_hwz_gjc;
    String standby3_zch_hwz_gjc;
    int visible_zch_hwz_gjc;
}
