package calculator.calculator.operator;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.function.BinaryOperator;

import static calculator.exception.OperatorException.OPERATORS_EXCEPTION_NULL_FIND;
import static calculator.exception.OperatorException.OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO;

public enum Operators {

    PLUS("+", BigDecimal::add, 1),
    MINUS("-", BigDecimal::subtract, 1),
    MULTIPLY("*", BigDecimal::multiply, 2),
    DIVIDE("/", (leftOperand, rightOperand) -> {
        if (rightOperand.doubleValue() == 0D) {
            throw new IllegalArgumentException(OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO.getMessage());
        }
        return leftOperand.divide(rightOperand, 15, RoundingMode.HALF_UP);
    }, 2);

    private final String operator;
    private final BinaryOperator<BigDecimal> calculation;
    private final int priority;

    Operators(String operator, BinaryOperator<BigDecimal> calculation, int priority) {
        this.operator = operator;
        this.calculation = calculation;
        this.priority = priority;
    }

    public static boolean isOperator(String inputOperator) {
        return Arrays.stream(Operators.values())
                .anyMatch(operator -> operator.operator.equals(inputOperator));
    }

    public static BigDecimal calculate(BigDecimal leftOperand, String operator, BigDecimal rightOperand) {
        return findOperator(operator).doCalculation(leftOperand, rightOperand);
    }

    public BigDecimal doCalculation(BigDecimal leftOperand, BigDecimal rightOperand) {
        return calculation.apply(leftOperand, rightOperand);
    }

    public static boolean isLeftSameOrMoreImportantThan(String leftOperator, String rightOperator) {
        return findOperator(leftOperator).priority >= findOperator(rightOperator).priority;
    }

    private static Operators findOperator(String inputOperator) {
        return Arrays.stream(Operators.values())
                .filter(operator -> operator.operator.equals(inputOperator))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(OPERATORS_EXCEPTION_NULL_FIND.getMessage()));
    }
}
