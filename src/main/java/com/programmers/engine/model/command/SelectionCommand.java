package com.programmers.engine.model.command;

import com.programmers.engine.exception.CalculatorErrorCode;
import com.programmers.engine.exception.CalculatorException;

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
            default -> throw new CalculatorException(CalculatorErrorCode.SELECTION_ERROR);
        };
    }
}
