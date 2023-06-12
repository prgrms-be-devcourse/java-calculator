package com.programmers.engine.model;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Operation {

    public static Integer calculate(String command) {
        List<String> operatorsAndOperands = splitOperatorsAndOperands(command);
        Stack<String> operatorsStack = new Stack<>();
        Stack<Integer> operandsStack = new Stack<>();
        for (String element : operatorsAndOperands) {
            pushOperand(operandsStack, element);
            pushOperator(operatorsStack, operandsStack, element);
        }
        calculateRemainingValues(operatorsStack, operandsStack);
        return operandsStack.pop();
    }

    private static List<String> splitOperatorsAndOperands(String command) {
        return Arrays.asList(command.split(" "));
    }

    private static void calculateRemainingValues(Stack<String> operatorsStack, Stack<Integer> operandsStack) {
        while (!operatorsStack.empty()) {
            Integer calculationResult = getPerformFourArithmeticOperations(operatorsStack.pop(), operandsStack.pop(), operandsStack.pop());
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
            Integer calculationResult = getPerformFourArithmeticOperations(operatorsStack.pop(), operandsStack.pop(), operandsStack.pop());
            operandsStack.push(calculationResult);
        }
    }

    private static void pushOperand(Stack<Integer> operandsStack, String element) {
        if (isOperand(element)) {
            operandsStack.push(Integer.valueOf(element));
        }
    }

    private static Integer getPerformFourArithmeticOperations(String operator, Integer operand1, Integer operand2) {
        return Operator.getOperator(operator).calculate(operand1, operand2);
    }

    private static boolean isComparePriorities(String operator, String element) {
        if ((operator.equals(Operator.MULTIPLY.getOperator())) || operator.equals(Operator.DIVIDE.getOperator())
                && (element.equals(Operator.PLUS.getOperator()) || element.equals(Operator.MINUS.getOperator()))) {
            return true;
        }
        return false;
    }

    private static boolean isOperand(String element) {
        return element.matches("[0-9]+");
    }
}
