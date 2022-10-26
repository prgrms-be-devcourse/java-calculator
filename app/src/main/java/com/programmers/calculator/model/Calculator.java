package com.programmers.calculator.model;

import com.programmers.calculator.domain.OperationResult;

import java.util.Optional;

public interface Calculator {
    default Double plus(Double n1, Double n2) { return n1 + n2; }

    default Double minus(Double n1, Double n2) {
        return n1 - n2;
    }

    default Double multiplication(Double n1, Double n2) {
        return n1 * n2;
    }

    default Optional<Double> division(Double n1, Double n2) {
        if (n2 == 0.0) return Optional.empty();

        return Optional.ofNullable(n1 / n2);
    }

    Optional<OperationResult> calculate(String formula, String[] parsedInputStr);
}
