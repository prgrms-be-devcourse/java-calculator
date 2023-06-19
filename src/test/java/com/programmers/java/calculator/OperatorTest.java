package com.programmers.java.calculator;

import com.programmers.java.calculator.domain.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1", "3.5", "-64", "-27.3"})
    @DisplayName("피연산자 판단 테스트")
    void isNumericTest(String number) {
        assertTrue(Operator.isNumeric(number));
    }

    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "*", "/"})
    @DisplayName("연산자 판단 테스트")
    void isOperatorTest(String operator) {
        assertTrue(Operator.isOperator(operator));
    }

    @ParameterizedTest
    @MethodSource("provideOperator")
    @DisplayName("연산자 비교 테스트")
    void comparePriorityTest(Operator operator1, Operator operator2, int expected) {
        assertThat(operator1.comparePriority(operator2)).isEqualTo(expected);
    }

    @ParameterizedTest
    @EnumSource(Operator.class)
    @DisplayName("연산자 반환 테스트")
    void isOperatorTest(Operator operator) {
        assertThat(Operator.of(operator.getSymbol())).isEqualTo(operator);
    }

    private static Stream<Arguments> provideOperator() {
        return Stream.of(
                Arguments.of(Operator.ADDITION, Operator.SUBTRACTION, 0),
                Arguments.of(Operator.ADDITION, Operator.MULTIPLICATION, 1),
                Arguments.of(Operator.MULTIPLICATION, Operator.ADDITION, -1),
                Arguments.of(Operator.MULTIPLICATION, Operator.DIVISION, 0)
        );
    }
}
