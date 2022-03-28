package com.calculator.java.exception;

public class TerminationException extends RuntimeException{
    public TerminationException() {
    }

    public TerminationException(String message) {
        super(message);
    }

    public TerminationException(String message, Throwable cause) {
        super(message, cause);
    }

    public TerminationException(Throwable cause) {
        super(cause);
    }

    public TerminationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
