package org.programmers.calculator;

import java.util.Optional;

public enum Option {
    QUERY(1),
    CALC(2),
    EXIT(0);

    private final int number;

    Option(int number) {
        this.number = number;
    }


    public static Optional<Option> findByNumber(String num) {
        for (Option option : Option.values()) {
            if (option.number == Integer.parseInt(num)) {
                return Optional.of(option);
            }
        }
        return Optional.empty();
    }
}