package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.Token;
import com.programmers.java.model.token.letter.number.Number;

public class OpenBracket extends Token {
    public OpenBracket(String token) {
        super(token);
    }

    public static boolean isOpen(String token) {
        if (token.equals("(")) {
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
}
