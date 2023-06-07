package calculator.service;

import calculator.domain.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorServiceTest {
    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1"
    })
    void 계산식으로_결과도출후_String으로_반환(String userInput, double result) {
        Calculator c = new Calculator(userInput);

        assertThat(userInput+" = "+result)
                .isEqualTo(c.toString());
    }
}
