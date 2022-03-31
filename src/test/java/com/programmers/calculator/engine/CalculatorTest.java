package com.programmers.calculator.engine;

import com.programmers.calculator.Console;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator(new Console(), new Console());

    // 곱셈이 덧셈보다 뒤에 오는 경우
    @Test
    void calc1() {
        assertEquals(7, calculator.calc("1 + 2 * 3").get());
    }

    // 음수 계산
    @Test
    void calc2() {
        assertEquals(1, calculator.calc("-1 + 2").get());
    }

    // 괄호 계산
    @Test
    void calc3() {
        assertEquals(9, calculator.calc("( 1 + 2 ) * 3").get());
    }

    // 연산식1
    @Test
    void calc4() {
        assertEquals(-6, calculator.calc("( ( 1 - ( 2 * 3 ) ) + 4 ) - 10 / 2").get());
    }

    // 연산식1
    @Test
    void infixToPostfix1() {
        List<String> expected = new ArrayList<>();
        expected.add("1"); expected.add("2"); expected.add("3"); expected.add("*");
        expected.add("-"); expected.add("4"); expected.add("+"); expected.add("10");
        expected.add("2"); expected.add("/"); expected.add("-");
        assertEquals(expected, calculator.infixToPostfix("( ( 1 - ( 2 * 3 ) ) + 4 ) - 10 / 2").get());
    }

    // 연산식2
    @Test
    void infixToPostfix2() {
        List<String> expected = new ArrayList<>();
        expected.add("1"); expected.add("3"); expected.add("-");
        assertEquals(expected, calculator.infixToPostfix("1 - 3").get());
    }
}