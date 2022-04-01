package com.waterfogsw.domain;

import com.waterfogsw.exception.NotExistsOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Algebraic implements Operator {
    PLS("+", 2, (x, y) -> x + y),
    MIN("-", 2, (x, y) -> x - y),
    MUL("*", 3, (x, y) -> x * y),
    DIV("/", 3, (x, y) -> {
        if (y == 0) throw new ArithmeticException();
        return x / y;
    });

    private final String symbol;
    private final int priority;
    private final BiFunction<Double, Double, Double> calculateFunc;

    public static Optional<Algebraic> findOperator(String symbol) {
        return Stream.of(values())
                .filter(opcode -> opcode.getSymbol().equals(symbol))
                .findFirst();
    }

    public static boolean isOperator(String symbol) {
        return Stream.of(values())
                .filter(Objects::nonNull)
                .anyMatch(op -> op.getSymbol().equals(symbol));
    }

    public Double calculate(Double x, Double y) {
        return this.calculateFunc.apply(x, y);
    }

    public static Algebraic getOperator(String operator) throws NotExistsOperator {
        Optional<Algebraic> optional = Arrays.stream(Algebraic.values())
                .filter(type -> operator.equals(type.getSymbol()))
                .findFirst();

        if (optional.isEmpty()) throw new NotExistsOperator();

        return optional.get();
    }

}
