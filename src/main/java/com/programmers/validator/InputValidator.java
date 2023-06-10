package com.programmers.validator;

import com.programmers.exception.EquationFormatException;
import com.programmers.exception.MenuFormatException;

public class InputValidator {

    private static final String operators = "+-*/()";
    private static final String operator = "+-*/";
    private static final String pattern = "[0-9]+";

    public static void checkEquation(String equation) {
        if (endByOperator(equation)) {
            throw new EquationFormatException();
        }

        if (continuousOp(equation)) {
            throw new EquationFormatException();
        }

        if (checkOperator(equation)) {
            throw new EquationFormatException();
        }

    }

    public static void checkRequest(String request) {
        if (request == null || request.isBlank()) {
            throw new MenuFormatException();
        }
    }

    public static boolean isOperator(String oper) {
        return operators.contains(oper);
    }

    public static boolean endByOperator(String equation) {
        String[] equationArr = equation.split("");
        if (operator.contains(equationArr[equationArr.length-1])) return true;
        return false;
    }

    public static boolean continuousOp(String equation) {
        String[] equationArr = equation.split("");
        for (int i = 0; i < equationArr.length-1; i++) {
            String cur = equationArr[i];
            String next = equationArr[i+1];

            if (operator.contains(cur) && operator.contains(next)) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkOperator(String _equation) {
        String equation = _equation.replaceAll(pattern, "");
        String[] equationArr = equation.split("");
        for (int i = 0; i < equationArr.length; i++) {
            if (!operators.contains(equationArr[i])) {
                return true;
            }
        }
        return false;
    }
}
