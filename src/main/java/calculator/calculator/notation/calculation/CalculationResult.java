package calculator.calculator.notation.calculation;

import java.math.BigDecimal;

public class CalculationResult {

    private final BigDecimal result;

    public CalculationResult(BigDecimal calculationResult) {
        this.result = calculationResult;
    }

    public BigDecimal getResult() {
        return result;
    }

    public CalculationResult clone() {
        return new CalculationResult(result);
    }
}
