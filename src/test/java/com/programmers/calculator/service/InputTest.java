package com.programmers.calculator.service;

import com.programmers.calculator.Calculator;
import com.programmers.Console;
import com.programmers.calculator.repository.MemoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class InputTest {
    Console console = new Console();
    MemoryRepository memoryRepository = new MemoryRepository();
    ArithmeticService arithmeticService = new ArithmeticService();
    ValidatorService validatorService = new ValidatorService();

    @Test
    @DisplayName("긴 수식 입력 결과 반환")
    void selectActionTest() {
        String formula = "1 + 2 * 3 / 6 + 2 - 1";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getResult(formula);
        assertEquals(result, 3);
    }
}
