package org.programmers.java.calculation;

import org.programmers.java.message.Error;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Operator {
    PLUS("+", 2, (a, b) -> a + b),
    MINUS("-", 2, (a, b) -> a - b),
    MULTIPLY("*", 1, (a, b) -> a * b),
    DIVIDE("/", 1, (a, b) -> a / b);

    private final String symbol;
    private final int priority;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String symbol, int priority, BiFunction<Integer, Integer, Integer> expression){
        this.symbol = symbol;
        this.priority = priority;
        this.expression = expression;
    }
    private int getPriority() {
        return priority;
    }

    public static boolean comparePriorities(String firstSymbol, String secondSymbol){
        return Operator.findSymbol(firstSymbol).get().getPriority() < Operator.findSymbol(secondSymbol).get().getPriority();
    }

    public static int arithmeticExpression(String symbol, int firstOperand, int secondOperand){
        return findSymbol(symbol).get().expression.apply(firstOperand, secondOperand);
    }

    public static Optional<Operator> findSymbol(String inputSymbol){
        Map<String, Operator> mapCollection = Collections.unmodifiableMap(Stream.of(values()).
                collect(Collectors.toMap(Operator::getSymbol, Function.identity())));

        return Optional.ofNullable(mapCollection.get(inputSymbol));
        // Arrays.stream(values()).filter(operator -> operator.symbol.equals(inputSymbol)).findAny();
    }

    private String getSymbol() {
        return symbol;
    }

    public static boolean isNumber(String inputNumber){
        return Pattern.matches("[0-9]+",inputNumber);
    }

    public static void checkDivideZero(String symbol, int secondOperand){
        if(symbol.equals("/") && secondOperand == 0){
            throw new IllegalArgumentException("0으로 나눌 수 없습니다");
        }
    }
}
