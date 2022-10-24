package com.programmers.java.model.token.letter.bracket;

import com.programmers.java.model.token.Number;
import com.programmers.java.model.token.Token;

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

    public Token getType(String token) {
        return new OpenBracket(token);
    }

    @Override
    public boolean checkNextTokenCorrect(String token) {
        if (getType(token) instanceof Number || getType(token) instanceof OpenBracket) {
            return true;
        }
        return false;
    }
}
