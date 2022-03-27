package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    static Calculator calculator;
    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }
    @Test
    @DisplayName("더하기_기능_테스트")
    void plus() {
        assertThat(calculator.plus(1.0,2.0)).isEqualTo(3.0);
        assertThat(calculator.plus(1.0,0.0)).isEqualTo(1.0);
        assertThat(calculator.plus(1.0,-2.0)).isEqualTo(-1.0);
    }

    @Test
    @DisplayName("뺴기_기능_테스트")
    void minus() {
        assertThat(calculator.minus(0.0,0.0)).isEqualTo(0.0);
        assertThat(calculator.minus(0.0,1.0)).isEqualTo(-1.0);
        assertThat(calculator.minus(1.0,0.0)).isEqualTo(1.0);
    }

    @Test
    @DisplayName("곱하기_기능_테스트")
    void multiply() {
        assertThat(calculator.multiply(2.0,0.0)).isEqualTo(0.0);
        assertThat(calculator.multiply(2.0,1.0)).isEqualTo(2.0);
        assertThat(calculator.multiply(2.0,-2.0)).isEqualTo(-4.0);
    }

    @Test
    @DisplayName("나누기_기능_테스트")
    void divied() {
        assertThat(calculator.divied(2.0,1.0)).isEqualTo(2.0);
        assertThat(calculator.divied(1.0,-2.0)).isEqualTo(-0.5);
        assertThatThrownBy(()->calculator.divied(2.0,0.0)).isInstanceOf(IllegalArgumentException.class);
    }
}
