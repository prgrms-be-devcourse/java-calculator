package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    @DisplayName("더하기_기능_테스트")
    void plus() {
        assertThat(Calculator.plus(1.0,2.0)).isEqualTo(3.0);
    }

    @Test
    @DisplayName("뺴기_기능_테스트")
    void minus() {
        assertThat(Calculator.minus(0.0,0.0)).isEqualTo(0.0);
        assertThat(Calculator.minus(0.0,1.0)).isEqualTo(-1.0);
        assertThat(Calculator.minus(1.0,0.0)).isEqualTo(1.0);
    }
}
