package com.programmers.java.engine.service.utils;

public class Function {
    public static boolean isStrDigit(String c) {

        for (int i = 0; i < c.length(); i++) {
            if (i == 0 && c.charAt(i) == '-') {
                if (c.length() == 1)
                    return false;
            }
            else if (!isDigit(c.charAt(i)))
                return false;
        }
        return true;
    }

    public static  boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static  boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
