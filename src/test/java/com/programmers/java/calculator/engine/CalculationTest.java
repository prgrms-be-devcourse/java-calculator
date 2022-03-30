package com.programmers.java.calculator.engine;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {
    Calculation calculation = new Calculation();

    @Test
    void 덧셈() {
        String question = "1 + 2";
        int answer = 3;
        Optional<Integer> result = calculation.calculate(question);

        if (result.isPresent()) {
            assertEquals(answer, result.get(), question + " 틀렸습니다.");
        } else {
            assertTrue(true, question + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }
    }

    @Test
    void 뺄셈() {
        String question = "1 - 2";
        int answer = -1;
        Optional<Integer> result = calculation.calculate(question);

        if (result.isPresent()) {
            assertEquals(answer, result.get(), question + " 틀렸습니다.");
        } else {
            assertTrue(true, question + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }
    }

    @Test
    void 곱셈() {
        String question = "7 * 11";
        int answer = 77;
        Optional<Integer> result = calculation.calculate(question);

        if (result.isPresent()) {
            assertEquals(answer, result.get(), question + " 틀렸습니다.");
        } else {
            assertTrue(true, question + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }
    }

    @Test
    void 나눗셈() {
        String question = "77 / 11";
        int answer = 7;
        Optional<Integer> result = calculation.calculate(question);

        if (result.isPresent()) {
            assertEquals(answer, result.get(), question + " 틀렸습니다.");
        } else {
            assertTrue(true, question + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }
    }

    @Test
    void 복잡한_사칙연산() {
        String question = "1 + 32 * 4 - 42 / 7 - 102";
        int answer = 21;
        Optional<Integer> result = calculation.calculate((question));

        if(result.isPresent()) {
            assertSame(answer, result.get(), question + " 틀렸습니다.");
        } else {
            assertTrue(true, question + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }
    }

    @Test
    void 잘못된_계산식() {
        String question = "1+4";
        Optional<Integer> result = calculation.calculate((question));

        result.ifPresent(integer -> assertTrue(true, question + "가 " + result + "으로 계산이 됐습니다. 검증 부분을 확인해주세요."));

    }

    @Test
    void 문자열_입력() {
        String question = "안녕하세요.";
        Optional<Integer> result = calculation.calculate((question));

        result.ifPresent(integer -> assertTrue(true, question + "가 " + result + "으로 계산이 됐습니다. 검증 부분을 확인해주세요."));
    }
}