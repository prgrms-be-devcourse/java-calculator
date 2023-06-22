package com.programmers.java.exception;

public class WrongExpressionException extends RuntimeException {
    public WrongExpressionException() {

    }
    WrongExpressionException(String message) {
        super(message);
    }

}
