package com.programmers.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {
    private static final String SEPARATOR = " ";

    public static List<String> convert(String formula) {
        List<String> postfix = new ArrayList<>();
        String[] splitFormula = formula.split(SEPARATOR);
        Stack<String> stack = new Stack<>();
        checkEmptyFormula(splitFormula);

        for (int i = 0; i < splitFormula.length; i++) {
            String eachFormula = splitFormula[i];

            if (isOperatorCheck(i)) {
                putOperator(eachFormula, postfix, stack);
            } else {
                putOperand(eachFormula, postfix);
            }
        }
        while (!stack.isEmpty()) {
            postfix.add(stack.pop());
        }
        return postfix;
    }

    private static void putOperator(String operator, List<String> postfix, Stack<String> stack) {
        if (!Operators.isOperator(operator))
            throw new IllegalArgumentException("잘못된 수식입니다. +, -, *, / 연산만 가능합니다.");

        if (stack.isEmpty() || Priority.getPriority(stack.peek()) < Priority.getPriority(operator)) {
            stack.push(operator);
            return;
        }

        while (!stack.isEmpty() && Priority.getPriority(stack.peek()) >= Priority.getPriority(operator)) {
            postfix.add(stack.pop());
        }

        stack.push(operator);
    }

    private static void putOperand(String operand, List<String> postfix) throws IllegalArgumentException {
        if (!isNumber(operand)) {
            throw new IllegalArgumentException("number는 숫자가 아닙니다.");
        }

        postfix.add(operand);
    }

    private static boolean isNumber(String operand) {
        boolean isNumber;
        try {
            convertStringToLong(operand);
            isNumber = true;
        } catch (NumberFormatException e) {
            isNumber = false;
        }
        return isNumber;
    }

    private static void convertStringToLong(String operand) {
        Long.parseLong(operand);
    }


    private static boolean isOperatorCheck(int i) {
        return (i + 1) % 2 == 0;
    }

    private static void checkEmptyFormula(String[] splitFormula) throws IllegalArgumentException {
        if (isEmptyFormula(splitFormula)) throw new IllegalArgumentException("비어있는 수식입니다.");
    }

    private static boolean isEmptyFormula(String[] splitFormula) {
        return splitFormula != null && splitFormula.length == 0;
    }
}
