package calculator.calculate;

import calculator.console.Console;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    Calculator calculator = new Calculator(new Console());

    @Test
    void testIsValidExpressionFalse() {
        assertFalse(calculator.isValidExpression("1=1"));
    }

    @Test
    void testIsValidExpressionTrue() {
        assertTrue(calculator.isValidExpression("1"));
        assertTrue(calculator.isValidExpression("1 + 1"));
        assertTrue(calculator.isValidExpression("2 * 2"));
        assertTrue(calculator.isValidExpression("4 / 2"));
        assertTrue(calculator.isValidExpression("5 - 2"));
        assertTrue(calculator.isValidExpression("1 + 2 + 3"));
        assertTrue(calculator.isValidExpression("2 * 2 / 4"));
    }

    @Test
    void testCalculate() {
        assertEquals(calculator.calculate("1 + 2"), 3);
        assertEquals(calculator.calculate("5 - 2"), 3);
        assertEquals(calculator.calculate("2 * 2"), 4);
        assertEquals(calculator.calculate("6 / 2"), 3);
    }

}