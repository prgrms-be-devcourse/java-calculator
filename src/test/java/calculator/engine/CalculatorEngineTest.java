package calculator.engine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CalculatorEngineTest {

    @DisplayName("0으로 나눌 경우 예외가 발생한다.")
    @Test
    void 뺄셈_연산_예외() {
        ArithmeticException e = assertThrows(ArithmeticException.class, () -> CalculatorEngine.execute(100, 0, "/"));
        assertThat(e.getMessage()).isEqualTo("0으로 나눌 수 없습니다");
    }

    @DisplayName("덧셈 연산이 정상적으로 동작한다.")
    @Test
    void 덧셈_연산_정상_동작() {
        int result = CalculatorEngine.execute(100, 1000, "+").get();

        assertThat(result).isEqualTo(1100);
    }

    @DisplayName("뺄셈 연산이 정상적으로 동작한다.")
    @Test
    void 뺄셈_연산_정상_동작() {
        int result = CalculatorEngine.execute(120, 3, "-").get();

        assertThat(result).isEqualTo(117);
    }

    @DisplayName("나눗셈 연산이 정상적으로 동작한다.")
    @Test
    void 나눗셈_연산_정상_동작() {
        int result = CalculatorEngine.execute(50, 2, "/").get();

        assertThat(result).isEqualTo(25);
    }

    @DisplayName("곱셈 연산이 정상적으로 동작한다.")
    @Test
    void 곱셈_연산_정상_동작() {
        int result = CalculatorEngine.execute(12, 4, "*").get();

        assertThat(result).isEqualTo(48);
    }
}
