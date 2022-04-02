package com.programmers.java.engine.domain;

import lombok.AllArgsConstructor;
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
    public List<Operand> operands = new ArrayList<>();

    public Expression(String input, String operatorPattern){
        Matcher operatorMatcher = Pattern.compile(operatorPattern).matcher(input);
        while (operatorMatcher.find()) {
            String optStr = operatorMatcher.group();
            Operator opt = switch (optStr) {
                case "+" -> Operator.PLUS;
                case "-" -> Operator.MINUS;
                case "*" -> Operator.MULTIPLY;
                case "/" -> Operator.DIVIDE;
                default -> throw new IllegalArgumentException();
            };
            operators.add(opt);
        }
        this.operands = Arrays.stream(input.split(operatorPattern))
                .map((String number) -> new Operand(Double.valueOf(number))).collect(Collectors.toList());
    }
}
