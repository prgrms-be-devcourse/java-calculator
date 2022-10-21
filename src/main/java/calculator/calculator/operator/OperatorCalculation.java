package calculator.calculator.operator;

import java.util.function.ToDoubleBiFunction;

public enum OperatorCalculation {

    PLUS("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    MINUS("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLY("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVIDE("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String operator;
    private final ToDoubleBiFunction<Double, Double> calculation;

    OperatorCalculation(String operator, ToDoubleBiFunction<Double, Double> calculation) {
        this.operator = operator;
        this.calculation = calculation;
    }

    public Double calculate(String leftOperand, String rightOperand) {
        return calculation.applyAsDouble(
                Double.parseDouble(leftOperand),
                Double.parseDouble(rightOperand)
        );
    }
}
