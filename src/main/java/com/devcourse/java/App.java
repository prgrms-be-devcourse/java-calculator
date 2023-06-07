package com.devcourse.java;

import com.devcourse.java.common.Factory;
import com.devcourse.java.domain.Runner.CalculatorRunner;
import com.devcourse.java.domain.console.Console;
import com.devcourse.java.domain.console.Input;
import com.devcourse.java.domain.console.Output;
import com.devcourse.java.domain.console.implementation.InputImpl;
import com.devcourse.java.domain.console.implementation.OutputImpl;
import com.devcourse.java.domain.menu.MenuFactory;

public class App {
    public static void main(String[] args) {
        Input reader = new InputImpl();
        Output writer = new OutputImpl();
        Console console = new Console(reader, writer);
        Factory menuFactory = new MenuFactory();

        CalculatorRunner calculatorRunner = new CalculatorRunner(menuFactory, console);
        calculatorRunner.run();
    }
}
