package calculator.calculator.operator;

import java.util.function.ToDoubleBiFunction;

public enum OperatorCalculation {

    PLUS_CALCULATOR((leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS_CALCULATOR((leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY_CALCULATOR((leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE_CALCULATOR((leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final ToDoubleBiFunction<Double, Double> calculation;

    OperatorCalculation(ToDoubleBiFunction<Double, Double> calculation) {
        this.calculation = calculation;
    }

    public Double doCalculation(Double leftOperand, Double rightOperand) {
        return calculation.applyAsDouble(leftOperand, rightOperand);
    }
}
