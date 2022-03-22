package com.programmers.java.calculation.calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateImplTest {


    CalculateImpl calculate = new CalculateImpl();

    @Test
    public void 계산기() throws Exception {

        String[] input = {"24", "+", "12", "/", "5", "-", "3", "*", "2"};
        Double result = calculate.cal(input);

        assertThat(result).isEqualTo(20.4);

    }

    @Test
    public void divisionZero() throws Exception {
        String[] input = {"24", "+", "12", "/", "0", "-", "3", "*", "2"};
        Double result = calculate.cal(input);

        assertThat(result).isNull();

    }
    @Test
    public void cantCalculate() throws Exception {
        String[] input = {"a", "+", "12", "/", "0", "-", "3", "*", "2"};
        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> calculate.cal(input));


    }


}