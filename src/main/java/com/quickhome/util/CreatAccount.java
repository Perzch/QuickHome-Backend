package com.quickhome.util;

import java.util.Random;

public class CreatAccount {
    public long creatAccount() {
        int min_zch_hwz_gjc = 1000000;
        int max_zch_hwz_gjc = 99999999;
        Random random_zch_hwz_gjc = new Random();
        int DynamicDoorPassword_zch_hwz_gjc = random_zch_hwz_gjc.nextInt(max_zch_hwz_gjc - min_zch_hwz_gjc + 1) + min_zch_hwz_gjc;
        return DynamicDoorPassword_zch_hwz_gjc;
    }
}
