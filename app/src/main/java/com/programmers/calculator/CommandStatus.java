package com.programmers.calculator;

import java.util.stream.Stream;

public enum CommandStatus {
    CALCULATE(1),
    PRINT_LAST_ALL_OPERATION_RESULT(2);

    private int number;

    CommandStatus(int number) {
        this.number = number;
    }

    public static CommandStatus selectCommand(int cmd) {
        return Stream.of(values())
                .filter(cmdStatus -> cmdStatus.number == cmd)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 Command입니다."));
    }
}
