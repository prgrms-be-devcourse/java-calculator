package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("연산자를 주면 사칙연산을 실시한다.")
    @ParameterizedTest
    @CsvSource(value = {"+,1,2,3", "-,5,1,4", "*,5,2,10", "/,6,2,3"})
    void calcute_operator_returnResult(String operator, Double firstNumber, Double secondNumber, Double result) {
        assertThat(calculator.calculate(operator, firstNumber, secondNumber)).isEqualTo(result);
    }

    @DisplayName("/연산자일 때 0으로 나누면 예외를 던진다. ")
    @Test
    void calculate_divide_secondNumberIsZero_throwException() {
        assertThatThrownBy(() -> calculator.calculate("/", 3, 0))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 0으로 나눌 수 없습니다. 다시 입력해주세요.");
    }

    @DisplayName("사칙연산자가 아니라면 예외를 던진다.")
    @ParameterizedTest
    @CsvSource(value = {",1,2", " ,5,1", "**,5,2", "//,6,2"})
    void calculate_notOperand_throwException(String operator, Double firstNumber, Double secondNumber) {
        assertThatThrownBy(() -> calculator.calculate(operator, firstNumber, secondNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 연산자가 아닙니다. 다시 입력해주세요.");
    }
}
