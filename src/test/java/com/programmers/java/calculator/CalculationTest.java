package com.programmers.java.calculator;

import com.programmers.java.calculator.converter.PostfixExpressionConverter;
import com.programmers.java.calculator.repository.MemoryCalculatorRepository;
import com.programmers.java.calculator.service.CalculatorService;
import com.programmers.java.calculator.service.CalculatorServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculationTest {

    CalculatorService calculatorService = new CalculatorServiceImpl(
            new PostfixExpressionConverter(),
            new MemoryCalculatorRepository());

    @Nested
    @DisplayName("계산 성공 테스트")
    class successCase {

        @ParameterizedTest
        @CsvSource({"12 + 34.5, 46.5", "12 - 34.5, -22.5", "12 * 3.4, 40.8", "34 / 8.5, 4"})
        @DisplayName("사칙연산")
        void fourArithmeticTest(String expression, String expected) {
            String result = calculatorService.calculate(expression);
            assertThat(result).isEqualTo(expected);
        }

        @ParameterizedTest
        @CsvSource({"4 + 3 / 2, 5.5", "4 - 3 * 2, -2", "5 / 2 + 4 * 3, 14.5"})
        @DisplayName("연산자 우선순위")
        void operatorPriorityTest(String expression, String expected) {
            String result = calculatorService.calculate(expression);
            assertThat(result).isEqualTo(expected);
        }
    }

    @Nested
    @DisplayName("계산 실패 테스트")
    class failCase {

        @ParameterizedTest
        @ValueSource(strings = {"3 + a", "1 a 2", "a + b"})
        @DisplayName("입력 예외")
        void calculationErrorTest(String expression) {
            assertThatThrownBy(() -> calculatorService.calculate(expression))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("잘못 입력되었습니다");
        }
    }
}
