package com.quickhome;

import cn.hutool.core.date.DateTime;
import com.quickhome.util.CreatCode;

import java.time.LocalDate;

/**
 * @author Tim-h
 * @description
 * @creatDate 2023/6/28 15:21
 */
public class Test_code {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        //将String给转换成DateTime
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        System.out.println("2023-06-29".compareTo(LocalDate.now().toString()));
    }
}
