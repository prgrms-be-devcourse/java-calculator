package com.programmers.javaCalulator.util;

import com.programmers.javaCalulator.exception.ExceptionMessage;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {

    /* 요구 조건에 제시된 사칙연산자의 표기, 우선순위, 연산방법을 미리 정의  */
    ADDITION("+", 3, (first, second) -> first + second),
    SUBTRACTION("-", 3, (first, second) -> first - second),
    MULTIPLICATION("*", 2, (first, second) -> first * second),
    DIVISION("/", 2, (first, second) -> {
        if (second == 0)
            throw new ArithmeticException(ExceptionMessage.DIVIDED_BY_ZERO);
        return first / second;
    });

    private final String symbol;
    private final int precedence;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, int precedence, BiFunction<Integer, Integer, Integer> expression) {
        this.symbol = symbol;
        this.precedence = precedence;
        this.expression = expression;
    }

    /*
     * 전제 조건: 입력으로 들어오는 연산자의 표기와 피연산자는 모두 정의되어 있다.
     * 완료 조건: 연산자의 표기에 대응하는 연산 과정에 따라 두 개의 피연산자를 연산한 후 결과값을 반환한다.
     */
    public static int getResult(String symbol, int first, int second) {
        return findOperator(symbol).get().expression.apply(first, second);
    }

    /*
     * 전제 조건: 입력으로 들어오는 연산자의 표기는 정의되어 있다.
     * 완료 조건: 연산자의 우선순위를 반환한다.
     */
    public static int getPrecedence(String symbol) {
        return findOperator(symbol).get().precedence;
    }

    /* 입력으로 들어온 문자열이 미리 정의된 연산자 중 하나의 표기와 일치하면 참, 아니면 거짓을 반환한다. */
    public static boolean isOperator(String temp) {
        return findOperator(temp).isPresent();
    }

    /* 입력으로 들어온 문자열이 미리 정의된 연산자 중 어느 하나에 해당되는지 여부를
    Optional 객체에 담아 반환한다. */
    private static Optional<Operator> findOperator(String temp) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(temp))
                .findFirst();
    }

}
