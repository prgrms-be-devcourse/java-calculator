package com.programmers.calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.programmers.calculator.util.PostfixConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

class PostfixConverterTest {
    @Test
    @DisplayName("후위 표기식으로 변환")
    void 후위_표기식으로_변환() {
        // given
        String expression = "3 + 2*4 -9  /3";
        // when
        String result = convert(expression);
        // then
        assertThat(result).isEqualTo("324*+93/-");
    }
}
