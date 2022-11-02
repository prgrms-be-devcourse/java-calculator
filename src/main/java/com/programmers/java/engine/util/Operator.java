package com.programmers.java.engine.util;

import com.programmers.java.engine.exception.OperatorException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, 1, (x, y) -> x + y),
    MINUS("-", 1, 1, (x, y) -> x - y),
    MULTIPLY("*", 2, 2, (x, y) -> x * y),
    DIVIDE("/", 2, 2, (x, y) -> {
        if (y == 0) throw new OperatorException("0 으로 나눌 수 없습니다.\n");
        return x / y;
    }),
    LEFT_BRACKET("(", 3, 0, null),
    RIGHT_BRACKET(")", 3, 3, null);

    private final String operator;
    private final int icp;
    private final int isp;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, int icp, int isp, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
        this.icp = icp;
        this.isp = isp;
    }

    public static Operator findOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(target -> target.operator.equals(operator))
                .findAny()
                .orElseThrow(() -> new OperatorException("올바른 수식을 입력해주세요.\n숫자와 연산자 사이는 공백이 필요하고 사칙 연산과 괄호 외 지원하지 않습니다.\n"));
    }

    public static int getICP(Operator operator) {
        return operator.icp;
    }

    public static int getISP(Operator operator) {
        return operator.isp;
    }

    public double calculate(double x, double y) {
        return expression.apply(x, y);
    }


    @Override
    public String toString() {
        return operator;
    }
}
