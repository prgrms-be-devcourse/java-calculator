package com.programmers.java.calculator.calculate;

import com.programmers.java.util.OperandChecker;

import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PostfixConverter {
    public String postfixConvert(List<String> tokenList) {
        Stack<Operator> operatorStack = new Stack<>();
        StringBuilder postfixExpression = new StringBuilder();

        Operator prevOperator;
        Operator nextOperator;

        for (String token : tokenList) {
            if (OperandChecker.isOperand(token)) {
                postfixExpression.append(token).append(" ");
                continue;
            }

            prevOperator = operatorStack.isEmpty() ? Operator.NONE : operatorStack.peek();
            nextOperator = Operator.findByOperator(token);

            while (!operatorStack.isEmpty()
                    && Operator.evaluatePriority(prevOperator, nextOperator) > 0) {
                postfixExpression.append(operatorStack.pop()).append(" ");
            }
            operatorStack.push(nextOperator);
        }

        Collections.reverse(operatorStack);
        operatorStack.stream()
                .forEach(v -> postfixExpression.append(v).append(" "));

        return postfixExpression.toString();
    }
}