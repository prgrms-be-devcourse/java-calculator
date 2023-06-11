package com.wonu606.calculator.util;

public enum CalculatorMessage {
    INVALID_ORDER("잘못된 순번입니다."),
    INVALID_INPUT("잘못된 입력입니다.");

    public final String message;

    CalculatorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
