package app.calculator;

import java.util.Arrays;

// 처음 메뉴에서 고를 3가지 경우
public enum Select {
    NONE("0"),
    LOOK_UP("1"),
    CALCULATE("2"),
    EXIT("3");

    private final String selectInput;

    Select(String selectInput) {
        this.selectInput = selectInput;
    }

    public static Select findSelect(String inputValue) {
        return Arrays.stream(values())
                .filter(select -> select.isSameSelectInput(inputValue))
                .findAny().orElse(Select.NONE);
    }

    private boolean isSameSelectInput(String inputValue) {
        return selectInput.equals(inputValue);
    }
}