package com.devcourse.calc.model;

import java.util.function.BiFunction;

public enum Operator implements Token {
    OPEN("(", 1, null),
    CLOSE(")", 1, null),
    PLUS("+", 2, (number1, number2) -> number1 + number2),
    MINUS("-", 2, (number1, number2) -> number1 - number2),
    MULTIPLE("*", 3, (number1, number2) -> number1 * number2),
    DIVISION("/", 3, (number1, number2) -> {
        if (number2 == 0) {
            throw new RuntimeException();
        }
        return number1 / number2;
    }),
    ;

    private final String sign;
    private final int priority;
    private final BiFunction<Integer, Integer, Integer> action;

    Operator(String sign, int priority, BiFunction<Integer, Integer, Integer> action) {
        this.sign = sign;
        this.priority = priority;
        this.action = action;
    }

    public static Operator find(char currentChar) {
        Operator[] operators = values();
        for (Operator operator : operators) {
            if (operator.sign.equals(String.valueOf(currentChar))) {
                return operator;
            }
        }
        throw new RuntimeException();
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

    public int execute(int number1, int number2) {
        return this.action.apply(number1, number2);
    }

    @Override
    public String toString() {
        return sign;
    }
}
