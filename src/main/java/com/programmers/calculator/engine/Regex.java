package com.programmers.calculator.engine;

// 정규식
public class Regex {
    private static final String numRegex = "^-?[0-9]*$";

    public static String getNumRegex() {
        return numRegex;
    }
}