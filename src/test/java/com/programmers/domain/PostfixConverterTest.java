package com.programmers.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixConverterTest {
    private PostfixConverter converter = new PostfixConverter();

    @Test
    void parsingDataMixedWithPlusAndMinus() {
        //given
        List<String> tokenizedA = List.of("1", "+", "3", "-", "4");

        //when
        List<String> resultA = converter.convert(tokenizedA);

        //then
        assertThat(resultA).containsExactly("1", "3", "+", "4", "-");
    }

    @Test
    void parsingDataMixedAllOperator() {
        //given
        List<String> tokenizedA = List.of("1", "*", "1", "+", "1", "/", "1");
        List<String> tokenizedB = List.of("1", "-", "1", "*", "1", "/", "1");

        //when
        List<String> resultA = converter.convert(tokenizedA);
        List<String> resultB = converter.convert(tokenizedB);

        //then
        assertThat(resultA).containsExactly("1", "1", "*", "1", "1", "/", "+");
        assertThat(resultB).containsExactly("1", "1", "1", "*", "1", "/", "-");

    }
}
