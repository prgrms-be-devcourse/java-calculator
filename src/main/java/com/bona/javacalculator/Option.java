package com.bona.javacalculator;

public enum Option {
    EXIT(3),
    INVALID_INPUT(0),
    INQUIRY(1),
    CALCULATE(2);

    private int matchNum;

    Option(int matchNum) {
        this.matchNum = matchNum;
    }

    public static Option valueOf(int matchNum) {
        Option option = null;
        switch (matchNum) {
            case 3:
                option = Option.EXIT;
                return option;
            case 1:
                option = Option.INQUIRY;
                return option;
            case 2:
                option = Option.CALCULATE;
                return option;
            default:
                option = Option.INVALID_INPUT;
                return option;

        }

    }
}
