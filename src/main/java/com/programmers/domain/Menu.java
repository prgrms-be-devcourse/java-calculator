package com.programmers.domain;

import com.programmers.exception.SelectionEmptyException;
import com.programmers.exception.SelectionFormatException;

import java.util.Arrays;
import java.util.Objects;

public enum Menu {

    GET_RESULT("1"),
    CALCULATE("2"),
    TERMINATE("3");

    private final String number;

    Menu(String number) {
        this.number = number;
    }

    public static Menu findMenu(String input) {
        if (input.isEmpty()) {
            throw new SelectionEmptyException();
        }

        return Arrays.stream(Menu.values())
                .filter(menu -> Objects.equals(menu.number, input))
                .findAny()
                .orElseThrow(SelectionFormatException::new);
    }
}
