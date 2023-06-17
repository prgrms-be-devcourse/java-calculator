package com.programmers.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

class PostfixConverterTest {
    PostfixConverter postfixConverter = new PostfixConverter();

    @Test
    void 중위표기식을_후위표기식으로_변환한다() {
        //given
        List<String> tokens = Arrays.asList("5", "+", "2", "/", "7");

        //when
        List<String> result = postfixConverter.convertInfixToPostfix(tokens);

        //then
        assertThat(result).containsExactly("5", "2", "7", "/", "+");
    }

    @CsvSource(value = {
            "+ : * : false",
            "+ : - : true",
            "* : / : true",
            "* : - : true"
    }, delimiter = ':')
    @ParameterizedTest
    void 두_연산자의_우선순위를_비교한다(String op1, String op2, boolean expected) {
        //given
        //when
        boolean result = postfixConverter.compareOperators(op1, op2);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @CsvSource(value = {
            "145 : true",
            "aa : false",
            "0 : true",
            "^%$ : false"
    }, delimiter = ':')
    @ParameterizedTest
    void 주어진_문자열이_숫자인지_확인한다(String input, boolean expected) {
        //given
        //when
        boolean result = postfixConverter.isNumeric(input);

        //then
        assertThat(result).isEqualTo(expected);
    }
}