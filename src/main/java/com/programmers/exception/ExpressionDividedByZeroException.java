package com.programmers.exception;

public class ExpressionDividedByZeroException extends IllegalArgumentException {

    private static final String EXPRESSION_DIVIDED_ZERO_ERROR_MESSAGE = "\n[ERROR] 0으로 나누는 계산식은 입력할 수 없습니다.";

    public ExpressionDividedByZeroException() {
        super(EXPRESSION_DIVIDED_ZERO_ERROR_MESSAGE);
    }
}
