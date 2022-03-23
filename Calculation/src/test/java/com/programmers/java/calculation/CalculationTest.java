package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.parse.Parsing;
import com.programmers.java.calculation.parse.ValidationImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculationTest {

    private Calculation calculation = new Calculation(new Parsing(), new ValidationImpl(), new CalculateBasicImpl());

    @Test
    public void calculation() throws Exception {

        String input1 = "2+1";
        Double result1 = calculation.calculationTotal(input1);
        assertThat(result1).isEqualTo(3);

        String input2 = "2-1";
        Double result2 = calculation.calculationTotal(input2);
        assertThat(result2).isEqualTo(1);

        String input3 = "2*1";
        Double result3 = calculation.calculationTotal(input3);
        assertThat(result3).isEqualTo(2);

        String input4 = "2/1";
        Double result4 = calculation.calculationTotal(input4);
        assertThat(result4).isEqualTo(2);

        String input5;
        List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        for (String s1 : operator) {
            for (String s2 : operator) {
                input5 = "2" + s1 + s2 + "1";
                Double result5 = calculation.calculationTotal(input5);
                assertThat(result5).isNull();
            }
        }

        String input6;
        for (String s1 : operator) {
            input6 = "2 + 1" + s1;
            Double result6 = calculation.calculationTotal(input6);
            assertThat(result6).isNull();
        }

        String input7 = "2/0";
        Double result7 = calculation.calculationTotal(input7);
        assertThat(result7).isNull();

        String input8;
        List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/"));
        for (String s1 : operatorMulAndDiv) {
            input8 = s1 + "2 + 1";
            Double result8 = calculation.calculationTotal(input8);
            assertThat(result8).isNull();
        }

        String input9 = "+2+1";
        Double result9 = calculation.calculationTotal(input9);
        assertThat(result9).isEqualTo(3);

        String input10 = "-2+1";
        Double result10 = calculation.calculationTotal(input10);
        assertThat(result10).isEqualTo(-1);






    }

}