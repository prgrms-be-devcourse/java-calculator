package com.calculator.common;

import java.util.regex.Pattern;

import static com.calculator.common.ExceptionStatus.*;

public class ValidatorHandler {

    private static final String EXPRESSION_PATTERN = "^[+\\-*/()\\d]*$";

    /**
     * num, operator error
     */
    public void inputError(String input) {
        if (!Pattern.matches(EXPRESSION_PATTERN, input)) {
            throw new BusinessException(NOT_NUM_ERROR);
        }
    }
}
