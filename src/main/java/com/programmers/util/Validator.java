package com.programmers.util;

public class Validator {

    public static boolean isOperatorCheck(int position) {
        return (position + 1) % 2 == 0;
    }

    public static void checkEmpty(String[] splitFormula) {
        if (isEmpty(splitFormula)) ;
    }

    private static boolean isEmpty(String[] splitFormula) {
        return splitFormula != null && splitFormula.length == 0;
    }

}
