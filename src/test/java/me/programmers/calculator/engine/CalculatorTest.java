package me.programmers.calculator.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void plusTest() {
        // given
        String problem = "1+2";
        // when
        long sum = calculator.calculateFormula(problem);
        // then
        assertEquals(sum, 3);
    }

    @Test
    void plusOverIntegerRangeTest() {
        // given
        String problem = "2500000000+1";
        // when
        long sum = calculator.calculateFormula(problem);
        // then
        assertEquals(sum, 2500000001L);
    }

    @Test
    void minusTest() {
        // given
        String problem = "1-2";
        // when
        long sum = calculator.calculateFormula(problem);
        // then
        assertEquals(sum, -1);
    }

    @Test
    void mulTest() {
        // given
        String problem = "1*2";
        // when
        long sum = calculator.calculateFormula(problem);
        // then
        assertEquals(sum, 2);
    }

    @Test
    void divTest() {
        // given
        String problem = "2/1";
        // when
        long sum = calculator.calculateFormula(problem);
        // then
        assertEquals(sum, 2);
    }

    @Test
    void divideByZeroTest() {
        assertThrows(ArithmeticException.class, () -> {
            String problem = "2/0";
            calculator.calculateFormula(problem);
        });
    }

    @Test
    void multipleOperatorCalculateTest() {
        // given
        String problem = "3+2*4-3/3";
        // when
        long sum = calculator.calculateFormula(problem);
        // then
        assertEquals(sum, 10);
    }

}