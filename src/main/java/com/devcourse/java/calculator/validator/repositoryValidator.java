package com.devcourse.java.calculator.validator;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;

import java.util.List;

public final class repositoryValidator {

    private repositoryValidator() {}

    public static void checkCalculateHistoryLength(List<String> history) {
        if (history.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessageConstant.EMPTY_CALCULATE_HISTORY_EXCEPTION);
        }
    }
}
