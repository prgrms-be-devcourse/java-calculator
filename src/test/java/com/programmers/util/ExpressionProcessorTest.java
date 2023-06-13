package com.programmers.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ExpressionProcessorTest {

    ExpressionProcessor expressionProcessor = new ExpressionProcessor();

    @Test
    void 계산식을_요소별로_나눈다() {
        //given
        String input = "1+1+4+7*2-3/2";
        List<String> expected = Arrays.asList("1", "+", "1", "+", "4", "+", "7", "*", "2", "-", "3", "/", "2");

        //when
        List<String> result = expressionProcessor.parse(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 토큰_문자열에_요소를_추가한다() {
        //given
        StringBuilder builder = new StringBuilder("11");
        List<String> tokens = new ArrayList<>();

        List<String> expected = Arrays.asList("11");

        //when
        expressionProcessor.addBuilderToTokens(builder, tokens);

        //then
        assertThat(tokens).isEqualTo(expected);
    }

    @Test
    void 공백을_제거한다() {
        //given
        String input = "1    + 2 * 3 / 4    - 23";
        String expected = "1+2*3/4-23";

        //when
        String result = expressionProcessor.removeSpace(input);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    void 계산식에_공백을_추가하여_재배열한다() {
        //given
        List<String> expression = Arrays.asList("5", "+", "2", "+", "34", "*", "23", "/", "2", "-", "3");
        int expressionResult = 395;
        String expected = "5 + 2 + 34 * 23 / 2 - 3 = 395";

        //when
        String result = expressionProcessor.rearrangeExpression(expression, expressionResult);

        //then
        assertThat(result).isEqualTo(expected);
    }
}