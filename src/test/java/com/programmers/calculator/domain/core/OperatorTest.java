package com.programmers.calculator.domain.core;

import com.programmers.calculator.domain.vo.CalculationResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OperatorTest {

    @DisplayName("0으로 나눴을 때 예외를 던지는지 확인")
    @ParameterizedTest
    @CsvSource({"5, 0", "13, 0"})
    void division_by_zero_throw_exception(BigDecimal testOperand1, BigDecimal testOperand2) {

        // given
        Operator division = Operator.DIVISION;

        CalculationResult operand1 = new CalculationResult(testOperand1);
        CalculationResult operand2 = new CalculationResult(testOperand2);

        // when
        assertThatThrownBy(() -> division.getFunction()
                .apply(operand1, operand2))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");

    }

    @DisplayName("연산자를 파라미터로 넘겨주면, 그에 맞는 Operator가 반환")
    @ParameterizedTest
    @ValueSource(chars = {'+', '-', '*', '/'})
    void operator_of_success(char operatorChar) {

        // given
        Operator operator = Operator.of(operatorChar);

        // then
        assertThat(operator.getSymbol()).isEqualTo(operatorChar);
    }

    @DisplayName("연산자가 아닌 값들을 파라미터로 넘겨주면, 예외가 발생")
    @ParameterizedTest
    @ValueSource(chars = {'|', '`', 'z', '1', '3'})
    void of_throws_exception(char notOperatorChar) {

        // then
        assertThatThrownBy(() -> Operator.of(notOperatorChar))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 연산자입니다.");
    }
}