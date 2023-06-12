package com.programmers.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionTokenizer {

    private static final String REGEXP = "\\d+|[-+*/]";

    // 연산자와 피연사자를 정규식을 이용해서 분리하는 역할을 담당한다.
    public List<String> expressionSplit(String expression) {

        List<String> result = new ArrayList<>();
        Pattern pattern = Pattern.compile(REGEXP);
        Matcher matcher = pattern.matcher(expression);

        while (matcher.find()) {
            result.add(matcher.group());
        }
        return result;
    }
}