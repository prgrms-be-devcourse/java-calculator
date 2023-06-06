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
    @ValueSource(strings = {
            "1 / 0"
            ,"1 * 5 / 0"
    })
    void 계산식_0으로_나누면_에러반환(String equation) {
        Calculator calculator = new Calculator(equation);

        assertThatThrownBy(()->new Calculator(equation))
                .isInstanceOf(NotSolveEquationException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3, 7"
            ,"1 + 2, 3"
            ,"1,1"
            ,"-1,1"
            ,"1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 / 2 + 1 / 2 + 8 / 4 * 2, 5"
            ,"3 / 4 - 1 / 4, 0.5"
    })
    void 계산식_계산(String equation, double result) {
        assertThat(result).isEqualTo(new Calculator(equation).getResult());
    }
}
