package com.programmers.calculator.exception.validation;

public class FormulaValidationException extends ValidationException {
    private static final long serialVersionUID = 5175500593871389828L;
    private static final String MESSAGE = "올바르지 않은 식 입니다.";

    public FormulaValidationException() {
        super(MESSAGE);
    }
}
