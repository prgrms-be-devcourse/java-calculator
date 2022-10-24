package com.programmers.java.model.token.letter.operator;

import com.programmers.java.model.token.Number;
import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.OpenBracket;

public class DivideOperator extends Operator {
    public DivideOperator(String token) {
        super(token);
    }

    public static boolean isDivide(String token) {
        if (token.equals("/")) {
            return true;
        }
        return false;
    }

    public Token getType(String token) {
        return new DivideOperator(token);
    }

    @Override
    public boolean checkNextTokenCorrect(String token) {
        if (getType(token) instanceof Number || getType(token) instanceof OpenBracket) {
            return true;
        }
        return false;
    }

    @Override
    public int calculate(int num1, int num2) {
        try {
            return num1 / num2;
        } catch (ArithmeticException e) {
            throw new ArithmeticException();
        }
    }
}
