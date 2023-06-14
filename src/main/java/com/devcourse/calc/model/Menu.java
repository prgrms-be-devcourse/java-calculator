package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;
import com.devcourse.view.Input;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public enum Menu {
    HISTORY(1, "조회", Calculator::showHistory),
    CALC(2, "계산", calculator -> calculator.calculate(Input.getFormula()));

    private static final String TO_STRING_TEMPLATE = "%d. %s";
    public static final Map<Integer, Menu> menus = Arrays.stream(values())
            .collect(toMap(menu -> menu.number, identity()));

    private final int number;
    private final String description;
    private final Function<Calculator, Result> action;

    Menu(int number, String description, Function<Calculator, Result> action) {
        this.number = number;
        this.description = description;
        this.action = action;
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
