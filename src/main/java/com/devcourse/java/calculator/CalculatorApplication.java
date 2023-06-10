package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.repository.CalculatorRepository;

public class CalculatorApplication {
    public static void main(String[] args) {

        Console console = new Console();
        CalculatorRepository calculatorRepository = new CalculatorRepository();

        new Calculator(console, console, calculatorRepository, MenuConstant.START_CALCULATOR_NO_COMMAND).run();
    }
}
