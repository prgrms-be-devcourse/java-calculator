package com.programmers.error;

public class CalculatorException extends RuntimeException {
    public CalculatorException(ErrorMessage errorMessage) {
        super(errorMessage.getMessage());
    }
}