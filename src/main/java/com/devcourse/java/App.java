package com.devcourse.java;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.Runner.CalculatorRunner;
import com.devcourse.java.domain.menu.MenuFactory;

public class App {
    public static void main(String[] args) {
        Factory menuFactory = new MenuFactory();

        CalculatorRunner calculatorRunner = new CalculatorRunner(menuFactory);
        calculatorRunner.run();
    }
}
