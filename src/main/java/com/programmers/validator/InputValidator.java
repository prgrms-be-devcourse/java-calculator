package com.programmers.validator;

import com.programmers.exception.EquationFormatException;
import com.programmers.exception.MenuFormatException;
import com.programmers.util.Operator;

public class InputValidator {
    private static final String BRACKET = "[^\\(\\)]+";
    private static final String OPERATOR = "+-*/";
    private static final String NUMBER = "[0-9]+";


    public static void checkEquation(String equation) {
        checkOperator(equation);
        containsBracket(equation);
        endByOperator(equation);
        continuousOperator(equation);
    }

    private static void endByOperator(String equation) {
        String[] equationArr = equation.split("");
        for (int i = equationArr.length - 1; i >= 0; i--) {
            if (equationArr[i].equals(")")) continue;
            if (OPERATOR.contains(equationArr[i]) || Operator.contains(equationArr[0])){
                throw new EquationFormatException();
            }
            return;
        }
    }

    private static void continuousOperator(String equation) {
        String[] equationArr = equation.split("");
        for (int i = 0; i < equationArr.length - 1; i++) {
            String cur = equationArr[i];
            String next = equationArr[i + 1];

            if (OPERATOR.contains(cur) && OPERATOR.contains(next)) {
                throw new EquationFormatException();
            }
        }
        return;
    }

    private static void checkOperator(String _equation) {
        String equation = _equation.replaceAll(NUMBER, "");
        String[] equationArr = equation.split("");
        for (int i = 0; i < equationArr.length; i++) {
            if (!Operator.contains(equationArr[i])) {
                throw new EquationFormatException();
            }
        }
        return;
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
