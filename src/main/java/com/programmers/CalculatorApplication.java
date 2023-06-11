package com.programmers;

import com.programmers.io.ConsoleInput;
import com.programmers.io.ConsoleOutput;
import com.programmers.io.Input;
import com.programmers.io.Output;

public class CalculatorApplication {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();

        CalculatorController calculatorController = new CalculatorController(input, output);
        calculatorController.run();
    }
}
