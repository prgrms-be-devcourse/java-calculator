package com.programmers.calculator.engine;

import com.programmers.calculator.engine.repository.Repository;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator();

    // 곱셈이 덧셈보다 뒤에 오는 경우
    @Test
    void calc1() {
        int expected = 7;
        int actual = calculator.calculate("1 + 2 * 3").get();

        assertEquals(expected, actual);
    }

    // 음수 계산
    @Test
    void calc2() {
        int expected = 1;
        int actual = calculator.calculate("-1 + 2").get();

        assertEquals(expected, actual);
    }

    // 괄호 계산
    @Test
    void calc3() {
        int expected = 9;
        int actual = calculator.calculate("( 1 + 2 ) * 3").get();

        assertEquals(expected, actual);
    }

    // 연산식1
    @Test
    void calc4() {
        int expected = -6;
        int actual = calculator.calculate("( ( 1 - ( 2 * 3 ) ) + 4 ) - 10 / 2").get();

        assertEquals(expected, actual);
    }

    // 연산식1
    @Test
    void infixToPostfix1() {
        List<String> expected = Arrays.asList("1 2 3 * - 4 + 10 2 / -".split(" "));
        List<String> actual = calculator.infixToPostfix("( ( 1 - ( 2 * 3 ) ) + 4 ) - 10 / 2").get();

        assertEquals(expected, actual);
    }

    // 연산식2
    @Test
    void infixToPostfix2() {
        List<String> expected = Arrays.asList("1 3 -".split(" "));
        List<String> actual = calculator.infixToPostfix("1 - 3").get();

        assertEquals(expected, actual);
    }
}