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
public class UserHeadImage {
    private long userImageId_zch_hwz_gjc;
    private long userId_zch_hwz_gjc;
    private String imagePath_zch_hwz_gjc;
    private Date inDateTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public UserHeadImage(long userImageId_zch_hwz_gjc, long userId_zch_hwz_gjc, String imagePath_zch_hwz_gjc, Date inDateTime_zch_hwz_gjc) {
        this.userImageId_zch_hwz_gjc = userImageId_zch_hwz_gjc;
        this.userId_zch_hwz_gjc = userId_zch_hwz_gjc;
        this.imagePath_zch_hwz_gjc = imagePath_zch_hwz_gjc;
        this.inDateTime_zch_hwz_gjc = inDateTime_zch_hwz_gjc;
    }
}
