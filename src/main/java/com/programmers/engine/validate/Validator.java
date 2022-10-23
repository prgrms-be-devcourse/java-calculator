package com.programmers.engine.validate;

public class Validator implements BracketValidator, NumOperatorValidator{
    @Override
    public boolean validateBracket(String s) {
        return false;
    }

    @Override
    public boolean validateNumberNOperator(String s) {
        return false;
    }
}
