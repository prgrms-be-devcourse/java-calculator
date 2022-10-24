package com.programmers.java.model.token.letter.operator;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.OpenBracket;
import com.programmers.java.model.token.letter.number.Number;

public class MinusOperator extends Operator {
    public MinusOperator(String token) {
        super(token);
    }

    public static boolean isMinus(String token) {
        if (token.equals("-")) {
            return true;
        }
        return false;
    }

    public Token getType(String token) {
        return new MinusOperator(token);
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
        return num1 - num2;
    }
}
