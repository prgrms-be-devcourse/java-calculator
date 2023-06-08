package com.programmers.postfixconverter;

import com.programmers.domain.PostfixConverter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PostfixConverterTest {
    private PostfixConverter converter = new PostfixConverter();

    @Test
    void parsingDataMixedWithPlusAndMinus() {
        //given
        String[] tokenizedA = {"1", "+", "3", "-", "4"};

        //when
        String[] resultA = converter.convert(tokenizedA);

        //then
        assertThat(resultA).containsExactly("1", "3", "+", "4", "-");
    }

    @Test
    void parsingDataMixedAllOperator() {
        //given
        String[] tokenizedA = {"1", "*", "1", "+", "1", "/", "1"};
        String[] tokenizedB = {"1", "-", "1", "*", "1", "/", "1"};

        //when
        String[] resultA = converter.convert(tokenizedA);
        String[] resultB = converter.convert(tokenizedB);

        //then
        assertThat(resultA).containsExactly("1", "1", "*", "1", "1", "/", "+");
        assertThat(resultB).containsExactly("1", "1", "1", "*", "1", "/", "-");

    }
}
