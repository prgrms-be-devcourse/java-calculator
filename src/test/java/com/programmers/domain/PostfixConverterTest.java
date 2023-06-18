package com.programmers.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static com.programmers.domain.PostfixConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

public class PostfixConverterTest {
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 3 - 4:1 3 + 4 -"
    }, delimiter = ':')
    void parsingDataMixedWithPlusAndMinus(String input, String result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();

        //when
        List<String> postfixExpression = convert(infixExpression);

        //then
        List<String> expected = Arrays.stream(result.split(" ")).toList();

        assertThat(postfixExpression).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 * 1 + 1 / 1:1 1 * 1 1 / +",
            "1 - 1 * 1 / 1:1 1 1 * 1 / -"
    }, delimiter = ':')
    void parsingDataMixedAllOperator(String input, String result) {
        //given
        List<String> infixExpression = Arrays.stream(input.split(" ")).toList();

        //when
        List<String> postfixExpression = convert(infixExpression);

        //then
        List<String> expected = Arrays.stream(result.split(" ")).toList();

        assertThat(postfixExpression).containsExactlyElementsOf(expected);
    }
}
