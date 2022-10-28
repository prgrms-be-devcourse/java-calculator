package calculator.calculator.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BinaryOperator;

import static calculator.exception.OperatorException.OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO;

public enum OperatorCalculation {

    PLUS_CALCULATOR(BigDecimal::add),
    MINUS_CALCULATOR(BigDecimal::subtract),
    MULTIPLY_CALCULATOR(BigDecimal::multiply),
    DIVIDE_CALCULATOR((leftOperand, rightOperand) -> {
        if (rightOperand.doubleValue() == 0D) {
            throw new IllegalArgumentException(OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO.getMessage());
        }
        return leftOperand.divide(rightOperand, 15, RoundingMode.HALF_UP);
    });

    private final BinaryOperator<BigDecimal> calculation;

    OperatorCalculation(BinaryOperator<BigDecimal> calculation) {
        this.calculation = calculation;
    }

    public BigDecimal doCalculation(BigDecimal leftOperand, BigDecimal rightOperand) {
        return calculation.apply(leftOperand, rightOperand);
    }
}
