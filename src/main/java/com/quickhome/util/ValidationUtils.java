package com.quickhome.util;

/**
 * @author ButterflyX
 * @description
 * @creatDate 2023/11/16 19:22
 */
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ValidationUtils {

    private static final Pattern ID_CARD_PATTERN = Pattern.compile("^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(1[0-2]))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^1(3\\d|4[5-9]|5[0-35-9]|6[2567]|7[0-8]|8\\d|9[0-35-9])\\d{8}$");

    public static boolean isValidIdCard(String idCard) {
        Matcher matcher = ID_CARD_PATTERN.matcher(idCard);
        return matcher.matches();
    }

    public static boolean isValidPhone(String phone) {
        Matcher matcher = PHONE_PATTERN.matcher(phone);
        return matcher.matches();
    }
}
