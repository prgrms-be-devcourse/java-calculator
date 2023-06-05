package com.devcourse.calc.model;

public enum Operator implements Token{
    OPEN("(", 1),
    CLOSE(")", 1),
    PLUS("+", 2),
    MINUS("-", 2),
    MULTIPLE("*", 3),
    DIVISION("/", 3),
    ;

    private final String sign;
    private final int priority;

    Operator(String sign, int priority) {
        this.sign = sign;
        this.priority = priority;
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

    @Override
    public String toString() {
        return sign;
    }
}
