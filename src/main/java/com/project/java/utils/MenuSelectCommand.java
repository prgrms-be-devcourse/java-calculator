package com.project.java.utils;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MenuSelectCommand {
    RETRIEVE("1"), CALCULATE("2"), QUIT("q"), ANOTHER_QUIT("Q"), WRONG_INPUT("wrong");

    final private String command;

    private MenuSelectCommand(String command) {
        this.command = command;
    }
    public String getCommand() {
        return command;
    }

    // "1" : RETRIEVE 식의 맵을 생성
    private static final Map<String, MenuSelectCommand> BY_COMMAND = Stream.of(values())
            .collect(Collectors.toMap(MenuSelectCommand::getCommand, e -> e));

    private static MenuSelectCommand filterNull(Optional<MenuSelectCommand> optionalCommand) {
        if(optionalCommand.isEmpty()) return MenuSelectCommand.WRONG_INPUT;
        else return optionalCommand.get();
    }

    public static MenuSelectCommand valueOfCommand(String command) {
        return filterNull(Optional.ofNullable(BY_COMMAND.get(command)));
    }
}
