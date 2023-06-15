package com.devcourse.java.domain.parser;

import com.devcourse.java.domain.calculator.parser.PrefixParser;
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
        final String expression = "1 + 2 * 3 - 4 / 5";
        final List<String> expect = List.of("1", "2", "3", "*", "+", "4", "5", "/", "-");

        // when
        List<String> prefixExpression = prefixParser.parse(expression);

        // then
        for (int i = 0; i < expect.size(); i++) {
            assertThat(prefixExpression.get(i)).isEqualTo(expect.get(i));
        }
    }
}
