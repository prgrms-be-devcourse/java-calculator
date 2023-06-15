package com.bona.javacalculator.core;


public enum Option {
    EXIT(3), INQUIRY(1), CALCULATE(2);

    private int matchNum;

    Option(int matchNum) {
        this.matchNum = matchNum;
    }


    public static Option of(String input) {

        for (Option value : values()) {
            if (value.matchNum == Integer.parseInt(input)) {
                return value;
            }
        }

        throw new RuntimeException("입력이 잘못되었습니다.");
    }

}
