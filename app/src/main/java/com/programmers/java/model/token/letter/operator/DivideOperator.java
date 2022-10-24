package com.programmers.java.model.token.letter.operator;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.letter.number.Number;

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

    @Override
    public boolean checkNextTokenCorrect(Token nextToken) {
        if (nextToken instanceof Number || nextToken instanceof OpenBracket) {
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
