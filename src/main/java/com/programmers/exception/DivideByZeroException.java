package com.programmers.exception;

public class DivideByZeroException extends RuntimeException {
    private static final String MSG = "0으로 나눌 수 없습니다.";

    public DivideByZeroException() {
        super(MSG);
    }
}
