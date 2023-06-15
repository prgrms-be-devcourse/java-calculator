package example.calculator.model.operation;

public interface CalculationOperation {
    double calculate(double a, double b);

    String getOperator();
}
