package com.programmers.postfixconverter;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void convertDataButInvalidOrder_Then_Exception() {
        //given
        String[] tokenizedA = {"1", "1", "1"};
        String[] tokenizedB = {"+", "1", "*", "1", "-"};
        String[] tokenizedC = {"1", "*", "1", "-", "-"};

        //when

        //then
        assertThatThrownBy(() -> converter.convert(tokenizedA))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> converter.convert(tokenizedB))
                .isInstanceOf(UnsupportedOperationException.class);
        assertThatThrownBy(() -> converter.convert(tokenizedC))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
