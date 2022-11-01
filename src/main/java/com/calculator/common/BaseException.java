package com.calculator.common;

public class BaseException extends Exception {
    private ExceptionStatus status;

    public BaseException(ExceptionStatus status) {
        this.status = status;
    }

    public ExceptionStatus getStatus() {
        return status;
    }
}
