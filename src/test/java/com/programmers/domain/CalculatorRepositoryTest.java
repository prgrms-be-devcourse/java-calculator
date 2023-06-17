package com.programmers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CalculatorRepositoryTest {
    CalculatorRepository calculatorRepository = new CalculatorRepository();

//    @Test
//    void 리포지토리에_계산식을_저장한다() {
//        //given
//        String expression = "2 + 4 * 8 = 34";
//        List<String> expected = Arrays.asList("2 + 4 * 8 = 34");
//
//        //when
//        calculatorRepository.save(expression);
//
//        List<String> result = calculatorRepository.findAll();
//
//        //then
//        assertThat(result).isEqualTo(expected);
//    }

    @Test
    void 리포지토리에_저장된_모든_값을_확인한다() {
        //given

        List<String> input = Arrays.asList(
                "1 + 3 * 5 = 16",
                "2 / 2 + 1 = 2",
                "5 + 14 / 7 = 7"
        );

        for (String s : input) {
            calculatorRepository.save(s);
        }

        //when
        List<String> result = calculatorRepository.findAll();

        //then
        assertThat(result).isEqualTo(input);
    }
}