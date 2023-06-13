package com.programmers.calculator.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.programmers.calculator.util.PostfixConverter.convert;
import static org.assertj.core.api.Assertions.assertThat;

class PostfixConverterTest {
    @Test
    @DisplayName("후위 표기식 변환을 성공한다.")
    void 후위_표기식_변환() {
        // given
        String expression = "30 + 2 * 4 - 9 / 3";
        // when
        String result = convert(expression);
        // then
        assertThat(result).isEqualTo("30 2 4 * + 9 3 / -");
    }
}
