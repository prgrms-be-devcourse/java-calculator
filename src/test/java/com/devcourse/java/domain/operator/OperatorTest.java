package com.devcourse.java.domain.operator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class OperatorTest {
    private final OperatorMapper factory = new OperatorMapper();

    @Nested
    @DisplayName("덧셈 연산자 테스트")
    class plusOperator {
        @ParameterizedTest
        @DisplayName("입력에 맞게 결과가 출력되어야 한다.")
        @MethodSource("plusData")
        void plusTest(double x, double y, double result) {
            // given
            Operator operator = factory.toOperator("+");

            // when
            double operated = operator.operate(x, y);

            // then
            assertThat(operated).isEqualTo(result);
        }

        static Stream<Arguments> plusData() {
            return Stream.of(
                    arguments(2, 3, 5),
                    arguments(7, 9, 16),
                    arguments(-4, 6, 2),
                    arguments(45, 55, 100)
            );
        }
    }

    @Nested
    @DisplayName("빼기 연산자 테스트")
    class minusOperator {
        @ParameterizedTest
        @DisplayName("입력에 맞게 결과가 출력되어야 한다.")
        @MethodSource("minusData")
        void minusTest(double x, double y, double result) {
            // given
            Operator operator = factory.toOperator("-");

            // when
            double operated = operator.operate(x, y);

            // then
            assertThat(operated).isEqualTo(result);
        }

        static Stream<Arguments> minusData() {
            return Stream.of(
                    arguments(10, 5, 5),
                    arguments(8, 3, 5),
                    arguments(15, 7, 8),
                    arguments(-1, 3, -4)
            );
        }
    }

    @Nested
    @DisplayName("곱셈 연산자 테스트")
    class multiplyOperator {
        @ParameterizedTest
        @DisplayName("입력에 맞게 결과가 출력되어야 한다.")
        @MethodSource("multiplyData")
        void multiplyTest(double x, double y, double result) {
            // given
            Operator operator = factory.toOperator("*");

            // when
            double operated = operator.operate(x, y);

            // then
            assertThat(operated).isEqualTo(result);
        }

        static Stream<Arguments> multiplyData() {
            return Stream.of(
                    arguments(2, 3, 6),
                    arguments(7, 9, 63),
                    arguments(-4, 6, -24),
                    arguments(-1, 0, 0)
            );
        }
    }

    @Nested
    @DisplayName("나눗셈 연산자 테스트")
    class divideOperator {
        private final Operator operator = factory.toOperator("/");

        @ParameterizedTest
        @DisplayName("[성공] 입력에 맞게 결과가 출력되어야 한다.")
        @MethodSource("divideData")
        void divideSuccessTest(double x, double y, double result) {
            // given

            // when
            double operated = operator.operate(x, y);

            // then
            assertThat(operated).isEqualTo(result);
        }

        @Test
        @DisplayName("[실패] 0으로 나눠서 실패한다.")
        void divideFailByZeroTest() {
            // given
            double x = 1;
            double y = 0;

            assertThatThrownBy(() -> operator.operate(x, y))
                    .withFailMessage("0으로 나눌 수 없습니다.");
        }

        static Stream<Arguments> divideData() {
            return Stream.of(
                    arguments(10, 2, 5.0),
                    arguments(15, 3, 5.0),
                    arguments(8, 4, 2.0),
                    arguments(0, 10, 0)
            );
        }
    }
}
