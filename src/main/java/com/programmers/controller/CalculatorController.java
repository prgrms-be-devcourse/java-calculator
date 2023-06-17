package com.programmers.controller;

import com.programmers.domain.Calculator;
import com.programmers.domain.Menu;
import com.programmers.io.Console;

public class CalculatorController {

    private final Console console = new Console();
    private final Calculator calculator = new Calculator(console);

    public void run() {
        boolean activated = true;

        while (activated) {
            Menu menu = console.getValidatedMenuSelection();

            switch (menu) {
                case TERMINATE -> {
                    console.printTermination();
                    activated = false;
                }
                case GET_RESULT -> console.getResults();
                case CALCULATE -> calculator.calculate();
            }
        }
    }
}
