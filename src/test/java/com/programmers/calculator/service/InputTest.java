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
    @DisplayName("덧셈 계산 결과 확인, 1 + 2 수식을 받아 결과로 3이 나와야함")
    void plusResultTest() {
        String formula = "1 + 2";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(3,result);
    }

    @Test
    @DisplayName("뺄셈 계산 결과 확인, 1 - 2 수식을 받아 결과로 -1이 나와야함")
    void minusResultTest() {
        String formula = "1 - 2";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(-1,result);
    }

    @Test
    @DisplayName("곱셈 계산 결과 확인, 1 * 2 수식을 받아 결과로 2가 나와야함")
    void multiResultTest() {
        String formula = "1 * 2";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(2,result);
    }

    @Test
    @DisplayName("나눗셈 계산 결과 확인, 1 / 2 수식을 받아 결과로 0.5가 나와야함")
    void diviResultTest() {
        String formula = "1 / 2";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(0.5,result);
    }

    @Test
    @DisplayName("0으로 나누기 결과 확인, 나눌 대상이 0일 경우 결과는 0이어야 함.")
    void diviZeroSuccessTest() {
        String formula = "0 / 2";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(0,result);
    }

    @Test
    @DisplayName("0으로 나누기 결과 확인, " +
            "0으로 나누려 할 때 오류가 발생하고 0을 반환해야 함.")
    void diviZeroFailTest() {
        String formula = "2 / 0";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(0,result);
    }

    @Test
    @DisplayName("덧셈 뺼셈 나눗셈 곱셉을 한번에 계산 후 결과 확인")
    void multipleArithmeticTest() {
        String formula = "1 + 2 * 3 / 6 + 2 - 1";
        double result = new Calculator(console, console, memoryRepository,
                arithmeticService, validatorService).getArithmeticResult(formula);
        assertEquals(3,result);
    }
}
