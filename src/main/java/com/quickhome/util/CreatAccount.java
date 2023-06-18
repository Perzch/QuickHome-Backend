package com.quickhome.util;

import java.util.Random;

public final class CreatAccount {
    public static long creatAccount() {
        int minAccount = 1000000;
        int maxAccount = 99999999;
        Random randomAccount = new Random();
        return randomAccount.nextInt(maxAccount - minAccount + 1) + minAccount;
    }
}
