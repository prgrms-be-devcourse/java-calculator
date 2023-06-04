package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;

import java.util.function.Function;

public enum Menu {
    NONE(0, "default do not use zero number", calculator -> {throw new RuntimeException("없는 메뉴");}),
    HISTORY(1, "조회", Calculator::showHistory),
    CALC(2, "계산", Calculator::calc),
    ;

    private final Integer number;
    private final String description;
    private final Function<Calculator, String> action;

    Menu(Integer number, String description, Function<Calculator, String> action) {
        this.number = number;
        this.description = description;
        this.action = action;
    }

    public static String doAction(int selectedNumber, Calculator calculator) {
        Menu selected = NONE;
        Menu[] menus = values();
        for (Menu menu : menus) {
            if (menu.number == selectedNumber) {
                selected = menu;
                break;
            }
        }
        return selected.action.apply(calculator);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(number)
                .append(". ")
                .append(description)
                .append("\n");
        return result.toString();
    }
}
