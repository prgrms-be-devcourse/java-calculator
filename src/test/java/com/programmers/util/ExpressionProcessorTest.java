package com.programmers.util;

import org.junit.jupiter.api.Test;

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
}