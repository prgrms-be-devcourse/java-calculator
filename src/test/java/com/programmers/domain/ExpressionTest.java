package com.programmers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ExpressionTest {

    @EmptySource
    @ParameterizedTest
    void 입력받은_계산식의_내용이_비어있는_경우_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ValueSource(strings = {
            "1+2@3",
            "4DD8",
            "111#56%%+2",
            "5/4*77BNAC5"
    })
    @ParameterizedTest
    void 연산자와_숫자_외에_다른_문자가_있는_경우_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> new Expression(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 계산식을_요소별로_나눈다() {
        //given
        Expression expression = new Expression("1+1+4+7*2-3/2");

        //when
        List<String> result = expression.parse();

        //then
        assertThat(result).containsExactly("1", "+", "1", "+", "4", "+", "7", "*", "2", "-", "3", "/", "2");
    }

    @Test
    void 유효성_검증된_토큰_반환한다() {
        //given
        Expression expression = new Expression("1+1+4+7*2-3/2");

        //when
        List<String> result = expression.getValidatedTokens();

        //then
        assertThat(result).containsExactly("1", "+", "1", "+", "4", "+", "7", "*", "2", "-", "3", "/", "2");
    }

    @ValueSource(strings = {
            "13,*,/,/",
            "12,+",
            "2,/,0,*",
            "1,1,3,45",
            "16,*,3,-,4,/"
    })
    @ParameterizedTest
    void 나눈_계산식의_요소가_짝수개인_경우_예외처리한다(String expectedResult) {
        //given
        Expression expression = new Expression("1+1");
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expression.checkEvenNumber(expected))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ValueSource(strings = {
            "13,*,/,/",
            "+,+,2",
            "*,2,/,0,*",
            "1,1,3,45"
    })
    @ParameterizedTest
    void 계산식의_형식에_맞지_않는_경우_예외처리한다(String expectedResult) {
        //given
        Expression expression = new Expression("1+1");
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expression.checkFormat(expected))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @CsvSource(value = {
            "2 : 13,*,/,/ : false",
            "1 : 1,+,2 : true",
            "0 : *,2,/,0,* : false",
            "1 : 1,-,3,+,45 : true"
    }, delimiter = ':')
    @ParameterizedTest
    void 각_토큰이_유효한_위치에_있는지_확인한다(int index, String inputTokens, boolean expected) {
        //given
        Expression expression = new Expression("1+1");
        List<String> tokens = Arrays.stream(inputTokens.split(","))
                .collect(Collectors.toList());

        //when
        boolean result = expression.checkRightToken(index, tokens);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {
            "13,/,0",
            "1,*,2,/,0",
    })
    @ParameterizedTest
    void 숫자_0으로_나누는_계산식이_주어진_경우_예외처리한다(String expectedResult) {
        //given
        Expression expression = new Expression("1+1");
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expression.checkDividedByZero(expected))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}