package com.calculator.common;

public class BusinessException extends RuntimeException {
    private ExceptionStatus status;

    public BusinessException(ExceptionStatus status) {
        super(status.getMessage());
        this.status = status;
    }

    public String getMessage() {
        return this.status.getMessage();
    }
}
