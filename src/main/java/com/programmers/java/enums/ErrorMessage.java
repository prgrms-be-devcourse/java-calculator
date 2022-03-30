package com.programmers.java.enums;

public enum ErrorMessage {
    INVALID_MENU_INPUT("선택한 숫자값이 유효하지 않습니다."),
    EMPTY_INPUT("빈 계산식이 입력되었습니다."),
    INVALID_FORMULA("유효한 계산식이 아닙니다."),
    INVALID_OPERAND("피연산자(숫자)가 잘못되었습니다."),
    INVALID_OPERATOR("연산자가 잘못되었습니다. +, -, *, / 연산자만 입력해주세요."),
    NOT_DIVIDE_ZERO("0으로 나눌 수 없습니다.");

    private String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
