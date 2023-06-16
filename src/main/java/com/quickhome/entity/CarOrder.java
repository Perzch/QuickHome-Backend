package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarOrder {
    private long orderID_zch_hwz_gjc;
    private long userID_zch_hwz_gjc;
    private long carID_zch_hwz_gjc;
    private long driverID_zch_hwz_gjc;
    private Date orderTime_zch_hwz_gjc;
    private String orderStatus_zch_hwz_gjc;
    private double orderAmount_zch_hwz_gjc;
    private long tripRecordID_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public CarOrder(long orderID_zch_hwz_gjc, long userID_zch_hwz_gjc, long carID_zch_hwz_gjc, long driverID_zch_hwz_gjc, Date orderTime_zch_hwz_gjc, String orderStatus_zch_hwz_gjc, double orderAmount_zch_hwz_gjc, long tripRecordID_zch_hwz_gjc) {
        this.orderID_zch_hwz_gjc = orderID_zch_hwz_gjc;
        this.userID_zch_hwz_gjc = userID_zch_hwz_gjc;
        this.carID_zch_hwz_gjc = carID_zch_hwz_gjc;
        this.driverID_zch_hwz_gjc = driverID_zch_hwz_gjc;
        this.orderTime_zch_hwz_gjc = orderTime_zch_hwz_gjc;
        this.orderStatus_zch_hwz_gjc = orderStatus_zch_hwz_gjc;
        this.orderAmount_zch_hwz_gjc = orderAmount_zch_hwz_gjc;
        this.tripRecordID_zch_hwz_gjc = tripRecordID_zch_hwz_gjc;
    }
}
