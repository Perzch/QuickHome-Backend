package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarReservation {
    private long reservationID_zch_hwz_gjc;
    private long driverID_zch_hwz_gjc;
    private long userID_zch_hwz_gjc;
    private long carID_zch_hwz_gjc;
    private Date carReservationTime_zch_hwz_gjc;
    private String reservationStatus_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public CarReservation(long reservationID_zch_hwz_gjc, long driverID_zch_hwz_gjc, long userID_zch_hwz_gjc, long carID_zch_hwz_gjc, Date carReservationTime_zch_hwz_gjc, String reservationStatus_zch_hwz_gjc) {
        this.reservationID_zch_hwz_gjc = reservationID_zch_hwz_gjc;
        this.driverID_zch_hwz_gjc = driverID_zch_hwz_gjc;
        this.userID_zch_hwz_gjc = userID_zch_hwz_gjc;
        this.carID_zch_hwz_gjc = carID_zch_hwz_gjc;
        this.carReservationTime_zch_hwz_gjc = carReservationTime_zch_hwz_gjc;
        this.reservationStatus_zch_hwz_gjc = reservationStatus_zch_hwz_gjc;
    }
}
