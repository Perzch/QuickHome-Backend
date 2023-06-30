package com.quickhome;

import cn.hutool.core.date.DateTime;
import com.quickhome.util.CreatCode;
import org.junit.Test;

import java.sql.Date;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

/**
 * @author Tim-h
 * @description 一般的测试接口
 * @creatDate 2023/6/28 15:21
 */
public class Test_code {
    @Test
    public void test() {
        LocalDate now = LocalDate.now();
        //将String给转换成DateTime
        LocalDate date = LocalDate.now();
        System.out.println(date.toString());
        System.out.println("2023-06-29".compareTo(LocalDate.now().toString()));
    }

    @Test
    public void test2() {
        String checkInDate = "2023-06-29";
        String checkOutDate = "2023-06-30";
        Date checkIn, checkOut;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        checkIn = sdf.parse(checkInDate);
//        checkOut = sdf.parse(checkOutDate);
        checkIn = Date.valueOf(checkInDate);
        checkOut = Date.valueOf(checkOutDate);
        long date = checkOut.getTime() - checkIn.getTime();
        String day = String.valueOf(date / (24 * 60 * 60 * 1000));
        System.out.println(day);
        System.out.println(checkOut.getDay() - checkIn.getDay());
    }
}
