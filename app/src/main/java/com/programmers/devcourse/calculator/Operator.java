package com.programmers.devcourse.calculator;

import java.util.function.BinaryOperator;

public enum Operator {

    PLUS("+", (n1, n2) -> n1 + n2,1),
    SUB("-", (n1, n2) -> n1 - n2,1),
    MUL("*", (n1, n2) -> n1 * n2,2),
    DIV("/", (n1, n2) -> n1 / n2,2);

    public String operatorStr;
    private BinaryOperator<Integer> expression;
    public int precedence;
    Operator(String operatorStr, BinaryOperator<Integer> expression, int precedence) {
        this.operatorStr = operatorStr;
        this.expression = expression;
        this.precedence = precedence;
    }

    public int calculate(Integer num1, Integer num2) {
        return this.expression.apply(num1, num2);
    }
}