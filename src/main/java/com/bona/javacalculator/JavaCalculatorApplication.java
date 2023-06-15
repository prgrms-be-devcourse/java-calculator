package com.bona.javacalculator;

import com.bona.javacalculator.core.calculator.Calculator;
import com.bona.javacalculator.io.Console;
import com.bona.javacalculator.core.CalculatorManager;
import com.bona.javacalculator.core.converter.Converter;
import com.bona.javacalculator.core.converter.PostfixConverter;
import com.bona.javacalculator.repository.CalMemoryRepository;
import com.bona.javacalculator.repository.MemoryRepository;
import com.bona.javacalculator.util.Validator;

public class JavaCalculatorApplication {

    public static void main(String[] args) {
        MemoryRepository repository = new CalMemoryRepository();
        Console console = new Console();
        Converter converter = new PostfixConverter();
        Validator validator = new Validator();
        Calculator calculator = new Calculator();

        CalculatorManager calculatorManager = new CalculatorManager(calculator, repository, console, converter, validator);


        calculatorManager.run();
    }

}
