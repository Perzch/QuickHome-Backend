package com.quickhome.util;

import java.util.Random;

public final class DynamicDoorPassword {
    public static String dynamicDoorPassword(){
        String[] code_map_number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random randomCode = new Random();
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += code_map_number[randomCode.nextInt(code_map_number.length)];
        }
        return code;
    }
}
