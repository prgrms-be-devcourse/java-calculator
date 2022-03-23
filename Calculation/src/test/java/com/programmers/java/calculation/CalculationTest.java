package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.parse.ParsingImpl;
import com.programmers.java.calculation.parse.ValidationImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationTest {

    private Calculation calculation = new Calculation(new ParsingImpl(), new ValidationImpl(), new CalculateBasicImpl());

    @Test
    public void calculation() throws Exception {

        String input1 = "2+1";
        Double result1 = calculation.calculationAndValidate(input1);
        assertThat(result1).isEqualTo(3);

        String input2 = "2-1";
        Double result2 = calculation.calculationAndValidate(input2);
        assertThat(result2).isEqualTo(1);

        String input3 = "2*1";
        Double result3 = calculation.calculationAndValidate(input3);
        assertThat(result3).isEqualTo(2);

        String input4 = "2/1";
        Double result4 = calculation.calculationAndValidate(input4);
        assertThat(result4).isEqualTo(2);

        String input5;
        List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/"));
        for (String s1 : operator) {
            for (String s2 : operator) {
                input5 = "2" + s1 + s2 + "1";
                Double result5 = calculation.calculationAndValidate(input5);
                assertThat(result5).isNull();
            }
        }

        String input6;
        for (String s1 : operator) {
            input6 = "2 + 1" + s1;
            Double result6 = calculation.calculationAndValidate(input6);
            assertThat(result6).isNull();
        }

        String input7 = "2/0";
        Double result7 = calculation.calculationAndValidate(input7);
        assertThat(result7).isNull();

        String input8;
        List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/"));
        for (String s1 : operatorMulAndDiv) {
            input8 = s1 + "2 + 1";
            Double result8 = calculation.calculationAndValidate(input8);
            assertThat(result8).isNull();
        }

        String input9 = "+2+1";
        Double result9 = calculation.calculationAndValidate(input9);
        assertThat(result9).isEqualTo(3);

        String input10 = "-2+1";
        Double result10 = calculation.calculationAndValidate(input10);
        assertThat(result10).isEqualTo(-1);






    }

}