package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyChat {
    private long chatId_zch_hwz_gjc;
    private long messageReceive_zch_hwz_gjc;
    private String messageContent_zch_hwz_gjc;
    private long messageSender_zch_hwz_gjc;
    private long conversationDialogId_zch_hwz_gjc;
    private Date sendingTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;
}
