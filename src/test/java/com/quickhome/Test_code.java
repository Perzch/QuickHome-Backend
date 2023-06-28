package com.quickhome;

import com.quickhome.util.CreatCode;

/**
 * @author Tim-h
 * @description
 * @creatDate 2023/6/28 15:21
 */
public class Test_code {
    public static void main(String[] args) {
        String code= CreatCode.creatCode("number");
        String code2= CreatCode.creatCode("chat");
        System.out.println(code);
        System.out.println(code2);
    }
}
