package com.programmers.java.calculator.engine.exception;

public class NumberIndexException extends RuntimeException {
    public NumberIndexException() {
        super();
    }

    public NumberIndexException(String message) {
        super(message);
    }

    public NumberIndexException(String message, Throwable cause) {
        super(message, cause);
    }

    public NumberIndexException(Throwable cause) {
        super(cause);
    }
}
