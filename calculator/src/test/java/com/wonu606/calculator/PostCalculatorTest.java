package com.wonu606.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import com.wonu606.calculator.calculator.Calculator;
import com.wonu606.calculator.calculator.PostfixCalculator;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PostCalculatorTest {

    @Test
    @DisplayName("연산자가 1개일 경우")
    void testSingle() {
        // given
        Calculator calculator = new PostfixCalculator();
        List<String> actualList = Arrays.asList("-3", "5.0", "+");
        double expected = -3 + 5.0;

        // when
        double result = calculator.calculate(actualList);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 우선 순위일 경우")
    void testPrecedenceEquals() {
        // given
        Calculator calculator = new PostfixCalculator();
        List<String> actualList = Arrays.asList("3", "5", "+", "2", "-");
        double expected = 3 + 5 - 2;

        // when
        double result = calculator.calculate(actualList);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("높은 우선 순위가 뒤에 올 경우")
    void testHigherPrecedenceFollows() {
        // given
        Calculator calculator = new PostfixCalculator();
        List<String> actualList = Arrays.asList("3", "5", "2", "*", "+");
        double expected = 3 + 5 * 2;

        // when
        double result = calculator.calculate(actualList);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("높은 우선 순위가 앞에 올 경우")
    void testHigherPrecedenceComesFirst() {
        // given
        Calculator calculator = new PostfixCalculator();
        List<String> actualList = Arrays.asList("3", "5", "*", "2", "+");
        double expected = 3 * 5 + 2;

        // when
        double result = calculator.calculate(actualList);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("소수가 나올 경우")
    void testIfFraction() {
        // given
        Calculator calculator = new PostfixCalculator();
        List<String> actualList = Arrays.asList("3", "5", "/", "2", "+");
        double expected = 3.0 / 5 + 2;

        // when
        double result = calculator.calculate(actualList);

        // then
        assertThat(result).isEqualTo(expected);
    }
}