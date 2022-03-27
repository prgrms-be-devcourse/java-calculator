package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    @Test
    @DisplayName("입력값_검증_테스트")
    void valid() {
        assertThat(InputValidator.valid(null)).isFalse();
        assertThat(InputValidator.valid(new String[]{})).isFalse();
        assertThat(InputValidator.valid(new String[]{"1"})).isFalse();
        assertThat(InputValidator.valid(new String[]{"1","+"})).isFalse();
        assertThat(InputValidator.valid(new String[]{"1","+","2"})).isTrue();
        assertThat(InputValidator.valid(new String[]{"1","+","2","3"})).isFalse();
    }

    @Test
    @DisplayName("숫자_검증_테스트")
    void isNumber() {
        assertThat(InputValidator.isNumber(null)).isFalse();
        assertThat(InputValidator.isNumber("")).isFalse();
        assertThat(InputValidator.isNumber(" ")).isFalse();
        assertThat(InputValidator.isNumber("1")).isTrue();
        assertThat(InputValidator.isNumber("1.0")).isTrue();
        assertThat(InputValidator.isNumber("-1.0")).isTrue();
        assertThat(InputValidator.isNumber("-")).isFalse();
    }

    @Test
    @DisplayName("연산자_검증_테스트")
    void isOperator() {
        assertThat(InputValidator.isOperator(null)).isFalse();
        assertThat(InputValidator.isOperator("")).isFalse();
        assertThat(InputValidator.isOperator(" ")).isFalse();
        assertThat(InputValidator.isOperator("+")).isTrue();
        assertThat(InputValidator.isOperator("-")).isTrue();
        assertThat(InputValidator.isOperator("*")).isTrue();
        assertThat(InputValidator.isOperator("/")).isTrue();
        assertThat(InputValidator.isOperator("/+")).isFalse();
        assertThat(InputValidator.isOperator("1")).isFalse();
    }
}
