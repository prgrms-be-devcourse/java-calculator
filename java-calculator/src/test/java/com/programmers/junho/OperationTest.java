package com.programmers.junho;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    @Test
    void add() {
        Operation operation = new Operation();
        int result = operation.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        Operation operation = new Operation();
        int result = operation.subtract(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiply() {
        Operation operation = new Operation();
        int result = operation.multiply(2, 4);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void divide() {
        Operation operation = new Operation();
        int result = operation.divide(4, 2);
        assertThat(result).isEqualTo(2);
    }
}
