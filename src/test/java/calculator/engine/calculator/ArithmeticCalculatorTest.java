package calculator.engine.calculator;

import calculator.application.io.Parser;
import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticCalculatorTest {
    private final ArithmeticCalculator calculator = new PostfixCalculator();

    @DisplayName("후위식 연산 테스트")
    @Test
    void test1() {
        Expression postfix = new Expression(Parser.toList("3 5 2 + * 9 -"));
        CalculationResult answer = new CalculationResult("12");

        CalculationResult result = calculator.calculate(postfix);

        assertThat(result.getResult()).isEqualTo(answer.getResult());
    }
}