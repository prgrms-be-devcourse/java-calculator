package com.devcourse.calc.model;

import com.devcourse.calc.Calculator;
import com.devcourse.view.Input;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public enum Menu {
    NONE(0, "0번 메뉴는 할당하지 마세요", calculator -> {
        throw new RuntimeException("없는 메뉴");
    }),
    HISTORY(1, "조회", Calculator::showHistory),
    CALC(2, "계산", calculator -> calculator.calculate(Input.getFormula()));

    private static final String TO_STRING_TEMPLATE = "%d. %s\n";
    private static final Map<Integer, Menu> menus = new HashMap<>();

    private final int number;
    private final String description;
    private final Function<Calculator, Object> action;

    static {
        for (Menu menu : values()) {
            menus.put(menu.number, menu);
        }
    }

    Menu(int number, String description, Function<Calculator, Object> action) {
        this.number = number;
        this.description = description;
        this.action = action;
    }

    public static Menu find(int selectedNumber) {
        return menus.get(selectedNumber);
    }

    public Object execute(Calculator calculator) {
        return action.apply(calculator);
    }

    @Override
    public String toString() {
        return String.format(TO_STRING_TEMPLATE, this.number, this.description);
    }
}
