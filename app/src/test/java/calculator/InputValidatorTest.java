package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    static private InputValidator inputValidator;

    @BeforeAll
    static void setUp() {
        inputValidator = new InputValidator();
    }

    @Test
    @DisplayName("입력값_검증_테스트")
    void valid() {
        assertThat(inputValidator.valid(null)).isFalse();
        assertThat(inputValidator.valid(new String[]{})).isFalse();
        assertThat(inputValidator.valid(new String[]{"1"})).isFalse();
        assertThat(inputValidator.valid(new String[]{"1", "+"})).isFalse();
        assertThat(inputValidator.valid(new String[]{"1", "+", "2"})).isTrue();
        assertThat(inputValidator.valid(new String[]{"1", "+", "2", "3"})).isFalse();
    }
}
