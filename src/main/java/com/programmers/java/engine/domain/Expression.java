package com.programmers.java.engine.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Data
public class Expression {
    public List<Operator> operators = new ArrayList<>();
    public List<Operand> operands;

    public Expression(String input, String operatorPattern){
        Matcher operatorMatcher = Pattern.compile(operatorPattern).matcher(input);
        while (operatorMatcher.find()) {
            String optStr = operatorMatcher.group();
            Operator opt = BasicOperator.initFromPattern(optStr);
            operators.add(opt);
        }
        this.operands = Arrays.stream(input.split(operatorPattern))
                .map((String number) -> new Operand(Double.valueOf(number))).collect(Collectors.toList());
    }
}
