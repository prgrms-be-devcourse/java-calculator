package org.programmers.java.calculation;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.regex.Pattern;

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
        return Operator.isSymbol(firstSymbol).get().getPriority() > Operator.isSymbol(secondSymbol).get().getPriority();

    }

    public static int arithmeticExpression(String symbol, int firstOperand, int secondOperand){
        return isSymbol(symbol).get().expression.apply(firstOperand, secondOperand);
    }


    public static Optional<Operator> isSymbol(String inputSymbol){
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(inputSymbol))
                .findAny();
    }

    public static boolean isNumber(String inputNumber){
        return Pattern.matches("[0-9]+",inputNumber);
    }
}
