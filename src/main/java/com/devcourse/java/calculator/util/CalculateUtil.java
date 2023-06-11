package com.devcourse.java.calculator.util;

import java.util.ArrayList;
import java.util.Stack;

public class CalculateUtil {

    private final char[] operation = {'+', '-', '*', '/', '(', ')'};

    public String calculateAndReturnEquationWithAnswer(String equation) {

        changeToPostfix(equation);
        return calculatePostfix();
    }

    public int opOrder(char op) {
        switch (op) {
            case '+':
            case '-': return 1;
            case '*':
            case '/': return 2;
            default: return -1;
        }
    }

    public void changeToPostfix(String equation) {

    }

    public String calculatePostfix() {
        return null;
    }

}
