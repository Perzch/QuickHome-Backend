package com.quickhome.entity;

import lombok.Data;

@Data
public class HomeImage_zch_hwz_gjc {
    private long imageId_zch_hwz_gjc;
    private long homeId_zch_hwz_gjc;
    private String imagePath_zch_hwz_gjc;
    private String inDateTime_zch_hwz_gjc;
    private String standby1_zch_hwz_gjc;
    private String standby2_zch_hwz_gjc;
    private String standby3_zch_hwz_gjc;
    private int visible_zch_hwz_gjc;

    public HomeImage_zch_hwz_gjc(long imageId_zch_hwz_gjc, long homeId_zch_hwz_gjc, String imagePath_zch_hwz_gjc, String inDateTime_zch_hwz_gjc, String standby1_zch_hwz_gjc, String standby2_zch_hwz_gjc, String standby3_zch_hwz_gjc, int visible_zch_hwz_gjc) {
        this.imageId_zch_hwz_gjc = imageId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.imagePath_zch_hwz_gjc = imagePath_zch_hwz_gjc;
        this.inDateTime_zch_hwz_gjc = inDateTime_zch_hwz_gjc;
        this.standby1_zch_hwz_gjc = standby1_zch_hwz_gjc;
        this.standby2_zch_hwz_gjc = standby2_zch_hwz_gjc;
        this.standby3_zch_hwz_gjc = standby3_zch_hwz_gjc;
        this.visible_zch_hwz_gjc = visible_zch_hwz_gjc;
    }

    public HomeImage_zch_hwz_gjc(long imageId_zch_hwz_gjc, long homeId_zch_hwz_gjc, String imagePath_zch_hwz_gjc, String inDateTime_zch_hwz_gjc) {
        this.imageId_zch_hwz_gjc = imageId_zch_hwz_gjc;
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
        this.imagePath_zch_hwz_gjc = imagePath_zch_hwz_gjc;
        this.inDateTime_zch_hwz_gjc = inDateTime_zch_hwz_gjc;
    }

    public long getImageId_zch_hwz_gjc() {
        return imageId_zch_hwz_gjc;
    }

    public void setImageId_zch_hwz_gjc(long imageId_zch_hwz_gjc) {
        this.imageId_zch_hwz_gjc = imageId_zch_hwz_gjc;
    }

    public long getHomeId_zch_hwz_gjc() {
        return homeId_zch_hwz_gjc;
    }

    public void setHomeId_zch_hwz_gjc(long homeId_zch_hwz_gjc) {
        this.homeId_zch_hwz_gjc = homeId_zch_hwz_gjc;
    }

    public String getImagePath_zch_hwz_gjc() {
        return imagePath_zch_hwz_gjc;
    }

    public void setImagePath_zch_hwz_gjc(String imagePath_zch_hwz_gjc) {
        this.imagePath_zch_hwz_gjc = imagePath_zch_hwz_gjc;
    }

    public String getInDateTime_zch_hwz_gjc() {
        return inDateTime_zch_hwz_gjc;
    }

    public void setInDateTime_zch_hwz_gjc(String inDateTime_zch_hwz_gjc) {
        this.inDateTime_zch_hwz_gjc = inDateTime_zch_hwz_gjc;
    }

    public String getStandby1_zch_hwz_gjc() {
        return standby1_zch_hwz_gjc;
    }

    public void setStandby1_zch_hwz_gjc(String standby1_zch_hwz_gjc) {
        this.standby1_zch_hwz_gjc = standby1_zch_hwz_gjc;
    }

    public String getStandby2_zch_hwz_gjc() {
        return standby2_zch_hwz_gjc;
    }

    public void setStandby2_zch_hwz_gjc(String standby2_zch_hwz_gjc) {
        this.standby2_zch_hwz_gjc = standby2_zch_hwz_gjc;
    }

    public String getStandby3_zch_hwz_gjc() {
        return standby3_zch_hwz_gjc;
    }

    public void setStandby3_zch_hwz_gjc(String standby3_zch_hwz_gjc) {
        this.standby3_zch_hwz_gjc = standby3_zch_hwz_gjc;
    }

    public int getVisible_zch_hwz_gjc() {
        return visible_zch_hwz_gjc;
    }

    public void setVisible_zch_hwz_gjc(int visible_zch_hwz_gjc) {
        this.visible_zch_hwz_gjc = visible_zch_hwz_gjc;
    }

    @Override
    public String toString() {
        return "HomeImage_zch_gjc_hwz{" +
                "imageId_zch_hwz_gjc=" + imageId_zch_hwz_gjc +
                ", homeId_zch_hwz_gjc=" + homeId_zch_hwz_gjc +
                ", imagePath_zch_hwz_gjc='" + imagePath_zch_hwz_gjc + '\'' +
                ", inDateTime_zch_hwz_gjc='" + inDateTime_zch_hwz_gjc + '\'' +
                ", standby1_zch_hwz_gjc='" + standby1_zch_hwz_gjc + '\'' +
                ", standby2_zch_hwz_gjc='" + standby2_zch_hwz_gjc + '\'' +
                ", standby3_zch_hwz_gjc='" + standby3_zch_hwz_gjc + '\'' +
                ", visible_zch_hwz_gjc=" + visible_zch_hwz_gjc +
                '}';
    }
}

