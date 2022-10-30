package com.programmers.domain;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorResultTest {

    Result<Integer, String> stringResult = new CalculatorResult();

    @Test
    void addResultAndGetResultTest() {
        //given
        stringResult.addResult("1 + 1 = 2");
        stringResult.addResult("1 * 1 = 1");

        //when
        Map<Integer, String> answers = new LinkedHashMap<>();
        answers.put(0, "1 + 1 = 2");
        answers.put(1, "1 * 1 = 1");

        //then
        assertEquals(stringResult.getResult(), answers);
    }
}
