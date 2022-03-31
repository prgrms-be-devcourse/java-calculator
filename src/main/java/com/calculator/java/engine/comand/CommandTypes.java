package com.calculator.java.engine.comand;

import com.calculator.java.exception.WrongInputException;

import java.util.Arrays;

public enum CommandTypes {
    INQUIRY("1", "조회"),
    CALCULATION("2", "계산"),
    TERMINATION("3", "종료");

    private final String commandId;
    private final String command;

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

    public static CommandTypes strToCommandType(String selectedCommand) throws WrongInputException{
        return Arrays.asList(CommandTypes.values()).stream()
                .filter(commandType -> commandType.getCommandId().equals(selectedCommand))
                .findAny()
                .orElseThrow(() -> new WrongInputException());
    }
}
