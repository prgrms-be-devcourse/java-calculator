package com.programmers;

import com.programmers.calculator.Calculator;
import com.programmers.calculator.CalculatorController;
import com.programmers.calculator.CalculatorMemory;
import com.programmers.calculator.io.ConsoleInput;
import com.programmers.calculator.io.ConsoleOutput;
import com.programmers.calculator.io.Input;
import com.programmers.calculator.io.Output;

public class Application {
    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Output output = new ConsoleOutput();
        CalculatorMemory calculatorMemory = new CalculatorMemory();
        Calculator calculator = new Calculator(calculatorMemory);

        CalculatorController calculatorController = new CalculatorController(input, output, calculator);
        calculatorController.run();
    }
}
