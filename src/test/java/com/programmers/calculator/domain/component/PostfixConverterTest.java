package com.programmers.calculator.domain.component;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class PostfixConverterTest {

    @DisplayName("후위표기식으로 변환 잘 되는지 확인")
    @Test
    void right_convert_postfix () {

        // given
        PostfixConverter postfixConverter = new PostfixConverter();
        List<String> tokens = List.of("1", "+", "2", "*", "4", "/", "6");
        List<String> expected = List.of("1", "2", "4", "*", "6", "/", "+");

        // when
        List<String> result = postfixConverter.convert(tokens);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}