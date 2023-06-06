package com.programmers.postfixconverter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixConverterTest {
    private PostfixConverter parser = new PostfixConverter();

    @Test
    void parsingDataMixedWithPlusAndMinus() {
        //given
        String[] tokenizedA = {"1", "+", "3", "-", "4"};

        //when
        String[] resultA = parser.convert(tokenizedA);

        //then
        assertThat(resultA).containsExactly("1", "3", "+", "4", "-");
    }

    @Test
    void parsingDataMixedAllOperator() {
        //given
        String[] tokenizedA = {"1", "*", "1", "+", "1", "/", "1"};
        String[] tokenizedB = {"1", "-", "1", "*", "1", "/", "1"};

        //when
        String[] resultA = parser.convert(tokenizedA);
        String[] resultB = parser.convert(tokenizedB);

        //then
        assertThat(resultA).containsExactly("1", "1", "*", "1", "1", "/", "+");
        assertThat(resultB).containsExactly("1", "1", "1", "*", "1", "/", "-");

    }
}
