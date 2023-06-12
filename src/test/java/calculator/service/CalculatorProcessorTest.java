package calculator.service;

import calculator.domain.Expression;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Calculator Processor 테스트")
public class CalculatorProcessorTest {
    private CalculatorProcessor calculatorProcessor;

    @BeforeEach
    public void beforeEach() {
        calculatorProcessor = new CalculatorProcessor();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "1 + 1 + 1, 3",
            "1 + 2 * 3, 7",
            "10 - 5 / 5 + 1 * 2, 11"})
    void 연산식이_정상이라면_결과리턴(String input, int expectedResult) {
        // given
        Expression expression = new Expression(input);

        // when
        int result = calculatorProcessor.calculate(expression);

        // then
        assertEquals(expectedResult, result);
    }
}
