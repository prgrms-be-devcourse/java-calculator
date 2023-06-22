package org.devcourse.util;

public class DigitChecker {

    // 숫자인지 확인
    public static boolean isDigit(String value) {

        try {

            Double.parseDouble(value);
            return true;

        } catch (NumberFormatException e) {

            return false;
        }
    }


    // 정수인지 확인
    public static boolean isInteger(double num) {
        return num % 1 == 0.0;
    }


}
