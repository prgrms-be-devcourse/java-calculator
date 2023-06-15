package com.bona.javacalculator.core;

import com.bona.javacalculator.util.Validator;

public enum Option {
    EXIT(3), INVALID_INPUT(0), INQUIRY(1), CALCULATE(2);

    private int matchNum;

    Option(int matchNum) {
        this.matchNum = matchNum;
    }

    public static Option valueOf(int matchNum) {
        Option option;
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

    public static Option of(String input) {

        for (Option value : values()) {
            if (value.matchNum == Integer.parseInt(input)) {
                return value;
            }
        }

        throw new RuntimeException("wrong input");
    }

    private int parse(String input) {
        if (input.isBlank()) {
            return 3; // EXIT
        }
        if (!Validator.isNumber(input)) {
            return 0; //INVALID_INPUT
        }
        return Integer.parseInt(input);
    }

}
