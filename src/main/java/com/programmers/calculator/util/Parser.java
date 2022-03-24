package com.programmers.calculator.util;

public class Parser {
    public static String[] parse(String str) {
        return str.trim().replace(" ", "").split("(?<=[()*/+-])|(?=[()*/+-])");
    }
}
