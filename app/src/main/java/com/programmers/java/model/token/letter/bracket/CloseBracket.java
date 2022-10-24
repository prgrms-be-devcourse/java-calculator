package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.operator.Operator;

public class CloseBracket extends Token {
    public CloseBracket(String token) {
        super(token);
    }

    public static boolean isClose(String token) {
        if (token.equals(")")) {
            return true;
        }
        return false;
    }

    public Token getType(String token) {
        return new CloseBracket(token);
    }

    @Override
    public boolean checkNextTokenCorrect(String token) {
        if (getType(token) instanceof Operator || getType(token) instanceof CloseBracket) {
            return true;
        }
        return false;
    }
}
