package com.wonu606.calculator.util;

public enum CalculatorMessage {
    INVALID_ORDER("잘못된 순번입니다."),
    INVALID_INPUT("잘못된 입력입니다."),
    NOT_DIVISIBLE_BY_ZERO("0으로 나눌 수 없습니다.");

    public final String message;

    CalculatorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
