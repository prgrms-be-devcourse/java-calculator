package com.programmers.util;

public class StringUtils {
    private static final String BLANK = " ";

    private StringUtils() {

    }

    public static String[] splitByBlank(String inputExpression){
        return inputExpression.split(BLANK);
    }
}
