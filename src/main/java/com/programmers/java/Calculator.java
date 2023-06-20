package com.programmers.java;

import java.math.BigDecimal;
import java.util.Stack;

public class Calculator {
    static int index;

    public BigDecimal calculate(String expression) throws Exception {
        index = 0;
        String postExp = toPostfix(expression);
        index = 0;
        return postfixCalculator(postExp);
    }

    public BigDecimal postfixCalculator(String postExp) throws Exception {
        Stack<BigDecimal> numberStack = new Stack<>();
        while (index < postExp.length()) {
            char ch = postExp.charAt(index);
            if (Character.isDigit(ch)) {
                numberStack.push(new BigDecimal(tokenizer(postExp)));
            } else if (isOperator(ch)) {
                numberStack.push(performOperation(ch, numberStack.pop(), numberStack.pop()));
            }
            index++;
        }
        return numberStack.pop();
    }

    private String toPostfix(String expression) throws Exception {
        Stack<Character> operatorStack = new Stack<>();
        StringBuilder intermediateBuilder = new StringBuilder();
        while (index < expression.length()) {
            char ch = expression.charAt(index);
            if (Character.isDigit(ch)) {
                intermediateBuilder.append(tokenizer(expression)).append(" ");
            } else if (isOperator(ch)) {
                while (!operatorStack.isEmpty() && getPriority(operatorStack.peek()) >= getPriority(ch)) {
                    intermediateBuilder.append(operatorStack.pop());
                }
                operatorStack.push(ch);
            } else if (expression.charAt(index) == '(') {
                operatorStack.push(ch);
            } else if (expression.charAt(index) == ')') {
                while (operatorStack.peek() != '(') {
                    intermediateBuilder.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                throw new Exception();
            }

            index++;
        }
        while (!operatorStack.isEmpty()) {
            intermediateBuilder.append(operatorStack.pop());
        }
        return intermediateBuilder.toString();
    }

    private String tokenizer(String exp) {
        StringBuilder decimalBuilder = new StringBuilder();
        while (index < exp.length() && (Character.isDigit(exp.charAt(index)) || exp.charAt(index) == '.')) {
            decimalBuilder.append(exp.charAt(index));
            index++;
        }
        index--;
        return decimalBuilder.toString();
    }

    private BigDecimal performOperation(Character operator, BigDecimal popLast, BigDecimal popSecondLast) {
        switch (operator) {
            case '+':
                return popSecondLast.add(popLast);
            case '-':
                return popSecondLast.subtract(popLast);
            case '*':
                return popSecondLast.multiply(popLast);
            case '/':
                return popSecondLast.divide(popLast);
        }
        return BigDecimal.ZERO;
    }

    public boolean isOperator(char ch) {
        if (ch == '+')
            return true;
        if (ch == '-')
            return true;
        if (ch == '*')
            return true;
        if (ch == '/')
            return true;
        return false;
    }

    public int getPriority(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        return 0;
    }

}
