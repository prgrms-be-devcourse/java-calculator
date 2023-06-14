package com.programmers.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.programmers.domain.PostfixConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

public class PostfixConverterTest {
    private final String parameterClass = "com.programmers.parameterized.PostfixConverterParams";

    @ParameterizedTest
    @MethodSource(parameterClass + "#parsingDataMixedWithPlusAndMinus")
    void parsingDataMixedWithPlusAndMinus(List<String> infixExpression, List<String> result) {
        //when
        List<String> postfixExpression = convert(infixExpression);

        //then
        assertThat(postfixExpression).containsExactlyElementsOf(result);
    }

    @ParameterizedTest
    @MethodSource(parameterClass + "#parsingDataMixedAllOperator")
    void parsingDataMixedAllOperator(List<String> infixExpression, List<String> result) {
        //when
        List<String> postfixExpression = convert(infixExpression);

        //then
        assertThat(postfixExpression).containsExactlyElementsOf(result);
    }
}
