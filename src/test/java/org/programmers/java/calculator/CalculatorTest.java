package org.programmers.java.calculator;

import org.junit.jupiter.api.Test;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void run() {
        //given
        CalculatorRepositoryImpl calculatorRepositoryImpl = new CalculatorRepositoryImpl();
        CalculatorServiceImpl calculatorServiceImpl = new CalculatorServiceImpl(calculatorRepositoryImpl);
        CalculatorController calculatorController = new CalculatorController(calculatorServiceImpl);
        Console console = new Console();
        Calculator calculator = new Calculator(calculatorController, console);

        //when

        //then
    }
}