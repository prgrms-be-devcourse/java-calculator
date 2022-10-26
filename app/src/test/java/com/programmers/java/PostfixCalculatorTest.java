package com.programmers.java;

import com.programmers.java.calculator.PostfixCalculator;
import com.programmers.java.exception.DivideByZeroException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PostfixCalculatorTest {

    private final PostfixCalculator postfixCalculator = new PostfixCalculator();

    @DisplayName("후위 계산 성공")
    @Test
    void calculate_success() {
        assertEquals(postfixCalculator.calculate("1 + 2"), 3);
        assertEquals(postfixCalculator.calculate("( ( 4 + 5 ) * ( 2 + 3 ) )"), 45);
        assertEquals(postfixCalculator.calculate("( 1.1 + 3.9 )"), 5);
        assertEquals(postfixCalculator.calculate("( 1.1 + 3.9 - 1.1 )"), 3.9);
        assertEquals(postfixCalculator.calculate("( 5 - 2 / 1 )"), 3);
        assertEquals(postfixCalculator.calculate("( 2 * ( 4 + 4 ) + 5 * ( 1 - 2 ) )"), 11);
    }

    @DisplayName("후위 계산 실패 - 0으로 나눈 경우")
    @Test
    void calculate_fail_divide_by_zero() {
        assertThrows(DivideByZeroException.class, () -> postfixCalculator.calculate("1 / 0 "));
        assertThrows(DivideByZeroException.class, () -> postfixCalculator.calculate("1 / ( 1 - 1 )"));
        assertThrows(DivideByZeroException.class, () -> postfixCalculator.calculate("( 3 - 1 ) / ( 2 - ( 1 + 1 ) )"));
    }

    @DisplayName("후위 계산 실패 - 입력 형식이 잘못된 경우")
    @Test
    void calculate_fail_invalid_expression() {
        assertThrows(Exception.class, () -> postfixCalculator.calculate("1+2 "));
        assertThrows(Exception.class, () -> postfixCalculator.calculate("(1 - 1.. )"));
        assertThrows(Exception.class, () -> postfixCalculator.calculate("1 -- 1"));
    }
}