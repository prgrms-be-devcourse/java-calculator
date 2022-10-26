package org.programmers.java;

import org.programmers.java.calculator.Calculator;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.io.Input;
import org.programmers.java.calculator.io.Output;

public class App {
    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        calculator.run();
    }
}