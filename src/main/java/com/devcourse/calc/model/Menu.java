package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;
import com.devcourse.view.Input;

import java.util.Arrays;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum Menu {
    HISTORY(1, "조회"),
    CALC(2, "계산");

    private static final String TO_STRING_TEMPLATE = "%d. %s";
    private static final Map<Integer, Menu> menus = Arrays.stream(values())
            .collect(toMap(menu -> menu.number, identity()));

    private final int number;
    private final String description;

    Menu(int number, String description) {
        this.number = number;
        this.description = description;
    }

    public static Menu find(int selectedNumber) {
        return menus.get(selectedNumber);
    }

    public String execute(Calculator calculator) {
        return action.apply(calculator).toString();
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, this.number, this.description);
    }
}
