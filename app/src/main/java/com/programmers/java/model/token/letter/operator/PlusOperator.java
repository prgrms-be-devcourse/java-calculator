package com.programmers.java.model.token.letter.operator;

import com.programmers.java.model.token.Number;
import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.OpenBracket;

public class PlusOperator extends Operator {
    public PlusOperator(String token) {
        super(token);
    }

    public static boolean isPlus(String token) {
        if (token.equals("+")) {
            return true;
        }
        return false;
    }

    public Token getType(String token) {
        return new PlusOperator(token);
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
        return num1 + num2;
    }
}
