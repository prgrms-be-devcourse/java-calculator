package com.devcourse.java.calculator.validator;

import com.devcourse.java.calculator.constant.ExceptionMessageConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Optional;

public final class equationValidator {

    private equationValidator() {}

    public static void checkEquationInput(Optional<String> input) {
        throwIfEquationIsEmpty(input);
        String equation = input.get();

        ArrayList<String> tokens = new ArrayList<>(Arrays.asList(equation.split(" ")));

        throwIfTokenIsEmpty(tokens);
        throwIfEquationStartWithNoInteger(tokens);
        throwIfEquationEndWithNoInteger(tokens);
        throwIfEquationIsWrong(tokens);
    }

    public static void throwIfEquationIsEmpty(Optional<String> equation) {
        if (equation.isEmpty()) {
            throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }

    private static void throwIfTokenIsEmpty(ArrayList<String> tokens) {
        if (tokens.isEmpty()) {
            throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }

    private static void throwIfEquationStartWithNoInteger(ArrayList<String> tokens) {
        if (!typeValidator.isInteger(tokens.get(0))) {
            throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }

    private static void throwIfEquationEndWithNoInteger(ArrayList<String> tokens) {
        if (!typeValidator.isInteger(tokens.get(tokens.size() - 1))) {
            throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
        }
    }

    public static void throwIfEquationIsWrong(ArrayList<String> tokens) {
        int digit = 0;
        int operation = 0;
        boolean continuedOperation = true;

        for (String eachToken: tokens) {
            if (typeValidator.isInteger(eachToken)) {
                if (!continuedOperation) {
                    throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
                }
                digit += 1;
                continuedOperation = false;
            } else if (!typeValidator.isInteger(eachToken)) {
                if (continuedOperation) {
                    throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
                }
                operation += 1;
                continuedOperation = true;
            } else {
                throw new InputMismatchException(ExceptionMessageConstant.WRONG_EQUATION_INPUT_EXCEPTION);
            }
        }
    }

}
