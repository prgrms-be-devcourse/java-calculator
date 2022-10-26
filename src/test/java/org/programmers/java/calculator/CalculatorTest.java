package org.programmers.java.calculator;

import org.junit.jupiter.api.Test;
import org.programmers.java.calculator.controller.CalculatorController;
import org.programmers.java.calculator.io.Console;
import org.programmers.java.calculator.repository.CalculatorRepository;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;
import org.programmers.java.calculator.service.CalculatorService;
import org.programmers.java.calculator.service.impl.CalculatorServiceImpl;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void run() {
        //given
        CalculatorController calculatorController = new CalculatorController();
        CalculatorService calculatorService = new CalculatorServiceImpl();
        CalculatorRepository calculatorRepository = new CalculatorRepositoryImpl();
        Console console = new Console();

        Calculator calculator = new Calculator();

        //when
        calculator.run();

        //then

    }
}