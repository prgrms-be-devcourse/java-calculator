package com.devcourse.calc.model;

import java.util.Arrays;
import java.util.Map;
import java.util.Stack;
import java.util.function.BiFunction;

import static java.util.stream.Collectors.toMap;

public enum Operator implements Token {
    OPEN("(", 1, null),
    CLOSE(")", 1, null),
    PLUS("+", 2, (number1, number2) -> number1 + number2),
    MINUS("-", 2, (number1, number2) -> number1 - number2),
    MULTIPLE("*", 3, (number1, number2) -> number1 * number2),
    DIVISION("/", 3, (number1, number2) -> {
        checkDivideZero(number2);
        return number1 / number2;
    });

    private static final Map<String, Operator> operators = Arrays.stream(values()).collect(toMap(operator -> operator.sign, operator -> operator));

    private final String sign;

    private final int priority;
    private final BiFunction<Integer, Integer, Integer> action;

    Operator(String sign, int priority, BiFunction<Integer, Integer, Integer> action) {
        this.sign = sign;
        this.priority = priority;
        this.action = action;
    }

    public static Operator find(char sign) {
        return operators.get(Character.toString(sign));
    }

    public boolean isLowerPriority(Operator other) {
        return this.priority <= other.priority;
    }

    public boolean isFinishBracket() {
        return this.equals(CLOSE);
    }

    public boolean isOpenBracket() {
        return this.equals(OPEN);
    }

    @Override
    public void deal(Stack<Integer> calculationResult) {
        Integer firstNumber = calculationResult.pop();
        Integer secondNumber = calculationResult.pop();
        calculationResult.push(action.apply(secondNumber, firstNumber));
    }

    @Override
    public String toString() {
        return sign;
    }

    private static void checkDivideZero(int denominator) {
        if (denominator == 0) {
            throw new RuntimeException("0으로 나눌 수 없습니다");
        }
    }
}
