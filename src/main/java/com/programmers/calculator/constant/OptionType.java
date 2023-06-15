package com.programmers.calculator.constant;

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
        for (OptionType optionType : OPTION_TYPES) {
            if (optionType.inputOption.equals(inputOption)) {
                return optionType;
            }
        }

        throw new IllegalArgumentException("유효하지 않은 메뉴입니다.");
    }

}

