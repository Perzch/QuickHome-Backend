package com.quickhome.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeImage {
    private long imageId_zch_hwz_gjc;
    private long homeId_zch_hwz_gjc;
    private String imagePath_zch_hwz_gjc;
    private String inDateTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;


    public HomeImage(long imageId_zch_hwz_gjc, long homeId_zch_hwz_gjc, String imagePath_zch_hwz_gjc, String inDateTime_zch_hwz_gjc) {
        this.imageId_zch_hwz_gjc = imageId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.imagePath_zch_hwz_gjc = imagePath_zch_hwz_gjc;
        this.inDateTime_zch_hwz_gjc = inDateTime_zch_hwz_gjc;
    }


}

