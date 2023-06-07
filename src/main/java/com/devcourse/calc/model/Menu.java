package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;
import com.devcourse.view.Input;

import java.util.Arrays;
import java.util.function.Function;

public enum Menu {
    NONE(0, "default do not use zero number", calculator -> {throw new RuntimeException("없는 메뉴");}),
    HISTORY(1, "조회", Calculator::showHistory),
    CALC(2, "계산", calculator -> calculator.calculate(Input.getFormula()));

    private static final String TO_STRING_TEMPLATE = "%d. %s\n";

    private final int number;
    private final String description;
    private final Function<Calculator, Object> action;

    Menu(int number, String description, Function<Calculator, Object> action) {
        this.number = number;
        this.description = description;
        this.action = action;
    }

    public static String doAction(int selectedNumber, Calculator calculator) {
        Menu selected = Arrays.stream(values())
                .filter(menu -> menu.number == selectedNumber)
                .findFirst()
                .orElse(NONE);
        return selected.action.apply(calculator).toString();
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, this.number, this.description);
    }
}
