package com.programmers.java.logic;

import com.programmers.java.exception.WrongExpressionException;

import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

public class Calculator {
    public BigDecimal calculate(String expression) throws NoSuchElementException, WrongExpressionException {
        String postExp = toPostfix(expression);
        return postfixCalculator(postExp);
    }

    public BigDecimal postfixCalculator(String postExp) throws NoSuchElementException {
        Deque<BigDecimal> numberStack = new ArrayDeque<>();
        int index = 0;

        while (index < postExp.length()) {
            char ch = postExp.charAt(index);
            if (Character.isDigit(ch)) {
                String tokenized = tokenizer(postExp, index, false);
                numberStack.push(new BigDecimal(tokenized));
                index = index + tokenized.length() - 1;
            } else if (isOperator(ch)) {
                if (isNegativeToken(postExp, index)) {
                    String tokenized = tokenizer(postExp, index, true);
                    numberStack.push(new BigDecimal(tokenized));
                    index = index + tokenized.length() - 1;
                } else {
                    numberStack.push(performOperation(ch, numberStack.pop(), numberStack.pop()));
                }
            }
            index++;
        }

        return numberStack.pop();
    }

    private boolean isNegativeToken(String postExp, int index) {
        return index + 1 < postExp.length() && Character.isDigit(postExp.charAt(index+1));
    }

    private String toPostfix(String expression) throws WrongExpressionException {
        Deque<Character> operatorStack = new ArrayDeque<>();
        StringBuilder intermediateBuilder = new StringBuilder();
        int index= 0;
        boolean negativeFlag = true;

        while (index < expression.length()) {
            char ch = expression.charAt(index);
            if (Character.isDigit(ch)) {
                negativeFlag = false;
                String tokenized = tokenizer(expression, index, negativeFlag);
                intermediateBuilder.append(tokenized).append(" ");
                index = index + tokenized.length() - 1;
            } else if (isOperator(ch)) {
                if (negativeFlag) {
                    String tokenized = tokenizer(expression, index, negativeFlag);
                    intermediateBuilder.append(tokenized).append(" ");
                    index = index + tokenized.length() - 1;
                    negativeFlag = false;
                } else {
                    while (needPoppingHighPriorityOperator(operatorStack, ch)) {
                        intermediateBuilder.append(operatorStack.pop()).append(" ");
                    }
                    operatorStack.push(ch);
                    negativeFlag = true;
                }
            } else if (expression.charAt(index) == '(') {
                operatorStack.push(ch);
            } else if (expression.charAt(index) == ')') {
                while (operatorStack.peek() != '(') {
                    intermediateBuilder.append(operatorStack.pop());
                }
                operatorStack.pop();
            } else {
                throw new WrongExpressionException();
            }

            index++;
        }

        while (!operatorStack.isEmpty()) {
            intermediateBuilder.append(operatorStack.pop()).append(" ");
        }

        return intermediateBuilder.toString();
    }

    private boolean needPoppingHighPriorityOperator(Deque<Character> operatorStack, char ch) {
        return !operatorStack.isEmpty() && getPriority(operatorStack.peek()) >= getPriority(ch);
    }

    private String tokenizer(String exp, int index, boolean negativeFlag) {
        StringBuilder decimalBuilder = new StringBuilder();

        if (negativeFlag) {
            decimalBuilder.append(exp.charAt(index));
            index++;
        }

        while (spaceDelimiterNotReached(exp, index)) {
            decimalBuilder.append(exp.charAt(index));
            index++;
        }
        return decimalBuilder.toString();
    }

    private boolean spaceDelimiterNotReached(String exp,int index) {
        return index < exp.length() && (Character.isDigit(exp.charAt(index)) || exp.charAt(index) == '.');
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
            default:
                return BigDecimal.ZERO;
        }
    }

    public boolean isOperator(char ch) {
        return (ch == '+' || ch == '-' || ch == '*' || ch == '/');
    }

    public int getPriority(char ch) {
        if (ch == '+' || ch == '-')
            return 1;
        if (ch == '*' || ch == '/')
            return 2;
        return 0;
    }

}
