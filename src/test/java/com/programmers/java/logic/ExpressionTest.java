package com.programmers.java.logic;

import com.programmers.java.exception.WrongExpressionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpressionTest {
    private Calculator calculator;
    @BeforeEach
    void beforeEach() {
        calculator = new Calculator();
    }
    @Test
    void wrongExpressionTest() {
        String expression = "7-{5/2.5}+3";

        Exception exception = assertThrows(WrongExpressionException.class, () -> {
            calculator.calculate(expression);
        });

        String expectedMessage = "잘못된 기호입니다.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void wrongOperatorOrderTest() {
        String expression = "72--";

        assertThrows(NoSuchElementException.class, () -> {
            calculator.calculate(expression);
        });
    }
}
