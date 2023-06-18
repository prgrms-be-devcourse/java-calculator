package com.programmers.calculator.model;

public enum Operator {
    PLUS, MINUS, MULTIPLY, DIVIDE;


    public static Operator of(char c) {
        return switch (c) {
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> MULTIPLY;
            case '/' -> DIVIDE;
            default -> throw new IllegalStateException("알 수 없는 연산자 입니다: " + c);
        };
    }

    public static int compare(char c, Operator peek) {
        Operator now = of(c);
        if (now == MULTIPLY || now == DIVIDE) {
            if (peek == PLUS || peek == MINUS) {
                return 1;
            }
        }
        if (now == PLUS || now == MINUS) {
            if (peek == MULTIPLY || peek == DIVIDE) {
                return -1;
            }
        }
        return 0;
    }

    public char get() {
        return switch (this) {
            case PLUS -> '+';
            case MINUS -> '-';
            case MULTIPLY -> '*';
            case DIVIDE -> '/';
        };
    }
}
