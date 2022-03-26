package com.waterfogsw.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.stream.Stream;

@AllArgsConstructor
@Getter
public enum Operator {
    PLS("+", 2),
    MIN("-", 2),
    MUL("*", 3),
    DIV("/", 3),
    LPR("(", 1),
    RPR(")", 1);

    private final String code;
    private final int pri;

    public static boolean comparePri(String code1, String code2) {
        Operator op1 = findOperator(code1);
        Operator op2 = findOperator(code2);
        return op1.pri >= op2.pri;
    }

    private static Operator findOperator(String code) {
        return Stream.of(values())
                .filter(opcode -> opcode.code.equals(code))
                .findFirst()
                .orElse(null);
    }

    public static boolean isOperator(String opCode) {
        return Stream.of(values()).
                anyMatch(op -> op.getCode().equals(opCode));
    }
}
