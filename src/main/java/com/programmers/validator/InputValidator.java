package com.programmers.validator;

import com.programmers.exception.EquationFormatException;
import com.programmers.exception.MenuFormatException;

public class InputValidator {

    private static final String operators = "+-*/()";
    private static final String pattern = "[0-9]+";

    public static void checkEquation(String request) {
        String result = request.replaceAll(pattern, "");
        for (int i = 0; i < result.length(); i++) {
            if (!isOperator(String.valueOf(result.charAt(i)))) {
                throw new EquationFormatException();
            }
        }
    }

    public static void isEmpty(String request) {
        if (request == null || request.isBlank()) {
            throw new MenuFormatException();
        }
    }

    public static boolean isOperator(String oper) {
        return operators.contains(oper);
    }
}
