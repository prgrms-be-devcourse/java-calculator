package org.calculator.engine.domain;

import java.util.Optional;

public enum Condition {
    LOOKUP, CALCULATE, BREAK;

    public static Optional<Condition> decideCondition(String condition) {
        if (condition.equals("1")) {
            return Optional.of(LOOKUP);
        }
        if (condition.equals("2")) {
            return Optional.of(CALCULATE);
        }
        if (condition.equals("3")) {
            return Optional.of(BREAK);
        }
        return Optional.empty();
    }
}
