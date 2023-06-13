package com.programmers.util;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionProcessorTest {

    ExpressionProcessor expressionProcessor = new ExpressionProcessor();

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