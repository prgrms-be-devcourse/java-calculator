package com.programmers.calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testInfixToPostfix1() {
        Calculator c = new Calculator();
        List<String> postfix = Arrays.asList("1", "2", "3", "*", "+");

        assertEquals(postfix, c.infixToPostfix("1 + 2 * 3"));
    }

    @Test
    void testInfixToPostfix2() {
        Calculator c = new Calculator();
        List<String> postfix = Arrays.asList("2", "5", "+", "3", "*", "2", "1", "+", "*");

        assertEquals(postfix, c.infixToPostfix("( 2 + 5 ) * 3 * ( 2 + 1 )"));
    }
}