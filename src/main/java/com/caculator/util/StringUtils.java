package com.caculator.util;

public class StringUtils {

    public static boolean isNumber(String s) {
        try {
            Long.parseLong(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
