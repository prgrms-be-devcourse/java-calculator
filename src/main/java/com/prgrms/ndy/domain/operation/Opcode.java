package com.prgrms.ndy.domain.operation;

import java.util.Optional;
import java.util.function.BiFunction;

public enum Opcode {
    ADD('+', (a, b) -> a + b),
    SUB('-', (a, b) -> a - b),
    MUL('*', (a, b) -> a * b),
    DIV('/', (a, b) -> a / b);

    private final char code;

    private final BiFunction<Double, Double, Double> op;

    Opcode(char code, BiFunction<Double, Double, Double> op) {
        this.code = code;
        this.op = op;
    }

    public char getCode() {
        return code;
    }

    public static Optional<Opcode> of(char code) {
        for (Opcode opcode : Opcode.values()) {
            if (opcode.code == code) {
                return Optional.of(opcode);
            }
        }
        return Optional.empty();
    }

    public Double apply(Double a, Double b) {
        return op.apply(a,b);
    }
}
