package calculator.calculator.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;

import static calculator.exception.OperatorException.OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO;

public enum OperatorCalculation {

    PLUS_CALCULATOR(BigDecimal::add),
    MINUS_CALCULATOR((leftOperand, rightOperand) -> {
        BigDecimal minusRightOperand = BigDecimal.valueOf(-rightOperand.doubleValue());
        return leftOperand.add(minusRightOperand);
    }),
    MULTIPLY_CALCULATOR(BigDecimal::multiply),
    DIVIDE_CALCULATOR((leftOperand, rightOperand) -> {
        if (rightOperand.doubleValue() == 0D) {
            throw new IllegalArgumentException(OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO.message);
        }
        return leftOperand.divide(rightOperand, 15, RoundingMode.HALF_UP);
    });

    private final BiFunction<BigDecimal, BigDecimal, BigDecimal> calculation;

    OperatorCalculation(BiFunction<BigDecimal, BigDecimal, BigDecimal> calculation) {
        this.calculation = calculation;
    }

    public BigDecimal doCalculation(BigDecimal leftOperand, BigDecimal rightOperand) {
        return calculation.apply(leftOperand, rightOperand);
    }
}
