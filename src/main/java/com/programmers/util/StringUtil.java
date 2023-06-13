package com.programmers.util;

public class StringUtil {
    private static final String NUMBER_REGEX = "-?\\d+(\\.\\d+)?";

    public static boolean isNumber(String unCheckedToken) {
        return unCheckedToken.matches(NUMBER_REGEX);
    }

    public static long convertStringToLong(String token) {
        return Long.parseLong(token);
    }
}
