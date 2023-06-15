package com.programmers.util;

public class Validator {

    public static boolean isOperatorCheck(int position) {
        return (position + 1) % 2 == 0;
    }

    public static void checkEmpty(String[] splitFormula) {
        if (isEmpty(splitFormula)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isEmpty(String[] list) {
        return list != null && list.length == 0;
    }

}
