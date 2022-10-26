package calculator.engine.model;

import java.math.BigDecimal;

public class CalculationResult {
    private final BigDecimal result;

    public CalculationResult(String result) {
        this.result = new BigDecimal(result);
    }

    public BigDecimal getResult() {
        return result;
    }

    @Override
    public String toString() {
        return result.toString();
    }
}
