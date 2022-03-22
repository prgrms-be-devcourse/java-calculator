package com.programmers.java.calculation.calculate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculateImplTest {



    @Test
    public void 계산기() throws Exception {

        String[] input = {"24", "+", "12", "/", "5", "-", "3", "*", "2"};
        CalculateImpl calculate = new CalculateImpl();
        Double result = calculate.cal(input);

        Assertions.assertThat(result).isEqualTo(20.4);


    }


}