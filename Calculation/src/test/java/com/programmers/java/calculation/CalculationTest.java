package com.programmers.java.calculation;

import com.programmers.java.calculation.calculate.Calculate;
import com.programmers.java.calculation.calculate.CalculateBasicImpl;
import com.programmers.java.calculation.io.Input;
import com.programmers.java.calculation.io.Output;
import com.programmers.java.calculation.parse.Parsing;
import com.programmers.java.calculation.parse.ParsingImpl;
import com.programmers.java.calculation.parse.Validation;
import com.programmers.java.calculation.parse.ValidationAddDecimalImpl;
import com.programmers.java.calculation.repository.Repository;
import com.programmers.java.calculation.repository.RepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CalculationTest {

    Input input = new Console();
    Output output = new Console();
    Parsing parsing = new ParsingImpl();
    Validation validation = new ValidationAddDecimalImpl();
    Calculate calculate = new CalculateBasicImpl();
    Repository repository = new RepositoryImpl();


    CalculationService calculationService =
            new CalculationService(input, output, repository, validation, parsing, calculate);


    @Test
    public void calculation() throws Exception {

        String input1 = "2+1";
        Optional<Double> result1 = calculationService.getOutput(input1);
        assertThat(result1.get()).isEqualTo(3);

        String input2 = "2-1";
        Optional<Double> result2 = calculationService.getOutput(input2);
        assertThat(result2.get()).isEqualTo(1);

        String input3 = "2*1";
        Optional<Double> result3 = calculationService.getOutput(input3);
        assertThat(result3.get()).isEqualTo(2);

        String input4 = "2/1";
        Optional<Double> result4 = calculationService.getOutput(input4);
        assertThat(result4.get()).isEqualTo(2);

        String input5;
        List<String> operator = new ArrayList<>(Arrays.asList("+", "-", "*", "/", "."));
        for (String s1 : operator) {
            for (String s2 : operator) {
                input5 = "2" + s1 + s2 + "1";
                Optional<Double> result5 = calculationService.getOutput(input5);
                assertThat(result5.isEmpty()).isTrue();
            }
        }

        String input6;
        for (String s1 : operator) {
            input6 = "2 + 1" + s1;
            Optional<Double> result6 = calculationService.getOutput(input6);
            assertThat(result6.isEmpty()).isTrue();
        }

        String input7 = "2/0";
        Optional<Double> result7 = calculationService.getOutput(input7);
        assertThat(result7.isEmpty()).isTrue();

        String input8;
        List<String> operatorMulAndDiv = new ArrayList<>(Arrays.asList("*", "/", "."));
        for (String s1 : operatorMulAndDiv) {
            input8 = s1 + "2 + 1";
            Optional<Double> result8 = calculationService.getOutput(input8);
            assertThat(result8.isEmpty()).isTrue();
        }

        String input9 = "+2+1";
        Optional<Double> result9 = calculationService.getOutput(input9);
        assertThat(result9.get()).isEqualTo(3);

        String input10 = "-2+1";
        Optional<Double> result10 = calculationService.getOutput(input10);
        assertThat(result10.get()).isEqualTo(-1);

        String input11 = "a+-2+1";
        Optional<Double> result11 = calculationService.getOutput(input11);
        assertThat(result11.isEmpty()).isTrue();

        String input12 = "2.1+1.1";
        Optional<Double> result12 = calculationService.getOutput(input12);
        assertThat(result12.get()).isEqualTo(3.2);






    }

}