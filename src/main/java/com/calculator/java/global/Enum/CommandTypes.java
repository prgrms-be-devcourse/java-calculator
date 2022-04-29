package com.calculator.java.global.Enum;

import com.calculator.java.global.exception.WrongInputException;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CommandTypes {
    INQUIRY("1", "조회"),
    CALCULATION("2", "계산"),
    TERMINATION("3", "종료");

    private final String commandId;
    private final String command;
    private static final Map<String, CommandTypes> commandIds =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(CommandTypes::getCommandId, Function.identity())));

    CommandTypes(String commandId, String command) {
        this.commandId = commandId;
        this.command = command;
    }

    public String getCommandId() {
        return commandId;
    }

    @Override
    public String toString() {
        return commandId+". "+command;
    }

    public static CommandTypes findCommandType(String selectedCommand) throws WrongInputException{
        return Optional.ofNullable(commandIds.get(selectedCommand)).orElseThrow(WrongInputException::new);
    }
}
