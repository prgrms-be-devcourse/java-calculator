package me.kimihiqq.options;

import java.util.Optional;

public enum Option {
    LIST("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String value;

    Option(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static Optional<Option> from(String value) {
        for (Option option : Option.values()) {
            if (option.getValue().equals(value)) {
                return Optional.of(option);
            }
        }
        return Optional.empty();
    }
}
