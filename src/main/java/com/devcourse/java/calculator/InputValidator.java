package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.ExceptionConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;

public class InputValidator {

    public static void checkCommandInput(String input) {
        if (!isInteger(input)) {
            throw new InputMismatchException(ExceptionConstant.COMMAND_INPUT_NOT_INTEGER_EXCEPTION);
        }

        if (!isInBoundary(input)) {
            throw new InputMismatchException(ExceptionConstant.COMMAND_INPUT_NOT_IN_BOUNDARY_EXCEPTION);
        }
    }

    public static boolean isInteger(String input) {
        return input.matches("^?\\d*$");
    }

    public static boolean isInBoundary(String input) {
        int command = Integer.parseInt(input);
        return (command >= 1 && command <= 3);
    }

    public static boolean isOperator(String token) {
        return token.matches("^[\\+\\-\\*\\/]$");
    }

    public static void checkCalculateHistoryLength(LinkedHashMap<Integer, String> calculateHistory) {
        if (calculateHistory.isEmpty()) {
            throw new IllegalArgumentException(ExceptionConstant.EMPTY_CALCULATE_HISTORY_EXCEPTION);
        }
    }

    public static void checkEquationInput(String equation) {
        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(equation.split(" ")));

        throwIfEquationIsEmpty(equation);
        throwIfEquationStartOrEndWithNoInteger(tokens);
        throwIfEquationIsWrong(tokens);
    }

    public static void throwIfEquationIsEmpty(String equation) {
        if (equation.length() == 0) {
            throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }

    public static void throwIfEquationStartOrEndWithNoInteger(ArrayList<String> tokens) {
        if (!isInteger(tokens.get(0)) || !isInteger(tokens.get(tokens.size() - 1))) {
            throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }

    public static void throwIfEquationIsWrong(ArrayList<String> tokens) {
        int digit = 0;
        int operation = 0;
        boolean continuedOperation = true;

        for (String eachToken: tokens) {

            if (isInteger(eachToken)) {
                if (!continuedOperation) {
                    throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
                }
                digit += 1;
                continuedOperation = false;
            } else if (isOperator(eachToken)) {
                if (continuedOperation) {
                    throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
                }
                operation += 1;
                continuedOperation = true;
            } else {
                throw new InputMismatchException(ExceptionConstant.WRONG_EQUATION_INPUT_EXCEPTION);
            }

        }
        
    }

}
