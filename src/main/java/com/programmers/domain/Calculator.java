package com.programmers.domain;

import com.programmers.enumtype.Operator;
import com.programmers.util.Arithmetic;

import java.util.List;
import java.util.Stack;

public class Calculator {
    private final List<String> expression;

    public Calculator(List<String> infixExpression) {
        validate(infixExpression);
        expression = PostfixConverter.convert(infixExpression);
    }

    private void validate(List<String> infixExpression) {
        boolean numberTurn = true;
        for (String expr : infixExpression) {
            if (Arithmetic.isNumber(expr) && numberTurn) {
                numberTurn = false;
            } else if (Arithmetic.isOperator(expr) && !numberTurn) {
                numberTurn = true;
            } else {
                throw new UnsupportedOperationException(Arithmetic.WRONG_EXPRESSION);
            }
        }

        if (numberTurn) {
            throw new UnsupportedOperationException(Arithmetic.WRONG_EXPRESSION);
        }
    }

    public int calculate() {
        Stack<Integer> numbers = new Stack<>();
        for (String expr : expression) {
            numbers.push(processOperation(numbers, expr));
        }

        return numbers.pop();
    }

    private int processOperation(Stack<Integer> numbers, String token) {
        if (Arithmetic.isNumber(token)) {
            return Integer.parseInt(token);
        }
        //token 이 연산자일 경우 스택 상위 2개의 값을 연산한 결과를 반환
        return binaryOperate(numbers.pop(), numbers.pop(), token);
    }

    private int binaryOperate(int a, int b, String operator) {
        return Operator.binaryOperate(b, a, operator);
    }
}
