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

    @Override
    public boolean checkNextTokenCorrect(Token nextToken) {
        if (nextToken instanceof Operator || nextToken instanceof CloseBracket) {
            return true;
        }
        return false;
    }
}
