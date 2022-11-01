package org.programmers.java.calculator.processing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorTest {

    Processor calculatorController = new Processor();

    @Test
    @DisplayName("입력 값에 따라서 반환되는 결과를 검증하라")
    void calculationResult() {
        //given
        String input = "1 + 1";
        calculatorController.calculate(input);

        //when
        String Result = calculatorController.getMemory();

        //then
        assertEquals("0. 1 + 1 = 2.0", Result);
    }

    @Test
    @DisplayName("입력값에 따라서 조회 값을 검증하라")
    void calculate() {
        //given
        String input = "1 + 1";

        //when
        String answer = calculatorController.calculate(input);

        //then
        assertEquals("2.0", answer);
    }
}