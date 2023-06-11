package com.programmers.java.calculator.model;

import com.programmers.java.calculator.MenuType;
import com.programmers.java.calculator.io.Input;
import com.programmers.java.calculator.io.Output;

public class Calculator {

    private final Input input;
    private final Output output;

    public Calculator(Input input, Output output) {
        this.input = input;
        this.output = output;
    }

    public void run() {
        while (true) {
            try {
                String inputMenuType = input.input(MenuType.getMenu());
                MenuType selecedtmenuType = MenuType.of(inputMenuType);

                switch (selecedtmenuType) {
                    case HISTORY -> System.out.println("조회 중");
                    case CALCULATE -> System.out.println("계산 중");
                    case END -> {
                        return;
                    }
                }
            } catch (IllegalArgumentException e) {
                output.inputError(e.getMessage());
            }
        }
    }
}
