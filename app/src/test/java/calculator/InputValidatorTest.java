package javacalculator.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidatorTest {
    static private InputValidator inputValidator;

    @BeforeAll
    static void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @DisplayName("입력값_검증_테스트")
    @CsvSource({"1,false", "1 +,false", "1 + 2 3,false", "1 + 2,true"})
    void valid(String formula, boolean expect) {
        String[] splitedFormula = formula.split(" ");
        assertThat(inputValidator.valid(splitedFormula)).isEqualTo(expect);
    }

    @Test
    @DisplayName("입력값_검증_테스트 - null or empty")
    void validWithNullOrEmpty() {
        assertThat(inputValidator.valid(null)).isFalse();
        assertThat(inputValidator.valid(new String[]{})).isFalse();
    }

}
