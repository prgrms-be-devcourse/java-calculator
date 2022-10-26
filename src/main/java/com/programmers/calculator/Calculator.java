package com.programmers.calculator;

import com.programmers.calculator.view.View;

public class Calculator {

    private final View view;

    public Calculator(View view) {
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
