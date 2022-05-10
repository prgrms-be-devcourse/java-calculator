package com.programmers.java.calculation.calculate;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateImplTest {


    CalculateBasicImpl calculate = new CalculateBasicImpl();

    @Test
    public void 계산기() throws Exception {

        List<String> input = new ArrayList<>(Arrays.asList("24", "+", "12", "/", "5", "-", "3", "*", "2"));
        List<String> input2 = new ArrayList<>(Arrays.asList("24", "-", "12"));

        Optional<Double> result = calculate.fourRules(input);
        Optional<Double> result2 = calculate.fourRules(input2);
        System.out.println("result2 = " + result2.get());

        assertThat(result.get()).isEqualTo(20.4);

    }

    @Test
    public void divisionZero() throws Exception {
        List<String> input = new ArrayList<>(Arrays.asList("24", "+", "12", "/", "0", "-", "3", "*", "2"));

        Optional<Double> result = calculate.fourRules(input);

        assertThat(result.isEmpty()).isTrue();

    }
    @Test
    public void cantCalculate() throws Exception {
        List<String> input = new ArrayList<>(Arrays.asList("a", "+", "12", "/", "5", "-", "3", "*", "2"));



        org.junit.jupiter.api.Assertions.assertThrows(RuntimeException.class, () -> calculate.fourRules(input));


    }


}