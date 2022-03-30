package com.programmers.java.entity;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    @Test
    void 계산식_결과_출력() {
        //given
        Calculation calculation = new Calculation("1 + 2 * 3", 7);

        //then
        String result = calculation.toString();

        //when
        Assertions.assertThat(result).isEqualTo("1 + 2 * 3 = 7");
    }
}