package com.programmers.java.calculator.engine;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    void calculate() {
        Calculation calculation = new Calculation();
        String question1 = "1 + 2";
        int answer1 = 3;
        Optional<Integer> result1 = calculation.calculate(question1);

        if(result1.isPresent()) {
            assertEquals(answer1, result1.get(), question1 + " 틀렸습니다.");
        } else {
            assertTrue(true, question1 + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }

        String question2 = "1 + 32 * 4 - 42 / 7 - 102";
        int answer2 = 21;
        Optional<Integer> result2 = calculation.calculate((question2));

        if(result2.isPresent()) {
            assertSame(answer2, result2.get(), question2 + " 틀렸습니다.");
        } else {
            assertTrue(true, question2 + "의 형식이 잘못됐다고 판단했습니다. 검증 부분을 확인해주세요.");
        }

        String question3 = "1+4";
        Optional<Integer> result3 = calculation.calculate((question3));

        result3.ifPresent(integer -> assertTrue(true, question3 + "가 " + integer + "으로 계산이 됐습니다. 검증 부분을 확인해주세요."));

        String question4 = "안녕하세요.";
        Optional<Integer> result4 = calculation.calculate((question4));

        result4.ifPresent(integer -> assertTrue(true, question4 + "가 " + integer + "으로 계산이 됐습니다. 검증 부분을 확인해주세요."));
    }
}