package com.programmers.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    static Calculator calculator;

    @BeforeEach
    void initAll() {
        calculator = new Calculator();
    }

    @Test
    void convertValidExpressionTest() {
        String inputExpression1 = "1 + 2";
        String inputExpression2 = "1 + 2 * 3";
        String inputExpression3 = "3 - 2 * 2";
        String inputExpression4 = "2 * (30 - 2) + 2";

        String convertedExpression1 = calculator.convert(inputExpression1);
        String convertedExpression2 = calculator.convert(inputExpression2);
        String convertedExpression3 = calculator.convert(inputExpression3);
        String convertedExpression4 = calculator.convert(inputExpression4);

        String postfixExpression1 = "1 2 +";
        String postfixExpression2 = "1 2 3 * +";
        String postfixExpression3 = "3 2 2 * -";
        String postfixExpression4 = "2 30 2 - * 2 +";

        assertEquals(postfixExpression1, convertedExpression1);
        assertEquals(postfixExpression2, convertedExpression2);
        assertEquals(postfixExpression3, convertedExpression3);
        assertEquals(postfixExpression4, convertedExpression4);
    }

    @Test
    void convertInValidExpressionTest() {
        String inputExpression1 = "2 * ((30 - 2) + 2";  // 괄호의 갯수 검증
        String inputExpression2 = "2 * )30 - 2( + 2";   // 괄호 순서 검증
        String inputExpression3 = "3 -+ 2 * 2"; // 연산자 연속성 검증
        String inputExpression4 = "2 * 30 - 2 +";   // 연산자, 피연산자 갯수 검증

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.convert(inputExpression1);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.convert(inputExpression2);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.convert(inputExpression3);
        });

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            calculator.convert(inputExpression4);
        });
    }

    @Test
    void calculateTest() {
        String postfixExpression1 = "1 2 +";
        String postfixExpression2 = "1 2 3 * +";
        String postfixExpression3 = "3 2 2 * -";
        String postfixExpression4 = "2 30 2 - * 2 +";

        double result1 = calculator.calculate(postfixExpression1);
        double result2 = calculator.calculate(postfixExpression2);
        double result3 = calculator.calculate(postfixExpression3);
        double result4 = calculator.calculate(postfixExpression4);

        double answer1 = 1 + 2;
        double answer2 = 1 + (2 * 3);
        double answer3 = 3 - (2 * 2);
        double answer4 = 2 * (30 - 2) + 2;

        assertEquals(answer1, result1);
        assertEquals(answer2, result2);
        assertEquals(answer3, result3);
        assertEquals(answer4, result4);
    }
}
