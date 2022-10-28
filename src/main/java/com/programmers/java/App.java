package com.programmers.java;

import com.programmers.java.controller.CalculatorController;
import com.programmers.java.calculator.parser.InfixToPostFixParser;
import com.programmers.java.calculator.validator.InfixValidator;
import com.programmers.java.data.MapRepository;
import com.programmers.java.io.console.ConsoleInput;
import com.programmers.java.io.console.ConsoleOutput;
import com.programmers.java.io.Input;
import com.programmers.java.io.Output;

public class App {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        MapRepository store = new MapRepository();
        InfixToPostFixParser parseInput = new InfixToPostFixParser();
        InfixValidator validator = new InfixValidator();

        CalculatorController calculator = new CalculatorController(input, output, store, validator, parseInput);
        calculator.run();

    }
}

