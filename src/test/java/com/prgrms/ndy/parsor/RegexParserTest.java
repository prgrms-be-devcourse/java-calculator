package com.prgrms.ndy.parsor;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.PatternSyntaxException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RegexParserTest {

    String EXPRESSION_REGEX = "^((-?\\d*\\.?\\d+)[\\+\\-\\*\\/])+(-?\\d*\\.?\\d+)$";

    @ParameterizedTest
    @CsvSource(value = {
            "1+2+3+",
            "1-2-",
            "틀린 식",
            "*12.444-1",
            "--1+3"
    })
    void 식이_옳바르지_않으면_예외가_발생한다(String expression) {
        Parser parser = new RegexParser(EXPRESSION_REGEX);

        assertThatThrownBy(() -> parser.parse(expression))
                .isInstanceOf(PatternSyntaxException.class)
                .hasMessageContaining("올바른 표현식이 아닙니다.");
    }
}
