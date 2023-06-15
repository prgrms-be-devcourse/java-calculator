package com.programmers.blackdog.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import static com.programmers.blackdog.domain.ArithmeticOperators.values;

public class RegexGenerator {

    private static final String REGEX_PREFIX = "^\\d+\\s([";
    private static final String REGEX_SUFFIX = "]\\s\\d+\\s)+$";

    public String generateWithOperator(ArithmeticOperators... arithmeticOperators) {
        StringBuilder operators = new StringBuilder();
        for (ArithmeticOperators arithmeticOperator : arithmeticOperators) {
            operators.append(arithmeticOperator.getOperator());
        }
        return REGEX_PREFIX + operators.append(REGEX_SUFFIX);
    }

    public String generateWithAllOperator() {
        String allOperators = Arrays.stream(values())
                .map(ArithmeticOperators::getOperator)
                .collect(Collectors.joining());
        return REGEX_PREFIX + allOperators + REGEX_SUFFIX;
    }
}
