package com.programmers.java.calculator.calculate;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

    @Test
    void getResult() {
        Calculator calculator = new Calculator();
        double result = calculator.getResult("2+3");
        assertThat(result).isEqualTo(5);
    }
}