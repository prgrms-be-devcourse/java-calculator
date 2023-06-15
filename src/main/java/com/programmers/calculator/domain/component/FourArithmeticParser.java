package com.programmers.calculator.domain.component;

import com.programmers.calculator.constant.RegexEnum;
import com.programmers.calculator.domain.vo.Expression;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;

public class FourArithmeticParser implements Parser {

    public List<String> parseToTokens(Expression expression) {
        List<String> tokens = new ArrayList<>();
        Matcher matcher = RegexEnum.FOUR_ARITHMETIC.getPattern().matcher(expression);

        while (matcher.find()) {
            tokens.add(matcher.group());
        }

        return tokens;
    }

}
