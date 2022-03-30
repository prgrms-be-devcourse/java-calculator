package com.programmers.java.engine;

import com.programmers.java.engine.domain.Expression;
import com.programmers.java.engine.operations.ArithmeticOperation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Calculator {
    private final ArithmeticOperation arithmeticOperation;

    public Calculator(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public Double calculate(String inputStr) {
        return applyOperator(parseInput(inputStr));
    }

    public Expression parseInput(String inputStr) {
        String operatorPattern = "[\\+\\*-/]";
        Double[] operands = Arrays.stream(inputStr.split(operatorPattern)).map(Double::valueOf).toArray(Double[]::new);
        Matcher operatorMatcher = Pattern.compile(operatorPattern).matcher(inputStr);
        String[] operators = new String[operands.length - 1];
        int i = 0;
        while (operatorMatcher.find()) {
            operators[i++] = operatorMatcher.group();
        }
        return new Expression(operators, operands);
    }

    public Double applyOperator(Expression expression) {
        String[] operators = expression.getOperators();
        Double[] operands = expression.getOperands();

        Stack<Double> operandStack = new Stack<>();
        List<String> operatorArray = new ArrayList<>();

        operandStack.push(operands[0]);
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("*") || operators[i].equals("/")) {
                Double prevVal = operandStack.pop();
                Double curVal = operands[i + 1];
                if (operators[i].equals("*")) {
                    operandStack.push(arithmeticOperation.multiply(prevVal, curVal));
                } else {
                    operandStack.push(arithmeticOperation.divide(prevVal, curVal));
                }
            } else {
                operandStack.push(operands[i + 1]);
                operatorArray.add(operators[i]);
            }
        }
        Double[] operandArray = operandStack.toArray(Double[]::new);
        Double result = operandArray[0];
        for (int i = 0; i < operatorArray.size(); i++) {
            if (operatorArray.get(i).equals("+")) {
                result = arithmeticOperation.add(result, operandArray[i + 1]);
            } else {
                result = arithmeticOperation.subtract(result, operandArray[i + 1]);
            }
        }
        return result;
    }
}
