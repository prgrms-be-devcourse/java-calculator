package com.waterfogsw.domain;

import com.waterfogsw.exception.NotExistsOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

@AllArgsConstructor
public enum Operator {
    PLS("+", 2, (x, y) -> x + y),
    MIN("-", 2, (x, y) -> x - y),
    MUL("*", 3, (x, y) -> x * y),
    DIV("/", 3, (x, y) -> {
        if (y == 0) throw new ArithmeticException();
        return x / y;
    }),
    LPR("(", 1, null),
    RPR(")", 1, null);

    public final String symbol;
    private final int priority;
    private final BiFunction<Double, Double, Double> calculateFunc;

    public static boolean comparePri(String code1, String code2) {
        Operator op1 = findOperator(code1);
        Operator op2 = findOperator(code2);
        return op1.priority >= op2.priority;
    }

    private static Operator findOperator(String code) {
        return Stream.of(values())
                .filter(opcode -> opcode.symbol.equals(code))
                .findFirst()
                .orElse(null);
    }

    public static boolean isOperator(String opCode) {
        return Stream.of(values()).
                anyMatch(op -> op.symbol.equals(opCode));
    }

    public Double calculate(Double x, Double y) {
        return this.calculateFunc.apply(x, y);
    }

    public static Operator getOperator(String operator) throws NotExistsOperator {
        Optional<Operator> optional = Arrays.stream(Operator.values())
                .filter(type -> operator.equals(type.symbol))
                .findFirst();

        if (optional.isEmpty()) throw new NotExistsOperator();

        return optional.get();
    }

}
