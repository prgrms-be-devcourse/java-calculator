package com.programmers.calculator;

import com.programmers.calculator.view.View;

public class Application {

    public static void main(String[] args) {

        View view = null;
        Calculator calculator = new Calculator(view);

        calculator.run();
    }

}
