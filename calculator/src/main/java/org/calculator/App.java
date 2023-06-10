package org.calculator;

import org.calculator.engine.io.Console;
import org.calculator.engine.io.Input;
import org.calculator.engine.io.Output;

public class App {
    public static void main(String[] args) {
        Input input = new Console();
        Output output = new Console();
        new Calculator(input, output).run();
    }
}
