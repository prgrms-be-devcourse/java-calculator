package com.prgrms.ndy.parsor;

import com.prgrms.ndy.domain.Command;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.regex.PatternSyntaxException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RegexParserTest {

    Parser parser = new RegexParser();

    @ParameterizedTest
    @CsvSource(value = {
            "1+2+3+",
            "1-2-",
            "틀린 식",
            "*12.444-1",
            "--1+3"
    })
    void 식이_옳바르지_않으면_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> parser.parse(expression))
                .isInstanceOf(PatternSyntaxException.class)
                .hasMessageContaining("올바른 표현식이 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-2+-1",
            "-2--1",
            "-2/-1",
            "-2*-1",
            "-2*16",
            "1+2+3+4+5",
            "4/2*4+10.7",
            "2.8*7.3-8+7.0+11",
            "-1-2-3--4-5-6--7"
    })
    void 옳바른_식을_적절하게_파싱한다(String expression){
        Command command = parser.parse(expression);
        System.out.println(command);
    }
}
