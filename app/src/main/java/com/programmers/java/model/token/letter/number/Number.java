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

    @Override
    public boolean checkNextTokenCorrect(Token nextToken) {
        if (nextToken instanceof Operator || nextToken instanceof CloseBracket) {
            return true;
        } else {
            return false;
        }
    }
}
