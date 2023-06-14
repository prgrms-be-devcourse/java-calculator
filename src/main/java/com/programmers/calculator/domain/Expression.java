package com.programmers.calculator.domain;

import com.programmers.calculator.util.Regex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Matcher;

public class Expression {

    public List<String> parseToTokens(String inputExpression) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = Regex.pattern.matcher(inputExpression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

    public List<String> convertToPostfix(List<String> tokens) {
        List<String> postfixTokens = new ArrayList<>();
        Stack<Character> operatorStack = new Stack<>();

        for (String token : tokens) {
            if (isNumber(token)) {
                postfixTokens.add(token);
            } else {

                char firstChar = token.charAt(0);
                Operator operator = Operator.of(firstChar);

                switch (operator) {
                    case MULTIPLICATION:
                    case DIVISION:
                        while (!operatorStack.isEmpty() && isOperator(operatorStack.peek())) {
                            Operator topOperator = Operator.of(operatorStack.peek());
                            if (topOperator == Operator.ADDITION || topOperator == Operator.SUBTRACTION) {
                                break;
                            } else if (operator.getPriority() <= topOperator.getPriority()) {
                                postfixTokens.add(String.valueOf(operatorStack.pop()));
                            } else {
                                break;
                            }
                        }
                        operatorStack.push(operator.getSymbol());
                        break;
                    case ADDITION:
                    case SUBTRACTION:
                        while (!operatorStack.isEmpty() && isOperator(operatorStack.peek())) {
                            Operator topOperator = Operator.of(operatorStack.peek());
                            if (operator.getPriority() <= topOperator.getPriority()) {
                                postfixTokens.add(String.valueOf(operatorStack.pop()));
                            } else {
                                break;
                            }
                        }
                        operatorStack.push(operator.getSymbol());
                        break;
                }
            }
        }

        while (!operatorStack.isEmpty()) {
            postfixTokens.add(String.valueOf(operatorStack.pop()));
        }

        return postfixTokens;
    }

    private boolean isNumber(String token) {
        try {
            new BigDecimal(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(char token) {

        return token == Operator.ADDITION.getSymbol()
                || token == Operator.SUBTRACTION.getSymbol()
                || token == Operator.MULTIPLICATION.getSymbol()
                || token == Operator.DIVISION.getSymbol();
    }

    public BigDecimal evaluatePostfix(List<String> postfixTokens) {
        Stack<BigDecimal> operandStack = new Stack<>();

        for (String token : postfixTokens) {
            if (isNumber(token)) {
                operandStack.push(new BigDecimal(token));
            } else if (isOperator(token.charAt(0))) {
                Operator currentOperator = Operator.of(token.charAt(0));
                if (operandStack.size() < 2) {
                    throw new IllegalArgumentException("잘못된 수식입니다.");
                }
                BigDecimal operand2 = operandStack.pop();
                BigDecimal operand1 = operandStack.pop();
                BigDecimal result = currentOperator.getFunction().apply(operand1, operand2);
                operandStack.push(result);
            } else {
                throw new IllegalArgumentException("유효하지 않은 토큰입니다.");
            }
        }

        if (operandStack.size() != 1) {
            throw new IllegalArgumentException("잘못된 수식입니다.");
        }

        return operandStack.pop();
    }
}