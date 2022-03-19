package com.prgrms.ndy.parsor;

import java.util.regex.PatternSyntaxException;

public class RegexParser implements Parser {

    private final String regex;

    public RegexParser(String regex) {
        this.regex = regex;
    }

    @Override
    public CommandUnit parse(String in) {
        checkIsValidExpression(in);

        CommandUnit commandUnit = new CommandUnit();

        return commandUnit;
    }

    private void checkIsValidExpression(String in) {
        if (!in.matches(regex)) {
            throw new PatternSyntaxException("올바른 표현식이 아닙니다.", null, -1);
        }
    }
}
