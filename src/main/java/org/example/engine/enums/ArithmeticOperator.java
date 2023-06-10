package org.example.engine.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;


public enum ArithmeticOperator {
    ADDITION("+", 1),
    SUBTRACTION("-", 1),
    MULTIPLICATION("*", 2),
    DIVISION("/", 2);

    private String arithmeticOperator;
    private final int priority;

    ArithmeticOperator(String arithmeticOperator, int priority) {
        this.arithmeticOperator = arithmeticOperator;
        this.priority = priority;
    }

    public String getArithmeticOperator() {
        return arithmeticOperator;
    }

    public int getPriority() {
        return priority;
    }

    public static ArithmeticOperator getArithmeticOperator(String arithmeticOperator) {
        return Arrays.stream(values())
                .filter(o -> o.arithmeticOperator.equals(arithmeticOperator))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }

    public static int comparePriority(ArithmeticOperator operator1, ArithmeticOperator operator2) {
        return Integer.compare(operator1.getPriority(), operator2.getPriority());
    }

}
