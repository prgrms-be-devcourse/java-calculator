package com.programmers.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.*;

public class CalculatorResultTest {

    Result<Integer, Formula> stringResult = new CalculatorResult();

    @ParameterizedTest
    @MethodSource
    void addResultAndGetResultTest(String problem, int answer) {
        stringResult.addResult(new Formula(problem, answer));

        Map<Integer, Formula> result = new LinkedHashMap<>();
        result.put(0, new Formula(problem, answer));

        assertEquals(result, stringResult.getResult());
    }


    static Stream<Arguments> addResultAndGetResultTest() {
        return Stream.of(
                arguments("1 + 1", 2),
                arguments("1 * 1", 1));
    }
}
