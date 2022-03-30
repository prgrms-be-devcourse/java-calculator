package javacalculator.calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    static private StringCalculator stringCalculator;

    @BeforeAll
    static void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    @DisplayName("문자열_계산기_계산_테스트-에러케이스")
    void calculateWithError() {
        assertThatThrownBy(() -> stringCalculator.calculate(null)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.calculate("")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> stringCalculator.calculate("1 + 2 / 0")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("문자열 계산기 계산 테스트-정상입력")
    @CsvSource({"1 + 2,3.0", "1 * 2,2.0", "1 + 2 / 2,2.0", "1 / 2 / 2,0.25"})
    void calculate(String stringFormula, double expect) throws Exception {
        assertThat(stringCalculator.calculate(stringFormula)).isEqualTo(expect);
    }
}
