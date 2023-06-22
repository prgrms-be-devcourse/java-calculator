package com.devcourse.java.calculator.validator;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;
import com.devcourse.java.calculator.repository.History;

import java.util.List;

public final class repositoryValidator {

    private repositoryValidator() {}

    public static void checkCalculateHistoryLength(List<History> history) {
        if (history.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessageConstant.EMPTY_CALCULATE_HISTORY_EXCEPTION);
        }
    }
}
