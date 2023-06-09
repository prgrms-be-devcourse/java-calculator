package com.programmers.util;

public interface Arithmetic {

    String WRONG_EXPRESSION = "올바른 계산식을 입력해주세요.";

    static boolean isNumber(String input) {
        return input.matches("[0-9]+");
    }

    static boolean isOperator(String input) {
        return input.matches("[+\\-*/]");
    }
}
