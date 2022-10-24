package com.programmers.java.model.token.letter.number;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.bracket.CloseBracket;
import com.programmers.java.model.token.letter.operator.Operator;

public class Number extends Token {
    public Number(String token) {
        super(token);
    }

    public static boolean isNumber(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public Token getType(String token) {
        return new Number(token);
    }

    @Override
    public boolean checkNextTokenCorrect(String token) {
        if (getType(token) instanceof Operator || getType(token) instanceof CloseBracket) {
            return true;
        } else {
            return false;
        }
    }
}
