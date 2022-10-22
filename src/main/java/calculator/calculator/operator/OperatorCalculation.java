package calculator.calculator.operator;

import java.util.function.ToDoubleBiFunction;

import static calculator.exception.OperatorException.OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO;

public enum OperatorCalculation {

    PLUS_CALCULATOR((leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS_CALCULATOR((leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY_CALCULATOR((leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE_CALCULATOR((leftOperand, rightOperand) -> {
        if (rightOperand == 0D) {
            throw new IllegalArgumentException(OPERATOR_CALCULATION_EXCEPTION_DIVIDE_ZERO.message);
        }
        return leftOperand / rightOperand;
    });

    private final ToDoubleBiFunction<Double, Double> calculation;

    OperatorCalculation(ToDoubleBiFunction<Double, Double> calculation) {
        this.calculation = calculation;
    }

    public Double doCalculation(Double leftOperand, Double rightOperand) {
        return calculation.applyAsDouble(leftOperand, rightOperand);
    }
}
