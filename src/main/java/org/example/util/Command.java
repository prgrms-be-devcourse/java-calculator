package org.example.util;

import java.util.Arrays;

public enum Command {
    HISTORY("1"),
    CALCULATE("2"),
    END("3");

    private final String number;

    Command(String number) {
        this.number = number;
    }

    public static Command getCommand(String input) {
        return Arrays.stream(Command.values())
                .filter(cmd -> cmd.number.equals(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }}
