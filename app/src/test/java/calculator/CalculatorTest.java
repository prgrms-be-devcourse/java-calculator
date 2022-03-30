package javacalculator.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    static Calculator calculator;

    @BeforeAll
    static void setUp() {
        calculator = new Calculator();
    }

    @ParameterizedTest
    @DisplayName("더하기_기능_테스트")
    @CsvSource({"1.0,2.0,3.0","1.0,0.0,1.0","1.0,-2.0,-1.0"})
    void plus(double operand1, double operand2, double expect) {
        assertThat(calculator.plus(operand1, operand2)).isEqualTo(expect);
    }
    @ParameterizedTest
    @DisplayName("뺴기_기능_테스트")
    @CsvSource({"0.0,0.0,0.0","0.0,1.0,-1.0","1.0,0.0,1.0"})
    void minus(double operand1, double operand2, double expect) {
        assertThat(calculator.minus(operand1, operand2)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("곱하기_기능_테스트")
    @CsvSource({"2.0,0.0,0.0","2.0,1.0,2.0","2.0,-2.0,-4.0"})
    void multiply(double operand1, double operand2, double expect) {
        assertThat(calculator.multiply(operand1, operand2)).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("나누기_기능_테스트")
    @CsvSource({"2.0,1.0,2.0","1.0,-2.0,-0.5",})
    void divied(double operand1, double operand2, double expect) {
        assertThat(calculator.divied(operand1, operand2)).isEqualTo(expect);
    }
    @Test
    @DisplayName("나누기 기능 테스트 - 0으로 나눌 때")
    void diviedWithZero() {
        assertThatThrownBy(() -> calculator.divied(2.0, 0.0)).isInstanceOf(IllegalArgumentException.class);
    }

}
