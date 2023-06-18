package com.programmers.calculator.domain.vo;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class CalculationResult {
    private final BigDecimal value;

    public CalculationResult(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public CalculationResult add(CalculationResult otherValue) {
        return new CalculationResult(value.add(otherValue.getValue()));
    }

    public CalculationResult subtract(CalculationResult otherValue) {
        return new CalculationResult(value.subtract(otherValue.getValue()));
    }

    public CalculationResult multiply(CalculationResult otherValue) {
        return new CalculationResult(value.multiply(otherValue.getValue()));
    }

    public CalculationResult divide(CalculationResult otherValue) {
        return new CalculationResult(value.divide(otherValue.getValue(), 5, RoundingMode.HALF_UP));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
