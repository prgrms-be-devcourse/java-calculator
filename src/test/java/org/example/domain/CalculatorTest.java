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

        Integer value2 = calculator.execute("(2 + 5) * 2");
        Assertions.assertEquals(value2, 14);

        Integer value3 = calculator.execute("(2 + 4) / 3");
        Assertions.assertEquals(value3, 2);
    }
}