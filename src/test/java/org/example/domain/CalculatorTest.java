package org.example.domain;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void execute() {
        Calculator calculator = new Calculator();

        Integer value1 = calculator.execute("2 + 5");
        Assertions.assertEquals(value1, 7);
    }
    @Test
    void execute2() {
        Calculator calculator = new Calculator();
        Integer value2 = calculator.execute("(2 + 5) * 2");
        Assertions.assertEquals(value2, 14);
    }

    @Test
    void execute3() {
        Calculator calculator = new Calculator();
        Integer value3 = calculator.execute("5 * (2 + 3)");
        Assertions.assertEquals(value3, 25);
    }
}