package calculator;

import function.Calculation;
import function.Storage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @DisplayName("중위표현식을 후위표현식으로 변환한다.")
    @Test
    void checkPostfixExpression() {
        final String infixExp = "3 + 5 * 2 / ( 7 - 2 )";
        final String postfixExp = "3 5 2 * 7 2 - / + ";

        final Calculation calculation = new Calculation();
        assertThat(calculation.convertPostfix(infixExp)).isEqualTo(postfixExp);
    }

    @DisplayName("후위표현식을 계산한 결과를 출력한다.")
    @Test
    void checkResult() {
        final String postfixExp = "3 5 2 * 7 2 - / +";
        final double result = 5;

        final Calculation calculation = new Calculation();
        assertThat(calculation.calculatePostfix(postfixExp)).isEqualTo(result);
    }

    @DisplayName("계산한 결과가 저장된다.")
    @Test
    void checkStore() {
        final String exp1 = "2 + 3 = 5";

        final Storage storage = new Storage();
        storage.store(exp1);

        assertThat(storage.print().replace("\n", "")).isEqualTo(exp1);
    }
}
