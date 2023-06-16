package com.quickhome.util;

import java.util.Random;

public final class DynamicDoorPassword {
    public static Integer dynamicDoorPassword(){
        int min_zch_hwz_gjc = 100000;
        int max_zch_hwz_gjc = 999999;
        Random random_zch_hwz_gjc = new Random();
        return random_zch_hwz_gjc.nextInt(max_zch_hwz_gjc - min_zch_hwz_gjc + 1) + min_zch_hwz_gjc;
    }
}
