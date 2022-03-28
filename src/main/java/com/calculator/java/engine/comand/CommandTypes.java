package com.calculator.java.engine.comand;

public enum CommandTypes {
    SELECTION("1", "조회"),
    CALCULATION("2", "계산"),
    TERMINATION("3", "종료");

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

    private final String commandId;
    private final String command;
}
