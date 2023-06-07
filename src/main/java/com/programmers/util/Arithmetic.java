package com.programmers.util;

public interface Arithmetic {

    static boolean isNumber(String input) {
        return input.matches("[0-9]+");
    }

    static boolean isOperator(String input) {
        return input.matches("[+\\-*/]?");
    }
}
