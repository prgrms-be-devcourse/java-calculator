package com.programmers.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class ExpressionValidatorTest {
    public ExpressionValidator expressionValidator = new ExpressionValidator();

    @CsvSource(value = {
            "1+2*3 : 1,+,2,*,3",
            "4/2+8 : 4,/,2,+,8",
            "111-56+2 : 111,-,56,+,2",
            "5/4*77-45 : 5,/,4,*,77,-,45"
    }, delimiter = ':')
    @ParameterizedTest
    void 공백이_제거된_계산식을_유효성_검사한_후_리스트_형태로_반환한다(String input, String expectedResult) {
        //given
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        List<String> result = expressionValidator.validate(input);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {
            "1+2@3",
            "4DD8",
            "111#56%%+2",
            "5/4*77BNAC5"
    })
    @ParameterizedTest
    void 계산식의_요소를_나누기_전에_조건을_만족하지_않으면_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> expressionValidator.validateBeforeSplit(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @ValueSource(strings = {
            "13",
            "12,+",
            "2,/,0",
            "16,9,3,-,4,*"
    })
    @ParameterizedTest
    void 계산식의_요소를_나눈_뒤_조건을_만족하지_않으면_예외처리한다(String expectedResult) {
        //given
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expressionValidator.validateAfterSplit(expected))
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
        Assertions.assertThatThrownBy(() -> expressionValidator.containsOtherCharacter(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @EmptySource
    @ParameterizedTest
    void 입력받은_계산식의_내용이_비어있는_경우_예외처리한다(String input) {
        //given
        //when
        //then
        Assertions.assertThatThrownBy(() -> expressionValidator.isEmpty(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
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
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expressionValidator.isEvenNumber(expected))
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
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expressionValidator.isNotFormat(expected))
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
        List<String> tokens = Arrays.stream(inputTokens.split(","))
                .collect(Collectors.toList());

        //when
        boolean result = expressionValidator.isRightToken(index, tokens);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ValueSource(strings = {
            "13,/,0",
            "1,*,2,/,0",
    })
    @ParameterizedTest
    void 숫자_0으로_나누는_계산식이_주어진_경우_예외처리한다(String expectedResult) {
        //given
        List<String> expected = Arrays.stream(expectedResult.split(","))
                .collect(Collectors.toList());

        //when
        //then
        Assertions.assertThatThrownBy(() -> expressionValidator.isDividedByZero(expected))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
}