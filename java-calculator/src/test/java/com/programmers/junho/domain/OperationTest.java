package com.programmers.junho.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OperationTest {

    private Operation operation;
    @BeforeEach
    void setUp() {
        this.operation = new Operation(1);
    }

    @Test
    void add() {
        int result = operation.add(1, 2);
        assertThat(result).isEqualTo(3);
    }

    @Test
    void subtract() {
        int result = operation.subtract(1, 2);
        assertThat(result).isEqualTo(-1);
    }

    @Test
    void multiply() {
        int result = operation.multiply(2, 4);
        assertThat(result).isEqualTo(8);
    }

    @Test
    void divide() {
        int result = operation.divide(4, 2);
        assertThat(result).isEqualTo(2);
    }
}
