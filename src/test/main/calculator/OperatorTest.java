package main.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {
    Operator operator = new Operator();

    @Test
    @DisplayName("덧셈 성공")
    void plus() {
        String input = "1 + 3";
        double answer = 1 + 3;
        double result = Double.parseDouble(operator.calculate(input));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("뺄셈 성공")
    void minus() {
        String input = "3 - 1";
        double answer = 3 - 1;
        double result = Double.parseDouble(operator.calculate(input));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("곱셉 성공")
    void multiply() {
        String input = "3 * 2";
        double answer = 3 * 2;
        double result = Double.parseDouble(operator.calculate(input));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("나눗셈 성공")
    void divide() {
        String input = "4 / 2";
        double answer = 4 / 2;
        double result = Double.parseDouble(operator.calculate(input));

        assertThat(result).isEqualTo(answer);
    }

    @Test
    @DisplayName("사칙연산 성공")
    void arithmeticOperation() {
        String input = "2 + 8 / 2 + 6 * 4";
        double answer = 2 + 8 / 2 + 6 * 4;
        double result = Double.parseDouble(operator.calculate(input));

        assertThat(result).isEqualTo(answer);
    }
}
