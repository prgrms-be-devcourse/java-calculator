package calculator.calculator.operator;

import java.math.BigDecimal;
import java.util.Arrays;

import static calculator.calculator.operator.OperatorCalculation.*;
import static calculator.calculator.operator.OperatorPriority.*;
import static calculator.exception.OperatorException.OPERATORS_EXCEPTION_NULL_FIND;

public enum Operators {

    PLUS("+", PLUS_CALCULATOR, PLUS_PRIORITY),
    MINUS("-", MINUS_CALCULATOR, MINUS_PRIORITY),
    MULTIPLY("*", MULTIPLY_CALCULATOR, MULTIPLY_PRIORITY),
    DIVIDE("/", DIVIDE_CALCULATOR, DIVIDE_PRIORITY);

    private final String operator;
    private final OperatorCalculation calculation;
    private final OperatorPriority priority;

    Operators(String operator, OperatorCalculation calculation, OperatorPriority priority) {
        this.operator = operator;
        this.calculation = calculation;
        this.priority = priority;
    }

    public static boolean isOperator(String inputOperator) {
        return Arrays.stream(Operators.values())
                .anyMatch(operator -> operator.operator.equals(inputOperator));
    }

    public static String calculate(BigDecimal leftOperand, String operator, BigDecimal rightOperand) {
        return findOperator(operator).calculation
                .doCalculation(leftOperand, rightOperand)
                .toString();
    }

    public static boolean isLeftSameOrMoreImportantThan(String leftOperator, String rightOperator) {
        return isLeftSameOrMoreImportantThanRight(
                findOperator(leftOperator).priority,
                findOperator(rightOperator).priority);
    }

    private static Operators findOperator(String inputOperator) {
        return Arrays.stream(Operators.values())
                .filter(operator -> operator.operator.equals(inputOperator))
                .findFirst()
                .orElseThrow(() -> new NullPointerException(OPERATORS_EXCEPTION_NULL_FIND.getMessage()));
    }
}
