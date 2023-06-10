package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.ExceptionConstant;

import java.util.InputMismatchException;
import java.util.LinkedHashMap;

public class InputValidator {

    public void checkCommandInput(String input) {
        if (!isInteger(input)) {
            throw new InputMismatchException(ExceptionConstant.COMMAND_INPUT_NOT_INTEGER_EXCEPTION);
        }

        if (!isInBoundary(input)) {
            throw new InputMismatchException(ExceptionConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);
        }
    }

    private boolean isInteger(String input) {
        return input.matches("[-0-9]+");
    }

    private boolean isInBoundary(String input) {
        int command = Integer.parseInt(input);
        return (command >= 1 && command <= 3);
    }

    public void checkCalculateHistoryLength(LinkedHashMap<Integer, String> calculateHistory) {
        if (calculateHistory.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstant.EMPTY_CALCULATE_HISTORY_EXCEPTION);
        }
    }

    public void checkEquationInput(String equation) {

    }
}
