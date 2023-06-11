package com.programmers.converter;

public class ResultConverter {

    private ResultConverter() {
    }

    public static String convertResult(String calc) {
        int commaIndex = calc.indexOf('.');
        if (isDecimalPlaceOverTen(calc, commaIndex)) {
            return calc.substring(0, commaIndex + 11);
        }

        return calc;
    }

    private static boolean isDecimalPlaceOverTen(String calc, int commaIndex) {
        int decimalPlace = calc.substring(commaIndex + 1).length();
        return decimalPlace >= 10;
    }
}
