package com.programmers.java.calculator.engine;

import com.programmers.java.calculator.engine.exception.InputException;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    Calculation calculation = new Calculation();

    @Test
    void 덧셈() {
        String question = "1+2 + 3+4";
        int answer = 1 + 2 + 3 + 4;
        int result = calculation.calculate(question);

        assertEquals(answer, result, question + " 틀렸습니다.");
    }

    @Test
    void 뺄셈() {
        String question = "1 - 2-4 - 7";
        int answer = 1 - 2 - 4 - 7;
        int result = calculation.calculate(question);

        assertEquals(answer, result, question + " 틀렸습니다.");
    }

    @Test
    void 곱셈() {
        String question = "7 * 11*34 * 9";
        int answer = 7 * 11 * 34 * 9;
        int result = calculation.calculate(question);

        assertEquals(answer, result, question + " 틀렸습니다.");
    }

    @Test
    void 나눗셈() {
        String question = "77 /11/ 6";
        int answer = 77 / 11 / 6;
        int result = calculation.calculate(question);

        assertEquals(answer, result, question + " 틀렸습니다.");
    }

    @Test
    void 복잡한_사칙연산() {
        String question = "1 + 32* 4 - 42 /7 - 102";
        int answer = 1 + 32 * 4 - 42 / 7 - 102;
        int result = calculation.calculate((question));

        assertEquals(answer, result, question + " 틀렸습니다.");
    }

    @Test
    void 잘못된_계산식() {
        String question = "1 ++ 4 /3 * 7";
        assertThrows(InputException.class, () -> calculation.calculate(question));
    }


    @Test
    void 문자열_입력() {
        String question = "안녕하세요.";
        assertThrows(InputException.class, () -> calculation.calculate((question)));
    }
}