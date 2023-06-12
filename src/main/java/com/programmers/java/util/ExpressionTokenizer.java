package com.programmers.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTokenizer {

    private static final String OPERATOR_REGEXP = "\\d+|[-+*/]";

    public List<String> expressionSplit(String expression) {

        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(OPERATOR_REGEXP);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }
}