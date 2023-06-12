package com.programmers.util;

public class StringUtil {
    public static boolean isNumber(String unCheckedNumber) {
        try {
            convertStringToLong(unCheckedNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static long convertStringToLong(String unCheckedNumOrOperator) {
        return Long.parseLong(unCheckedNumOrOperator);
    }
}
