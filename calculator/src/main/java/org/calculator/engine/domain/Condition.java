package org.calculator.engine.domain;

import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.Optional;

@RequiredArgsConstructor
public enum Condition {
    LOOKUP("1"),
    CALCULATE("2"),
    BREAK("3");

    private final String input;

    public static Optional<Condition> convert(String condition) {
        return Arrays.stream(Condition.values())
                .filter(conditionEnum -> conditionEnum.input.equals(condition))
                .findAny();
    }
}
