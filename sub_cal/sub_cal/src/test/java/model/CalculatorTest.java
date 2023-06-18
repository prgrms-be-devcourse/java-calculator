package model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    static Calculator calculator;
    @BeforeAll
    static void beforeAll() {
        calculator = new Calculator();
    }
    @ParameterizedTest
    @DisplayName("결과값 확인")
    @CsvSource(value = {"1 + 3,4","1 * 3 + 6,9","1 + 3 * 9 - 7 * 8 * 2 / 8,14","1 + 2 - 1 * 3 - 2,-2"})
    void calculate(String expression,String expected) {
        String result;
        result = calculator.calculate(expression);
        assertEquals(expected,result);
    }

}
