package com.programmers.validator;

import com.programmers.exception.EquationFormatException;
import com.programmers.exception.MenuFormatException;

public class InputValidator {
    private static final String BRACKET = "[^\\(\\)]+";
    private static final String OP_WITH_BRACKET = "+-*/()";
    private static final String OPERATOR = "+-*/";
    private static final String NUMBER = "[0-9]+";


    public static void checkEquation(String equation) {
        containsBracket(equation);

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

    private static boolean endByOperator(String equation) {
        String[] equationArr = equation.split("");
        for (int i = equationArr.length - 1; i >= 0; i--) {
            if (equationArr[i].equals(")")) continue;
            if (!OPERATOR.contains(equationArr[i])) {
                return false;
            }else
                return true;
        }
        return true;
    }

    private static boolean continuousOp(String equation) {
        String[] equationArr = equation.split("");
        for (int i = 0; i < equationArr.length - 1; i++) {
            String cur = equationArr[i];
            String next = equationArr[i + 1];

            if (OPERATOR.contains(cur) && OPERATOR.contains(next)) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkOperator(String _equation) {
        String equation = _equation.replaceAll(NUMBER, "");
        String[] equationArr = equation.split("");
        for (int i = 0; i < equationArr.length; i++) {
            if (!OP_WITH_BRACKET.contains(equationArr[i])) {
                return true;
            }
        }
        return false;
    }

    public static void containsBracket(String equation) {
        if (equation.contains("(") || equation.contains(")")) {
            if (!checkBracket(equation)) throw new EquationFormatException();
        }
    }

    public static boolean checkBracket(String equation) {
        int bracketCnt = 0;
        String target = equation.replaceAll(BRACKET, "");

        if (target.charAt(0) == ')') {
            return false;
        }

        for (int i = 0; i < target.length(); i++) {
            if (target.charAt(i) == '(') {
                bracketCnt++;
            } else {
                bracketCnt--;
            }
            if (bracketCnt < 0) return false;
        }
        if (bracketCnt != 0) return false;

        return true;
    }
}
