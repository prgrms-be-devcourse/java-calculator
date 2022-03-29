package com.programmers.calculator;

import com.programmers.calculator.engine.Calculator;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void testInfixToPostfix1() {
        Console console = new Console();
        Calculator c = new Calculator(console, console);
        List<String> postfix = Arrays.asList("1", "2", "3", "*", "+");

        assertEquals(postfix, c.infixToPostfix("1 + 2 * 3"));
    }

    @Test
    void testInfixToPostfix2() {
        Console console = new Console();
        Calculator c = new Calculator(console, console);
        List<String> postfix = Arrays.asList("2", "5", "+", "3", "*", "2", "1", "+", "*");

        assertEquals(postfix, c.infixToPostfix("( 2 + 5 ) * 3 * ( 2 + 1 )"));
    }
}