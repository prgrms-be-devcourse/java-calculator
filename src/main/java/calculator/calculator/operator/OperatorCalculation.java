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

    public Double doCalculation(String leftOperand, String rightOperand) {
        return calculation.applyAsDouble(
                Double.parseDouble(leftOperand),
                Double.parseDouble(rightOperand)
        );
    }
}
