package com.programmers.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTokenizer {

    private static final String EXPRESSION_REGEXP = "\\d+|[-+*/]";

    public List<String> expressionSplit(String expression) {
        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(EXPRESSION_REGEXP);
        Matcher matcher = pattern.matcher(expression);

        //stream이용해서
        while (matcher.find()) {
            result.add(matcher.group());
        }

        return result;
    }
}