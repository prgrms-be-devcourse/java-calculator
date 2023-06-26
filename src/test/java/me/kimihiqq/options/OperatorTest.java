package me.kimihiqq.options;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OperatorTest {

    @Test
    public void shouldCalculateCorrectlyForAllOperators() {
        assertEquals(2.0, Operator.MULTIPLY.calculate(1.0, 2.0));
        assertEquals(0.5, Operator.DIVIDE.calculate(1.0, 2.0));
        assertEquals(3.0, Operator.ADD.calculate(1.0, 2.0));
        assertEquals(-1.0, Operator.SUBTRACT.calculate(1.0, 2.0));
    }

    @Test
    public void shouldThrowExceptionWhenDividingByZero() {
        assertThrows(IllegalArgumentException.class, () -> Operator.DIVIDE.calculate(1.0, 0.0));
    }
}