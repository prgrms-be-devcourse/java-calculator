package com.programmers.calculator.service;

import com.programmers.calculator.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalcInputTest {
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("긴 수식 입력 결과 반환")
    void selectActionTest() {
        String formula = "1 + 2 * 3 / 6 + 2 - 1";
        double result = calculator.getResult(formula);
        assertEquals(result, 3);
    }
}
