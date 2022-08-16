package com.programmers.calculator;

import com.programmers.calculator.engine.Calculator;
import com.programmers.calculator.engine.io.Console;
import com.programmers.calculator.engine.io.Input;
import com.programmers.calculator.engine.io.Output;
import com.programmers.calculator.engine.repository.CalculatorRepository;
import com.programmers.calculator.engine.repository.MemoryCalculatorRepository;
import com.programmers.calculator.engine.validation.CalculatorValidator;
import com.programmers.calculator.engine.validation.Validator;

public class App {
    public static void main(String[] args) {
        CalculatorRepository calculatorRepository = new MemoryCalculatorRepository();
        Validator validator = new CalculatorValidator();
        Input input = new Console();
        Output output = new Console();
        new Calculator(input, output, calculatorRepository, validator).run();
    }
}
