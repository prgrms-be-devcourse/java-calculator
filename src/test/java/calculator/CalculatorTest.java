package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @DisplayName("연산자로 +를 주면 더하기 연산을 실시한다.")
    @Test
    void calculate_add() {
        assertThat(calculator.calculate("+", 1, 2)).isEqualTo(3);
    }

    @DisplayName("연산자로 -를 주면 빼기 연산을 실시한다.")
    @Test
    void calculate_subtract() {
        assertThat(calculator.calculate("-", 5, 1)).isEqualTo(4);
    }

    @DisplayName("연산자로 *를 주면 곱하기 연산을 실시한다.")
    @Test
    void calculate_multiply() {
        assertThat(calculator.calculate("*", 5, 2)).isEqualTo(10);
    }

    @DisplayName("연산자로 /를 주면 나누기 연산을 실시한다.")
    @Test
    void calculate_divide() {
        assertThat(calculator.calculate("/", 6, 2)).isEqualTo(3);
    }

    @DisplayName("연산자로 사칙연산자가 아닌 값을 주면 예외를 던진다.")
    @Test
    void calculate_notOperand_throwException() {
        assertThatThrownBy(() -> calculator.calculate("", 3, 4))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 연산자가 아닙니다. 다시 입력해주세요.");
    }
}
