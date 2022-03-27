package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    static private StringCalculator stringCalculator;

    @BeforeAll
    static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열_계산기_계산_테스트")
    void calculate() throws Exception {
        assertThatThrownBy(() -> stringCalculator.calculate(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.calculate("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.calculate("1 + 2 / 0")).isInstanceOf(IllegalArgumentException.class);
        assertThat(stringCalculator.calculate("1 + 2")).isEqualTo(3.0);
        assertThat(stringCalculator.calculate("1 * 2")).isEqualTo(2.0);
        assertThat(stringCalculator.calculate("1 + 2 / 2")).isEqualTo(2.0);
        assertThat(stringCalculator.calculate("1 / 2 / 2")).isEqualTo(0.25);
    }
}
