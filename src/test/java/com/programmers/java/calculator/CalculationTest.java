package com.programmers.java.calculator;

import com.programmers.java.calculator.converter.PostfixExpressionConverter;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculationTest {

    CalculatorService calculatorService = new CalculatorServiceImpl(new PostfixExpressionConverter());

    @Nested
    class successCase {
        @Test
        void additionTest() {
            String result = calculatorService.calculate("12 + 34.5");
            assertThat(result).isEqualTo("46.5");
        }

        @Test
        void subtractionTest() {
            String result = calculatorService.calculate("12 - 34.5");
            assertThat(result).isEqualTo("-22.5");
        }

        @Test
        void multiplicationTest() {
            String result = calculatorService.calculate("12 * 3.4");
            assertThat(result).isEqualTo("40.8");
        }

        @Test
        void divisionTest() {
            String result = calculatorService.calculate("34 / 8.5");
            assertThat(result).isEqualTo("4");
        }
    }

    @Nested
    class failCase {
        @Test
        void calculationErrorTest() {
            assertThatThrownBy(() -> calculatorService.calculate("a + b"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못 입력되었습니다");
        }
    }
}
