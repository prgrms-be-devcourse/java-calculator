package com.project.java.utils;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    RETRIEVE("1"), CALCULATE("2"), QUIT("q"), ANOTHER_QUIT("Q"), WRONG_INPUT("wrong");

    final private String command;

    private Command(String command) {
        this.command = command;
    }
    public String getCommand() {
        return command;
    }

    // "1" : RETRIEVE 식의 맵을 생성
    private static final Map<String, Command> BY_COMMAND = Stream.of(values())
            .collect(Collectors.toMap(Command::getCommand, e -> e));

    private static Command filterNull(Optional<Command> optionalCommand) {
        if(optionalCommand.isEmpty()) return Command.WRONG_INPUT;
        else return optionalCommand.get();
    }

    public static Command valueOfCommand(String command) {
        return filterNull(Optional.ofNullable(BY_COMMAND.get(command)));
    }
}
