package com.quickhome.util;

import java.util.Random;

public final class DynamicDoorPassword {
    public static Integer dynamicDoorPassword(){
        int minDynamicDoorPassword = 100000;
        int maxDynamicDoorPassword = 999999;
        Random randomDynamicDoorPassword = new Random();
        return randomDynamicDoorPassword.nextInt(maxDynamicDoorPassword - minDynamicDoorPassword + 1) + minDynamicDoorPassword;
    }
}
