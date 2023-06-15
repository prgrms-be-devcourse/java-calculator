package com.wonu606.calculator.converter;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InfixToPostfixConverterTest {

    @Test
    @DisplayName("연산자가 1개일 경우")
    void testSingle() {
        // given
        Converter<String, List<String>> converter = new InfixToPostfixConverter();
        List<String> expectedList = Arrays.asList("-3", "5.0", "+");
        String infixExpression = "-3 + 5.0";

        // when
        List<String> actualList = converter.convert(infixExpression);

        // then
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("같은 우선 순위일 경우")
    void testPrecedenceEquals() {
        // given
        Converter<String, List<String>> converter = new InfixToPostfixConverter();
        List<String> expectedList = Arrays.asList("3", "5", "+", "2", "-");
        String infixExpression = "3 + 5 - 2";

        // when
        List<String> actualList = converter.convert(infixExpression);

        // then
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("높은 우선 순위가 뒤에 올 경우")
    void testHigherPrecedenceFollows() {
        // given
        Converter<String, List<String>> converter = new InfixToPostfixConverter();
        List<String> expectedList = Arrays.asList("3", "5", "2", "*", "+");
        String infixExpression = "3 + 5 * 2";

        // when
        List<String> actualList = converter.convert(infixExpression);

        // then
        assertThat(actualList).isEqualTo(expectedList);
    }

    @Test
    @DisplayName("높은 우선 순위가 앞에 올 경우")
    void testHigherPrecedenceComesFirst() {
        // given
        Converter<String, List<String>> converter = new InfixToPostfixConverter();
        List<String> expectedList = Arrays.asList("3", "5", "*", "2", "+");
        String infixExpression = "3 * 5 + 2";

        // when
        List<String> actualList = converter.convert(infixExpression);

        // then
        assertThat(actualList).isEqualTo(expectedList);
    }
}