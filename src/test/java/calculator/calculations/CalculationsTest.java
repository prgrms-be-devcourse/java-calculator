package calculator.calculations;

import calculator.parse.StackParser;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {

    @DisplayName("덧셈 기능 테스트")
    @Test
    void validAddTest() {
        int a = 3;
        int b = 234;
        int want = 237;

        int got = Calculations.add(a, b);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("뺄셈 기능 테스트")
    @Test
    void validSubTest() {
        int a = 6;
        int b = 7;
        int want = -1;

        int got = Calculations.sub(a, b);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("곱셈 기능 테스트")
    @Test
    void validMulTest() {
        int a = 3;
        int b = 7;
        int want = 21;

        int got = Calculations.mul(a, b);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("나눗셈 기능 테스트")
    @Test
    void validDivTest() {
        int a = 8;
        int b = 2;

        int want  = 4;

        int got = Calculations.div(a, b);

        Assertions.assertThat(got).isEqualTo(want);
    }

    @DisplayName("0으로 나눌때 예외 발생")
    @Test
    void divideZeroTest() {
        int a = 6;
        int b = 0;

        ArithmeticException e = assertThrows(ArithmeticException.class, () -> Calculations.div(a, b));

        Assertions.assertThat(e.getMessage()).isEqualTo(Calculations.DIVIDE_BY_ZERO);
    }
}