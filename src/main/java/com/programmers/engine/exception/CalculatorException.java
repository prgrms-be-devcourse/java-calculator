package com.programmers.engine.exception;

public class CalculatorException extends RuntimeException {

    private CalculatorErrorCode errorCode;

    public CalculatorException(CalculatorErrorCode errorCode) {
        super(errorCode.getErrorMessage());
        this.errorCode = errorCode;
    }
}
