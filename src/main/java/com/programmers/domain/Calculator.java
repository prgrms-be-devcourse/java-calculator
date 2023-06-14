package com.programmers.domain;

import com.programmers.enumtype.Operator;
import com.programmers.util.Arithmetic;

import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class Calculator {
    private final List<String> infixExpression;
    private final List<String> postfixExpression;
    private int result;

    public Calculator(List<String> infixExpression) {
        validate(infixExpression);

        this.infixExpression = infixExpression;
        this.postfixExpression = PostfixConverter.convert(infixExpression);
        this.result = 0;
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
        for (String expr : postfixExpression) {
            numbers.push(processOperation(numbers, expr));
        }
        result = numbers.pop();

        return result;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String token : infixExpression) {
            sb.append(token);
            sb.append(" ");
        }
        sb.append("= ");
        sb.append(result);

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Calculator that = (Calculator) o;
        return result
                == that.result
                && Objects.equals(infixExpression, that.infixExpression)
                && Objects.equals(postfixExpression, that.postfixExpression);
    }

    @Override
    public int hashCode() {
        return Objects.hash(infixExpression, postfixExpression, result);
    }
}
