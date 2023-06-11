package com.programmers.calculator;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    // 사칙 연산자
    private static final String ADD_OPERATOR = "+";
    private static final String SUBTRACTION_OPERATOR = "-";
    private static final String MULTIPLY_OPERATOR = "*";
    private static final String DIVIDE_OPERATOR = "/";

    // 괄호
    private static final String OPEN_BRACKET = "(";
    private static final String CLOSE_BRACKET = ")";

    // 중위 표현식 검증 regex
    private static final String EXPRESSION_REGEX = "(?<=[-+*/()])|(?=[-+*/()])";    // 정수, 괄호, 연산자들을 구분한다.
    private static final String CONSECUTIVE_OPERATORS_REGEX = ".*[\\+\\-\\*/]{2,}.*";   // 반복되는 연산자를 검증한다.

    // 중위 표현식 오류 메시지
    private static final String WRONG_INFIX_EXPRESSION_MESSAGE = "중위 표현식이 유효하지 않습니다.";

    /**
     * 중위 표현식을 후위 표현식으로 변환하는 메소드
     *
     * @param inputExpression 사용자에게 입력받은 중위 표현식
     * @return postfixExpression 변환된 후위 표기식
     * @throws IllegalArgumentException
     */
    public String convert(String inputExpression) throws IllegalArgumentException {
        StringBuilder sb = new StringBuilder();
        Deque<String> infixStack = new ArrayDeque<>();

        String validExpression = validateInfixExpression(inputExpression);
        String[] expressionTokens = validExpression.split(EXPRESSION_REGEX);

        for (String token : expressionTokens) {
            switch (token) {
                case ADD_OPERATOR:
                case SUBTRACTION_OPERATOR:
                case MULTIPLY_OPERATOR:
                case DIVIDE_OPERATOR: {
                    while (!infixStack.isEmpty() && priority(infixStack.peek()) >= priority(token)) {
                        sb.append(infixStack.pop() + " ");
                    }
                    infixStack.push(token);
                    break;
                }
                case OPEN_BRACKET: {
                    infixStack.push(token);
                    break;
                }
                case CLOSE_BRACKET: {
                    while (!infixStack.isEmpty() && !infixStack.peek().equals(OPEN_BRACKET)) {
                        sb.append(infixStack.pop() + " ");
                    }
                    infixStack.pop();
                    break;
                }
                default: {
                    sb.append(token + " ");
                }
            }
        }

        while (!infixStack.isEmpty()) {
            sb.append(infixStack.pop() + " ");
        }

        sb.delete(sb.length() - 1, sb.length());
        String postfixExpression = sb.toString();

        return postfixExpression;
    }

    /**
     * 후위 표기식의 계산 결과를 반환하는 메소드
     *
     * @param postfixExpression
     * @return 연산의 결과
     * @throws ArithmeticException
     */
    public double calculate(String postfixExpression) throws ArithmeticException {
        Deque<String> postfixStack = new ArrayDeque<>();

        for (String postfixToken : postfixExpression.split(" ")) {
            if (isOperator(postfixToken)) {
                double y = Double.parseDouble(postfixStack.pop());
                double x = Double.parseDouble(postfixStack.pop());

                switch (postfixToken) {
                    case ADD_OPERATOR: {
                        postfixStack.push(String.format("%.2f", x + y));
                        break;
                    }
                    case SUBTRACTION_OPERATOR: {
                        postfixStack.push(String.format("%.2f", x - y));
                        break;
                    }
                    case MULTIPLY_OPERATOR: {
                        postfixStack.push(String.format("%.2f", x * y));
                        break;
                    }
                    case DIVIDE_OPERATOR: {
                        postfixStack.push(String.format("%.2f", x / y));
                    }
                }
            } else {
                postfixStack.push(postfixToken);
            }
        }

        return Double.parseDouble(postfixStack.pop());
    }

    /**
     * 사칙연산자인지 확인하는 메소드
     *
     * @param token
     * @return true or false
     */
    private boolean isOperator(String token) {
        return token.equals(ADD_OPERATOR) || token.equals(SUBTRACTION_OPERATOR) || token.equals(MULTIPLY_OPERATOR) || token.equals(DIVIDE_OPERATOR);
    }

    /**
     * 연산자의 우선순위를 판별하는 메소드
     *
     * @param operator 연산자
     * @return 우선순위
     */
    private int priority(String operator) {
        if (operator.equals(OPEN_BRACKET) || operator.equals(CLOSE_BRACKET)) {
            return 0;
        }
        if (operator.equals(ADD_OPERATOR) || operator.equals(SUBTRACTION_OPERATOR)) {
            return 1;
        }
        if (operator.equals(MULTIPLY_OPERATOR) || operator.equals(DIVIDE_OPERATOR)) {
            return 2;
        }
        return -1;
    }

    /**
     * 중위 표현식이 유효한지 검증하는 메소드
     *
     * @param inputExpression 사용자에게 입력받은 중위 표현식
     * @return 검증이 완료된 표현식
     * @throws IllegalArgumentException
     */
    private String validateInfixExpression(String inputExpression) throws IllegalArgumentException {
        String blankRemovedExpression = inputExpression.replace(" ", "");

        String[] expressionTokens = blankRemovedExpression.split(EXPRESSION_REGEX);

        validateBracket(expressionTokens);

        validateOperandAndOperatorNumber(expressionTokens);

        validateConsecutiveOperators(blankRemovedExpression);

        return blankRemovedExpression;
    }

    /**
     * 중위 표현식에서 괄호의 갯수를 검증하는 메소드
     *
     * @param expressionTokens 표현식 조각으로 이루어진 토큰 배열
     * @throws IllegalArgumentException
     */
    private void validateBracket(String[] expressionTokens) throws IllegalArgumentException {
        Deque<String> tokenStack = new ArrayDeque<>();

        for (String token : expressionTokens) {
            switch (token) {
                case OPEN_BRACKET: {
                    tokenStack.push(token);
                    break;
                }
                case CLOSE_BRACKET: {
                    if (tokenStack.isEmpty()) {
                        throw new IllegalArgumentException(WRONG_INFIX_EXPRESSION_MESSAGE);
                    }
                    tokenStack.pop();
                }
            }
        }

        if (!tokenStack.isEmpty()) {
            throw new IllegalArgumentException(WRONG_INFIX_EXPRESSION_MESSAGE);
        }
    }

    /**
     * 연산자가 연속하는지 검증하는 메소드
     *
     * @param expression 표현식
     * @throws IllegalArgumentException
     */
    private void validateConsecutiveOperators(String expression) throws IllegalArgumentException {
        if (expression.matches(CONSECUTIVE_OPERATORS_REGEX)) {
            throw new IllegalArgumentException(WRONG_INFIX_EXPRESSION_MESSAGE);
        }
    }

    /**
     * 연산자와 피연산자의 갯수 검증하는 메소드.
     *
     * @param tokens 표현식 토큰
     */
    private void validateOperandAndOperatorNumber(String[] tokens) {
        if (tokens.length % 2 != 1) {   // 중위 표현식의 토큰 갯수는 항상 홀수임을 이용함(피연산자의 개수 = 연산자의 갯수 + 1).
            throw new IllegalArgumentException(WRONG_INFIX_EXPRESSION_MESSAGE);
        }
    }
}