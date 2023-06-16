package com.programmers.java.util;

import com.programmers.java.record.CalculationRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ExpressionTokenizerTest {

    private ExpressionTokenizer expressionTokenizer;

    @BeforeEach
    public void setUp() {
        expressionTokenizer = new ExpressionTokenizer();
    }

    @Test
    void expressionSplit_SingleDigit() {
        String expression = "3+5*4-2/6";
        List<String> expectedTokens = Arrays.asList("3", "+", "5", "*", "4", "-", "2", "/", "6");
        List<String> testTokens = expressionTokenizer.expressionSplit(expression);

        Assertions.assertEquals(expectedTokens, testTokens);
    }

    @Test
    void expressionSplit_MultipleDigit() {
        String expression = "322323+54*42-402/20";
        List<String> expectedTokens = Arrays.asList("322323", "+", "54", "*", "42", "-", "402", "/", "20");
        List<String> testTokens = expressionTokenizer.expressionSplit(expression);

        Assertions.assertEquals(expectedTokens, testTokens);
    }
}