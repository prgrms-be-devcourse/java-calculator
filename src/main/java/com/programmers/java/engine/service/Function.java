package com.programmers.java.engine.service;

public interface Function {
    default boolean isStrDigit(String c) {

        for (int i = 0; i < c.length(); i++) {
            if (i == 0 && c.charAt(i) == '-')
                continue;
            if (!isDigit(c.charAt(i)))
                return false;
        }
        return true;
    }

    default boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    default boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
