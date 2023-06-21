package main.java.service;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    public final String optName;
    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(String optName, BiFunction<Integer, Integer, Integer> biFunction) {
        this.optName = optName;
        this.biFunction = biFunction;
    }

    public String getOptName() {
        return optName;
    }

    public boolean isPlusOrMinus() {
        if(this == PLUS || this == MINUS)
            return true;
        return false;
    }

    public Integer calculateOpt(Integer a, Integer b) {
        return this.biFunction.apply(a, b);
    }

    // for checking valid operator input.
    private static List<String> toStringArray(Operator[] operators) {
        return Arrays.stream(operators)
                .map(Operator::getOptName)
                .collect(Collectors.toList());
    }

    public static boolean isValidOperator(String comp) {
        // Operator 의 optName(+ - / =) 에 해당하는 optNames List를 만들고
        // 인자인 comp가 optNames안에 들어있는지 검사.
        List<String> optNames = toStringArray(Operator.values());
        if(optNames.contains(comp))
            return true;
        return false;
    }

    public static Operator stringToOperator(String operator) {
        return Arrays.stream(values())
                .filter(value -> value.optName.equals(operator))
                .findAny()
                .orElse(null);
    }
}
