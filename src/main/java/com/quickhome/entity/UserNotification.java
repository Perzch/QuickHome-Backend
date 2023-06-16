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
public class UserNotification {
    private long userNotificationId_zch_hwz_gjc;
    private Date notificationReleaseTime_zch_hwz_gjc;
    private long notifyPostManager_zch_hwz_gjc;
    private String notificationContent_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public UserNotification(long userNotificationId_zch_hwz_gjc, Date notificationReleaseTime_zch_hwz_gjc, long notifyPostManager_zch_hwz_gjc, String notificationContent_zch_hwz_gjc) {
        this.userNotificationId_zch_hwz_gjc = userNotificationId_zch_hwz_gjc;
        this.notificationReleaseTime_zch_hwz_gjc = notificationReleaseTime_zch_hwz_gjc;
        this.notifyPostManager_zch_hwz_gjc = notifyPostManager_zch_hwz_gjc;
        this.notificationContent_zch_hwz_gjc = notificationContent_zch_hwz_gjc;
    }
}
