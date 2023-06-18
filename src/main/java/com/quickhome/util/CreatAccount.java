package com.quickhome.util;

import java.util.Random;

public final class CreatAccount {
    public static long creatAccount() {
        int minAccount = 1000000;
        int maxAccount = 99999999;
        Random random_zch_hwz_gjc = new Random();
        return random_zch_hwz_gjc.nextInt(maxAccount - minAccount + 1) + minAccount;
    }
}
