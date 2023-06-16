package com.quickhome.util;

import java.util.Random;

public final class CreatAccount {
    public static long creatAccount() {
        int min_zch_hwz_gjc = 1000000;
        int max_zch_hwz_gjc = 99999999;
        Random random_zch_hwz_gjc = new Random();
        return random_zch_hwz_gjc.nextInt(max_zch_hwz_gjc - min_zch_hwz_gjc + 1) + min_zch_hwz_gjc;
    }
}
