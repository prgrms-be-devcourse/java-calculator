package calculator.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import util.IllegalException;

import static org.assertj.core.api.Assertions.*;

public class PostCalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void PostCalculatorTest() {
        calculator = new Calculator(new PostFixCalculate());
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "1 / 0"
            ,"1 * 5 / 0"
    })
    void 계산식_0으로_나누면_에러반환(String equation) {

        assertThatThrownBy(()->calculator.calculate(equation))
                .isInstanceOf(IllegalException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1 + 2 * 3, 7"
            ,"1 + 2, 3"
            ,"1,1"
            ,"-1, -1"
            ,"1 + 3 / 3 * 4 * ( 5 + 6 ), 45"
            ,"1 + 2 * 3 + 5 / 5 + 1 + 4, 13"
            ,"1 / 2 + 1 / 2 + 8 / 4 * 2, 5"
            ,"3 / 4 - 1 / 4, 0.5"

    })
    void 계산식_계산(String equation, double result) {
        calculator.calculate(equation);

        assertThat(result)
                .isEqualTo(calculator.getResult());
    }
}
