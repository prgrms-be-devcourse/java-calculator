package com.programmers.calculator.model;

import com.programmers.calculator.AppConfig;
import com.programmers.calculator.controller.Controller;
import com.programmers.calculator.domain.OperationResult;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import javax.security.sasl.AuthenticationException;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class ArithmeticOperationCalculatorTest {

    AppConfig appConfig = new AppConfig();
    Controller controller;
    Calculator calculator;

    @BeforeEach
    void beforeEach() {
        controller = appConfig.createController();
        calculator = new ArithmeticOperationCalculator();
    }

    @Test
    @DisplayName("올바른 수식이 넣으면 연산결과를 반환한다.")
    void calculateRightFormula() {
        // given
        String[] inputFormula = new String[] {
                "1 + 1",
                "1 * 3 + 1",
                "1 + 3 * 4",
                "1 / 3 * 4",
                "3.1 + 4.2 + 5.3"
        };

        String[][] parsedInputFormula = new String[inputFormula.length][];
        for (int i = 0; i < 5; i++) {
            parsedInputFormula[i] = controller.parseFolmula(inputFormula[i]);
        }

        // when
        OperationResult operationResult0 = calculator.calculate(inputFormula[0], parsedInputFormula[0]).get();
        OperationResult operationResult1 = calculator.calculate(inputFormula[1], parsedInputFormula[1]).get();
        OperationResult operationResult2 = calculator.calculate(inputFormula[2], parsedInputFormula[2]).get();
        OperationResult operationResult3 = calculator.calculate(inputFormula[3], parsedInputFormula[3]).get();
        OperationResult operationResult4 = calculator.calculate(inputFormula[4], parsedInputFormula[4]).get();

        // then
        assertEquals("2", operationResult0.getResult());
        assertEquals("4", operationResult1.getResult());
        assertEquals("13", operationResult2.getResult());
        assertEquals("1.33", operationResult3.getResult());
        assertEquals("12.6", operationResult4.getResult());
    }

    @Test
    @DisplayName("0으로 나누면 Optional.empty() 반환한다.")
    void calculateWrongFormula() {
        // given
        String inputFormula = "10 * 10 / 0";
        String[] parsedInputFormula = new String[]{"10", "*","10", "/", "0"};

        // when, then
        assertEquals(Optional.empty(), calculator.calculate(inputFormula, parsedInputFormula));
    }
}