package org.programmers.java.calculator.service.impl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.programmers.java.calculator.repository.impl.CalculatorRepositoryImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorServiceImplTest {

    private final CalculatorServiceImpl calculatorService = new CalculatorServiceImpl();
    @Test
    @DisplayName("기록을 조회하여 출력이 올바른지 검증하라")
    void calculationResult() {
        //given
        String input = "1 + 1";
        String answer = "2.0";

        calculatorService.save(input, answer);

        //when
        final String result = calculatorService.calculationResult();

        //then
        assertEquals("0. 1 + 1 = 2.0\n", result);

    }
}