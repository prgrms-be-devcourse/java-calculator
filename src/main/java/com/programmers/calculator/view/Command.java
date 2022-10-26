package com.programmers.calculator.view;

import java.util.Arrays;
import java.util.Optional;

public enum Command {

    INQUIRY(1),
    CALCULATION(2),
    EXIT(0);

    private final int command;

    Command(int command) {
        this.command = command;
    }

    public static Command of(String input) {
        int commandParse = Integer.parseInt(input);

        return Arrays.stream(values())
                .filter(command -> command.command == commandParse)
                .findFirst()
                .orElseThrow(() -> {
                    throw new IllegalArgumentException("입력값이 잘못 되었습니다.");
                });
    }

    public static boolean canCreate(int selectNumber) {

        Optional<Command> optionalCommand = Arrays.stream(values())
                .filter(command -> command.command == selectNumber)
                .findFirst();

        return optionalCommand.isPresent();
    }
}
