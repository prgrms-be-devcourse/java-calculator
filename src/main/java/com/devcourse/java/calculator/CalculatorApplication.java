package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import com.devcourse.java.calculator.repository.CalculatorRepositoryImpl;

public class CalculatorApplication {
    public static void main(String[] args) {

        Console console = new Console();
        CalculatorRepository calculatorRepository = new CalculatorRepositoryImpl();

        new Calculator(console, console, calculatorRepository, MenuConstant.START_CALCULATOR_NO_COMMAND).run();
    }
}
