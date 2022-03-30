package com.programmers.java.engine;

import com.programmers.java.engine.domain.Expression;
import com.programmers.java.engine.domain.Operand;
import com.programmers.java.engine.domain.Operator;
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
    private Operand operand;
    private Operator operator;

    public Calculator(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public Double calculate(String inputStr) {
        return applyOperator(parseInput(inputStr));
    }

    public Expression parseInput(String inputStr) {
        String operatorPattern = "[\\+\\*-/]";
        Operator operator = new Operator(inputStr, operatorPattern);
        Operand operand = new Operand(inputStr, operatorPattern);
        return new Expression(operator, operand);
    }

    public Double applyOperator(Expression expression) {
        List<String> operators = expression.getOperator().operators;
        Double[] operands = expression.getOperand().operands;

        Stack<Double> operandStack = new Stack<>();
        operandStack.push(operands[0]);
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i).equals("*") || operators.get(i).equals("/")) {
                Double prevVal = operandStack.pop();
                Double curVal = operands[i + 1];
                if (operators.get(i).equals("*")) {
                    operandStack.push(arithmeticOperation.multiply(prevVal, curVal));
                } else {
                    operandStack.push(arithmeticOperation.divide(prevVal, curVal));
                }
            } else {
                operandStack.push(operands[i + 1]);
            }
        }

        List<String> remainOperator = operators.stream().filter(s -> (s.equals("+") || s.equals("-"))).toList();
        Double[] operandArray = operandStack.toArray(Double[]::new);
        Double result = operandArray[0];
        for (int i = 0; i < remainOperator.size(); i++) {
            if (remainOperator.get(i).equals("+")) {
                result = arithmeticOperation.add(result, operandArray[i + 1]);
            } else {
                result = arithmeticOperation.subtract(result, operandArray[i + 1]);
            }
        }
        return result;
    }
}
