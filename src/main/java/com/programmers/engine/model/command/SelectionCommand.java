package com.programmers.engine.model.command;

public enum SelectionCommand {
    HISTORY("1"), CALCULATION("2");

    private String number;

    SelectionCommand(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public static SelectionCommand getOption(String number) {
        return switch (number) {
            case "1" -> HISTORY;
            case "2" -> CALCULATION;
            default -> throw new IllegalArgumentException("1 또는 2 를 입력해 주세요");
        };
    }
}
