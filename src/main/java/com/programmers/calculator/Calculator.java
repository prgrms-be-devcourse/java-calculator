package com.programmers.calculator;

import com.programmers.calculator.view.ConsoleView;

public class Calculator {

    private final ConsoleView view;

    public Calculator(ConsoleView view) {
        this.view = view;
    }

    public void run() {
        while (true) {
            try {
                view.show();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                return;
            }

        }
    }

}
