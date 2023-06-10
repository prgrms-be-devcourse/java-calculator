package com.programmers.exception;

public class EquationFormatException extends RuntimeException {
    private static final String MSG = "성립할 수 없는 식입니다.";

    public EquationFormatException() {
        super(MSG);
    }
}
