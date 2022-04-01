package com.waterfogsw.domain;

import com.waterfogsw.exception.NotExistsOperator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;
import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Parentheses implements Operator {
    LEFT("(", 1),
    RIGHT(")", 1);

    private String symbol;
    private int priority;

    public static boolean isOperator(String opCode) {
        return Stream.of(values()).
                anyMatch(op -> op.getSymbol().equals(opCode));
    }

    public static Optional<Parentheses> findOperator(String symbol) {
        return Stream.of(values())
                .filter(opcode -> opcode.getSymbol().equals(symbol))
                .findFirst();
    }
}
