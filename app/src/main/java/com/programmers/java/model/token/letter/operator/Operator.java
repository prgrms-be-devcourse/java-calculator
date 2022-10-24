package com.programmers.java.model.token.letter.operator;

import com.programmers.java.model.token.Token;

public abstract class Operator extends Token {
    public Operator(String token) {
        super(token);
    }

    public static boolean isOperator(String token) {
        if (token.equals("+")
                || token.equals("-")
                || token.equals("*")
                || token.equals("/")) {
            return true;
        }
        return false;
    }

    public abstract int calculate(int num1, int num2);
}
