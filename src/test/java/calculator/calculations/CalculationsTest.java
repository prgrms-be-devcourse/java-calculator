package calculator.calculations;

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
}