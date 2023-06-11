package com.devcourse.java.calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculateUtilTest {

    CalculateUtil calculateUtil = new CalculateUtil();

    @Test
    @DisplayName("식 계산 결과 확인")
    void calculateAndReturnEquationWithAnswerTest() {
        //given
        String equation1 = "5 + 10";
        String equation2 = "10 + 2 * 50 + 30";
        String equation3 = "1 + 2 + 3 + 4 + 5";
        String equation4 = "6 + 10 / 2 + 4";
        String equation5 = "5 * 10 / 2 + 10";

        //when
        String equationWithAnswer = calculateUtil.calculateAndReturnEquationWithAnswer(equation1);
        String equationWithAnswer2 = calculateUtil.calculateAndReturnEquationWithAnswer(equation2);
        String equationWithAnswer3 = calculateUtil.calculateAndReturnEquationWithAnswer(equation3);
        String equationWithAnswer4 = calculateUtil.calculateAndReturnEquationWithAnswer(equation4);
        String equationWithAnswer5 = calculateUtil.calculateAndReturnEquationWithAnswer(equation5);


        //then
        assertThat(equationWithAnswer).isEqualTo("5 + 10 = 15");
        assertThat(equationWithAnswer2).isEqualTo("10 + 2 * 50 + 30 = 140");
        assertThat(equationWithAnswer3).isEqualTo("1 + 2 + 3 + 4 + 5 = 15");
        assertThat(equationWithAnswer4).isEqualTo("6 + 10 / 2 + 4 = 15");
        assertThat(equationWithAnswer5).isEqualTo("5 * 10 / 2 + 10 = 35");

    }
}