import model.vo.MathExpression;
import exception.CalculatorException;
import model.CalculationLog;
import model.calculator.Calculator;
import model.calculator.CalculatorImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import repository.CalculationLogRepository;
import repository.CalculationLogRepositoryImpl;

import java.util.List;


public class LogSaveTest {
    private final CalculationLogRepository clrp = new CalculationLogRepositoryImpl();
    private final Calculator calculator = new CalculatorImpl();

    @DisplayName(value = "연산결과 저장 후 출력")
    @Test
    public void 저장_테스트() throws CalculatorException {
        List<String> expressions = List.of
                (
                    "0 + 1 + 2 - 5",
                    "10 * 2 / 2 - 0",
                    "100 + 50 * 2 - 100 / 50",
                    "10 + 100 / 5 * 2 * 4 - 5",
                    "-10 - -40 * -3",
                    "-10 * -5 + 10"
                );
        for (String expression : expressions) {
            int result = calculator.calculate(MathExpression.from(expression));
            clrp.save(CalculationLog.of(expression, result));
        }
        clrp.viewLog();
    }
}
