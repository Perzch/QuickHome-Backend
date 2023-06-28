package com.quickhome.util;

import java.util.Random;

/**
 * @author Tim-h
 * @description 创建验证码，带参数，number为纯数字，char为字符
 * @creatDate 2023/6/28 15:09
 */

public final class CreatCode {
    public static String creatCode(String type) {
        String[] code_map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
        String[] code_map_number = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        Random randomCode = new Random();
        String code = "";
        if(type.equals("number")){
            for (int i = 0; i < 6; i++) {
                code += code_map_number[randomCode.nextInt(code_map_number.length)];
            }
        }else if (type.equals("char")){
            for (int i = 0; i < 6; i++) {
                code += code_map[randomCode.nextInt(code_map.length)];
            }
        }
        return code;
    }
}
