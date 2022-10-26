package calculator.engine.repository;

import calculator.application.io.Parser;
import calculator.engine.controller.Calculator;
import calculator.engine.model.CalculationResult;
import calculator.engine.model.Expression;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HistoryTest {
    private final CalculationHistory history = new CalculationHistory();
    private final Calculator calculator = new Calculator();

    @Test
    void should_record_properly_for_valid_calculation() {
        Expression infix = new Expression(Parser.toList("3 + 5 / 2 * 4 - 1"));
        CalculationResult result = calculator.calculate(infix);

        history.record(infix, result);
        history.record(infix, result);

        assertThat(history.getHistory()).size().isEqualTo(2);
        System.out.println(history.getLiterals());
    }
}