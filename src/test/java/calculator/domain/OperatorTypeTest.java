package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class OperatorTypeTest {

    @DisplayName("from은 연산자를 주면 OperatorType을 반환한다.")
    @ParameterizedTest
    @ValueSource(strings = {"+", "-", "/", "*"})
    void from_operator_returnType(String operator) {
        assertThat(OperatorType.from(operator))
            .isInstanceOf(OperatorType.class);
    }

    @DisplayName("from은 연산자가 아닐 때 예외를 던진다.")
    @ParameterizedTest
    @ValueSource(strings = {"5", "", " ", "//", "s", "++"})
    void from_notOperand_throwException(String notOperator) {
        assertThatThrownBy(() -> OperatorType.from(notOperator))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 연산자가 아닙니다. 다시 입력해주세요.");
    }

    @DisplayName("연산자와 값을 주면 사칙연산을 실시한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,1,2,3", "-,5,1,4", "*,5,2,10", "/,6,2,3"})
    void calcute_operator_returnResult(String operator, Double firstNumber, Double secondNumber, Double result) {
        assertThat(OperatorType.calculate(operator, firstNumber, secondNumber)).isEqualTo(result);
    }

    @DisplayName("/연산자일 때 0으로 나누면 예외를 던진다. ")
    @Test
    void calculate_divide_secondNumberIsZero_throwException() {
        assertThatThrownBy(() -> OperatorType.calculate("/", 3, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 0으로 나눌 수 없습니다. 다시 입력해주세요.");
    }

    @DisplayName("사칙연산자가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @CsvSource(value = {",1,2", " ,5,1", "**,5,2", "//,6,2"})
    void calculate_notOperand_throwException(String operator, Double firstNumber, Double secondNumber) {
        assertThatThrownBy(() -> OperatorType.calculate(operator, firstNumber, secondNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 연산자가 아닙니다. 다시 입력해주세요.");
    }
}
