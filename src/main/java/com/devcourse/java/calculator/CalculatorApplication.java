package com.devcourse.java.calculator;

import com.devcourse.java.calculator.constant.MenuConstant;
import com.devcourse.java.calculator.repository.CalculatorRepository;
import com.devcourse.java.calculator.util.CalculateUtil;

public class CalculatorApplication {
    public static void main(String[] args) {

        Console console = new Console();
        CalculatorRepository calculatorRepository = new CalculatorRepository();
        CalculateUtil calculateUtil = new CalculateUtil();

        new Calculator(console, console, calculatorRepository, calculateUtil, MenuConstant.START_CALCULATOR_NO_COMMAND)
                .run();
    }
}
