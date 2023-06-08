package calculator.domain;

import calculator.exception.NotSolveEquationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3, 7"
            ,"1 + 2, 3"
            ,"1,1"
            ,"-1, -1"
            ,"1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 / 2 + 1 / 2 + 8 / 4 * 2, 5"
            ,"3 / 4 - 1 / 4, 0.5"
    })
    void 계산식_결과출력(String equation, double result) {
        assertThat(equation+" = " +result).isEqualTo(new Calculator(equation, result).toString());
    }
}
