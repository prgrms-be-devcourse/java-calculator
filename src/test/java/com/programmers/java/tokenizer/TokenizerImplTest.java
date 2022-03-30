package com.programmers.java.tokenizer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenizerImplTest {

    @Test
    void 계산식_토큰화_정상계산식_테스트() {
        //given
        Tokenizer tokenizer = new TokenizerImpl();
        String formula = "1 + 3 * 3";
        List<String> expectedResult = Arrays.asList("1", "+", "3", "*", "3");

        //when
        List<String> tokenizerResult = tokenizer.tokenizeFormula(formula);

        //then
        Assertions.assertThat(tokenizerResult).isEqualTo(expectedResult);
    }

    @Test
    void 계산식_토큰화_음수_포함_계산식_테스트() {
        //given
        Tokenizer tokenizer = new TokenizerImpl();
        String formula = "1 + -3 * 3";
        List<String> expectedResult = Arrays.asList("1", "+", "-3", "*", "3");

        //when
        List<String> tokenizerResult = tokenizer.tokenizeFormula(formula);

        //then
        Assertions.assertThat(tokenizerResult).isEqualTo(expectedResult);
    }

    @Test
    void 계산식_토큰화_공백_포함_계산식_테스트() {
        //given
        Tokenizer tokenizer = new TokenizerImpl();
        String formula = "1       +   3   *   3";
        List<String> expectedResult = Arrays.asList("1", "+", "3", "*", "3");

        //when
        List<String> tokenizerResult = tokenizer.tokenizeFormula(formula);

        //then
        Assertions.assertThat(tokenizerResult).isEqualTo(expectedResult);
    }
}