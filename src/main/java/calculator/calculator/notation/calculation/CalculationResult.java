package calculator.calculator.notation.calculation;

import java.math.BigDecimal;

public class CalculationResult {

    private final BigDecimal calculationResult;

    public CalculationResult(BigDecimal calculationResult) {
        this.calculationResult = calculationResult;
    }

    public BigDecimal getCalculationResult() {
        return calculationResult;
    }
}
