package com.programmers.calculator.constant;

import java.util.Arrays;

public enum OptionType {
    EXIT("0"),
    HISTORY("1"),
    CALCULATION("2");

    private static final OptionType[] OPTION_TYPES = OptionType.values();

    private final String inputOption;

    OptionType(String inputOption) {
        this.inputOption = inputOption;
    }

    public String getInputOption() {
        return inputOption;
    }

    public static OptionType of(String inputOption) {
        return Arrays.stream(OPTION_TYPES)
                .filter(optionType -> optionType.inputOption.equals(inputOption))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("유효하지 않은 메뉴입니다."));
    }

}

