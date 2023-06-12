package org.programmers.calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OperatorTest {

    @Test
    public void testAdd() {
        int result = Operator.add(2, 3);
        assertEquals(5, result);
    }

    @Test
    public void testSubtract() {
        int result = Operator.subtract(5, 2);
        assertEquals(3, result);
    }

    @Test
    public void testMultiply() {
        int result = Operator.multiply(2, 4);
        assertEquals(8, result);
    }

    @Test
    public void testDivide() {
        int result = Operator.divide(10, 2);
        assertEquals(5, result);
    }

    @Test
    public void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            Operator.divide(5, 0);
        });
    }
}