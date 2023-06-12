package com.programmers.java.calculator;

import com.programmers.java.calculator.converter.PostfixExpressionConverter;
import com.programmers.java.calculator.io.Console;
import com.programmers.java.calculator.model.Calculator;
import com.programmers.java.calculator.repository.MemoryCalculatorRepository;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.service.CalculatorServiceImpl;
import com.programmers.java.calculator.validation.ExpressionValidator;
import com.programmers.java.calculator.validation.Validator;

public class CalculatorApplication {

    public static void main(String[] args) {
        Console console = new Console();
        CalculatorService calculatorService = new CalculatorServiceImpl(new PostfixExpressionConverter(), new MemoryCalculatorRepository());
        Validator validator = new ExpressionValidator();

        new Calculator(console, console, calculatorService, validator).run();
    }
}