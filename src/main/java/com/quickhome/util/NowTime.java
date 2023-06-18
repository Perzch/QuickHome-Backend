package com.quickhome.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public final class NowTime {
    public static Date getNowTime(){
        LocalDateTime now_zch_hwz_gjc = LocalDateTime.now();
        DateTimeFormatter formatter_zch_hwz_gjc = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String creationTimeString_zch_hwz_gjc = now_zch_hwz_gjc.format(formatter_zch_hwz_gjc);
        return java.sql.Timestamp.valueOf(creationTimeString_zch_hwz_gjc);
    }
}
