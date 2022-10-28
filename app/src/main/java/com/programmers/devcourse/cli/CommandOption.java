package com.programmers.devcourse.cli;

public enum CommandOption {
    INQUIRY(1),
    CALCULATE(2),
    EXIT(3);

    public int value;
    CommandOption(int value) {
        this.value = value;
    }
}
