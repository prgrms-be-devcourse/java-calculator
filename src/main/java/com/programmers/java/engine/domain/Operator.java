package com.programmers.java.engine.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operator {
    public List<String> operators;

    public Operator(String input, String operatorPattern){
        operators = new ArrayList<>();
        Matcher operatorMatcher = Pattern.compile(operatorPattern).matcher(input);
        while (operatorMatcher.find()) {
            operators.add(operatorMatcher.group());
        }
    }
}
