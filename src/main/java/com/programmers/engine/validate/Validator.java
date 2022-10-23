package com.programmers.engine.validate;

public class Validator implements BracketValidator, NumOperatorValidator{
    @Override
    public boolean validateBracket(String s) {
        int openBracket = 0, closeBracket = 0;
        return false;
    }

    @Override
    public boolean validateNumberNOperator(String s) {
        return false;
    }
}
