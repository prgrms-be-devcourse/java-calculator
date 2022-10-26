package org.programmers.java.calculator.util.verifiaction;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FormulaVerificationTest {

    @Test
    @DisplayName("정상적인 입력을 맞았을때 오류가 일어나지 않는지 검증하라")
    void formulaVerifiaction() {
        //given
        String input = "1 + 1";
        List<String> tokens = Arrays.asList(input.split(" "));

        //when
        FormulaVerification.formulaVerifiaction(tokens);

        //then
    }

    @DisplayName("부정적인 입력을 맞았을때 오류가 일어나는지 검증하라")
    @ParameterizedTest
    @ValueSource(strings = {"1+ 1", "", "1++1", "1+1+", "1+2 2 2", "^&", "1 % 1"})
    void formulaVerifiaction1(String input) {
        //given
        List<String> tokens = Arrays.asList(input.split(" "));

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> FormulaVerification.formulaVerifiaction(tokens));

    }
}