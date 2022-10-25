package org.programmers.java.calculator.model;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {

    RECORD("Record",1),
    CALCULATE("Calculate",2),
    EXIT("Exit", 3),
    ERROR("Error",-1);

    private static final int BAD_REQUEST = -1;

    private final String label;
    private final int code;

    private String getLabel() {
        return this.label;
    }

    private int getCode() {
        return this.code;
    }

    Menu(String label, int code) {
        this.label = label;
        this.code = code;
    }

//    private static final Map<Integer, Menu> BY_CODE =
//            Stream.of(values()).collect(Collectors.toMap(Menu::getCode, Function.identity()));

    public static Menu selectMenu(String input) {
        int code = toCode(input);
        return Arrays.stream(Menu.values())
                .filter(meun -> meun.code == code)
                .findFirst()
                .orElse(ERROR);
    }

    private static int toCode(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            return BAD_REQUEST;
        }
    }
}
