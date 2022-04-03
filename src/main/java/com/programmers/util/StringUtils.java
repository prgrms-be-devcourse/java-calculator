package com.programmers.util;

public class StringUtils {
    private static final String BLANK = " ";

    public static String[] splitByBlank(String inputExpression){
        return inputExpression.split(BLANK);
    }
}
