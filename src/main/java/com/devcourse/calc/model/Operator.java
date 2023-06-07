package com.devcourse.calc.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

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

    private static final Map<String, Operator> operators = new HashMap<>();

    private final String sign;

    private final int priority;
    private final BiFunction<Integer, Integer, Integer> action;
    static {
        for (Operator operator : values()) {
            operators.put(operator.sign, operator);
        }
    }

    Operator(String sign, int priority, BiFunction<Integer, Integer, Integer> action) {
        this.sign = sign;
        this.priority = priority;
        this.action = action;
    }

    public static Operator find(char sign) {
        try {
            return operators.get(Character.toString(sign));
        } catch (NullPointerException e) {
            throw new RuntimeException("사용 불가능한 수식 기호입니다 ( '+', '-', '*', '/' ) 중 사용해 주세요");
        }
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

    private static void checkDivideZero(Integer number2) {
        if (number2 == 0) {
            throw new RuntimeException("0으로 나눌 수 없습니다");
        }
    }
}
