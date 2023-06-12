package com.programmers.engine.model;

import java.util.Stack;

public class Operation {

    public static Integer calculate(String command) {
        String[] operatorsAndOperands = splitOperatorsAndOperands(command);
        Stack<String> operatorsStack = new Stack<>();
        Stack<Integer> operandsStack = new Stack<>();
        for (String element : operatorsAndOperands) {
            pushOperand(operandsStack, element);
            pushOperator(operatorsStack, operandsStack, element);
        }
        calculateRemainingValues(operatorsStack, operandsStack);
        return operandsStack.pop();
    }

    private static String[] splitOperatorsAndOperands(String command) {
        return command.split(" ");
    }

    private static void calculateRemainingValues(Stack<String> operatorsStack, Stack<Integer> operandsStack) {
        while (!operatorsStack.empty()) {
            Integer calculationResult = getPerformFourArithmeticOperations(operatorsStack, operandsStack);
            operandsStack.push(calculationResult);
        }
    }

    private static void pushOperator(Stack<String> operatorsStack, Stack<Integer> operandsStack, String element) {
        if (!isOperand(element)) {
            pushCalculationResult(operatorsStack, operandsStack, element);
            operatorsStack.push(element);
        }
    }

    private static void pushCalculationResult(Stack<String> operatorsStack, Stack<Integer> operandsStack, String element) {
        while (!operatorsStack.empty() && isComparePriorities(operatorsStack.peek(), element)) {
            Integer calculationResult = getPerformFourArithmeticOperations(operatorsStack, operandsStack);
            operandsStack.push(calculationResult);
        }
    }

    private static void pushOperand(Stack<Integer> operandsStack, String element) {
        if (isOperand(element)) {
            operandsStack.push(Integer.valueOf(element));
        }
    }

    //나중에 구현
    private static Integer getPerformFourArithmeticOperations(Stack<String> operatorsStack, Stack<Integer> operandsStack) {
        return null;
    }

    //나중에 구현
    private static boolean isComparePriorities(String operator, String element) {
        return true;
    }

    //나중에 구현
    private static boolean isOperand(String element) {
        return true;
    }
}
