package com.programmers.java.engine;

import com.programmers.java.engine.domain.BasicOperator;
import com.programmers.java.engine.domain.Expression;
import com.programmers.java.engine.domain.Operand;
import com.programmers.java.engine.domain.Operator;

import java.util.List;
import java.util.Stack;

public class Calculator {
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
            if (operators.get(i) == BasicOperator.MULTIPLY || operators.get(i) == BasicOperator.DIVIDE) {
                Operand prevVal = operandStack.pop();
                Operand curVal = operands.get(i + 1);
                operandStack.push(operators.get(i).apply(prevVal, curVal));
            } else {
                operandStack.push(operands.get(i + 1));
            }
        }

        List<Operator> remainOperator = operators.stream().filter(s -> (s == BasicOperator.PLUS || s == BasicOperator.MINUS)).toList();
        Operand[] operandArray = operandStack.toArray(Operand[]::new);
        Operand result = operandArray[0];
        for (int i = 0; i < remainOperator.size(); i++) {
            result = remainOperator.get(i).apply(result, operandArray[i + 1]);
        }
        return result;
    }
}
