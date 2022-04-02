package com.kimhunki.java.calculator.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfixCalculatorTest {
    InfixCalculator infixCalculator = new InfixCalculator(new Parser(),new Operator());

    @Test
    @DisplayName("계산식을 넣었을 때 잘 되는지 테스트")
    void calculate( ) {
        List<String> expressionList = new ArrayList<>(List.of("2", "+", "8", "*", "4", "/","2"));

        assertEquals("18.0",infixCalculator.calculate(expressionList));

    }
}