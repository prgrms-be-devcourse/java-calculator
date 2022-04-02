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

    public Calculator(ArithmeticOperation arithmeticOperation) {
        this.arithmeticOperation = arithmeticOperation;
    }

    public Double calculate(String inputStr) {
        return applyOperator(parseInput(inputStr)).number;
    }

    public Expression parseInput(String inputStr) {
        String operatorPattern = "[\\+\\*-/]";
        return new Expression(inputStr, operatorPattern);
    }

    public Operand applyOperator(Expression expression) {
        List<Operator> operators = expression.getOperators();
        List<Operand> operands = expression.getOperands();

        Stack<Operand> operandStack = new Stack<>();
        operandStack.push(operands.get(0));
        for (int i = 0; i < operators.size(); i++) {
            if (operators.get(i) == Operator.MULTIPLY || operators.get(i) == Operator.DIVIDE) {
                Operand prevVal = operandStack.pop();
                Operand curVal = operands.get(i + 1);
                operandStack.push(arithmeticOperation.operation(prevVal, curVal, operators.get(i)));
            } else {
                operandStack.push(operands.get(i + 1));
            }
        }

        List<Operator> remainOperator = operators.stream().filter(s -> (s == Operator.PLUS || s == Operator.MINUS)).toList();
        Operand[] operandArray = operandStack.toArray(Operand[]::new);
        Operand result = operandArray[0];
        for (int i = 0; i < remainOperator.size(); i++) {
            result = arithmeticOperation.operation(result, operandArray[i + 1], remainOperator.get(i));
        }
        return result;
    }
}
