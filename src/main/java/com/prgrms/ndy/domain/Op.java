package com.prgrms.ndy.domain;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Op {
    ADD('+', (a, b) -> a + b),
    SUB('-', (a, b) -> a - b),
    MUL('*', (a, b) -> a * b),
    DIV('/', (a, b) -> a / b);

    private final char code;

    private final BiFunction<Double, Double, Double> op;

    Op(char code, BiFunction<Double, Double, Double> op) {
        this.code = code;
        this.op = op;
    }

    public char getCode() {
        return code;
    }

    public static Optional<Op> of(char code) {
        return Arrays.stream(Op.values())
                .filter(op -> op.code == code)
                .findFirst();
    }

    public Double apply(Double a, Double b) {
        return op.apply(a, b);
    }
}
