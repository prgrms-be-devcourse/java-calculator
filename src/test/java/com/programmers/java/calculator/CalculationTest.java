package com.programmers.java.calculator;

import com.programmers.java.calculator.converter.PostfixExpressionConverter;
import com.programmers.java.calculator.repository.MemoryCalculatorRepository;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculationTest {

    CalculatorService calculatorService = new CalculatorServiceImpl(
            new PostfixExpressionConverter(),
            new MemoryCalculatorRepository());

    @Nested
    @DisplayName("계산 성공 테스트")
    class successCase {

        @Test
        @DisplayName("덧셈")
        void additionTest() {
            String result = calculatorService.calculate("12 + 34.5");
            assertThat(result).isEqualTo("46.5");
        }

        @Test
        @DisplayName("뺄셈")
        void subtractionTest() {
            String result = calculatorService.calculate("12 - 34.5");
            assertThat(result).isEqualTo("-22.5");
        }

        @Test
        @DisplayName("곱셈")
        void multiplicationTest() {
            String result = calculatorService.calculate("12 * 3.4");
            assertThat(result).isEqualTo("40.8");
        }

        @Test
        @DisplayName("나눗셈")
        void divisionTest() {
            String result = calculatorService.calculate("34 / 8.5");
            assertThat(result).isEqualTo("4");
        }
    }

    @Nested
    @DisplayName("계산 실패 테스트")
    class failCase {

        @Test
        @DisplayName("입력 예외")
        void calculationErrorTest() {
            assertThatThrownBy(() -> calculatorService.calculate("a + b"))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못 입력되었습니다");
        }
    }
}
