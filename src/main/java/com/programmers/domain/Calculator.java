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
        this.infixExpression = infixExpression;
        validateExpression();

        this.postfixExpression = PostfixConverter.convert(infixExpression);
        this.result = 0;
    }

    private void validateExpression() {
        boolean numberTurn = true;
        for (String element : infixExpression) {
            if (Arithmetic.isNumber(element) && numberTurn) {
                numberTurn = false;
            } else if (Arithmetic.isOperator(element) && !numberTurn) {
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
        for (String element : postfixExpression) {
            numbers.push(processOperation(numbers, element));
        }
        result = numbers.pop();

        return result;
    }

    private int processOperation(Stack<Integer> numbers, String element) {
        if (Arithmetic.isNumber(element)) {
            return Integer.parseInt(element);
        }
        //token 이 연산자일 경우 스택 상위 2개의 값을 연산한 결과를 반환
        return binaryOperate(numbers.pop(), numbers.pop(), element);
    }

    private int binaryOperate(int a, int b, String operator) {
        return Operator.binaryOperate(b, a, operator);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String element : infixExpression) {
            sb.append(element);
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
