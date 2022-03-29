package com.programmers.oop.type;

import java.util.Map;
import java.util.function.BinaryOperator;

public enum Operator {
    ADDICTIVE(1, Long::sum),
    MINUS(1, (left, right) -> left - right),
    MULTIPLICATION(2, (left, right) -> left * right),
    DIVISION(2, (left, right) -> {
        // worries : exception을 enum안에서 터트려도 되나?
        if (right == 0) {
            throw new RuntimeException("zero is not divide .. check the expression ");
        }
        return left / right;
    });

    private static final Map<Character, Operator> operatorMap = Map.of(
        '+', ADDICTIVE,
        '-', MINUS,
        '*', MULTIPLICATION,
        '/', DIVISION
    );


    private int prioriy;
    private BinaryOperator<Long> operator;

    Operator(int prioriy, BinaryOperator<Long> operator) {
        this.prioriy = prioriy;
        this.operator = operator;
    }

    public boolean isPriorityYn(Operator opponent) {
        return this.prioriy >= opponent.prioriy;
    }

    public long operate(long left,long right){
        return this.operator.apply(left,right);
    }

    public static Operator getValue(char operator) {
        return operatorMap.get(operator);
    }
}
