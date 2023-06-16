package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Log {
    private long logId_zch_hwz_gjc;
    private long userPerformingId_zch_hwz_gjc;
    private Date executionTime_zch_hwz_gjc;
    private String executionContent_zch_hwz_gjc;
    private String deviceId_zch_hwz_gjc;
    private String executionPlace_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public Log(long logId_zch_hwz_gjc, long userPerformingId_zch_hwz_gjc, Date executionTime_zch_hwz_gjc, String executionContent_zch_hwz_gjc, String deviceId_zch_hwz_gjc, String executionPlace_zch_hwz_gjc) {
        this.logId_zch_hwz_gjc = logId_zch_hwz_gjc;
        this.userPerformingId_zch_hwz_gjc = userPerformingId_zch_hwz_gjc;
        this.executionTime_zch_hwz_gjc = executionTime_zch_hwz_gjc;
        this.executionContent_zch_hwz_gjc = executionContent_zch_hwz_gjc;
        this.deviceId_zch_hwz_gjc = deviceId_zch_hwz_gjc;
        this.executionPlace_zch_hwz_gjc = executionPlace_zch_hwz_gjc;
    }
}
