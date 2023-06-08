package com.devcourse.java.domain.parser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ParserTest {
    private final PrefixParser prefixParser = new PrefixParser();

    @Test
    @DisplayName("후위 표기식 동작 테스트")
    void prefixParserTest() {
        // given
        final String expression = "1+2*3-4/5";
        final List<Character> expect = List.of('1', '2', '3', '*', '+', '4', '5', '/', '-');

        // when
        List<Character> prefixExpression = prefixParser.parse(expression);

        // then
        for (int i = 0; i < expression.length(); i++) {
            assertThat(prefixExpression.get(i)).isSameAs(expect.get(i));
        }
    }
}
