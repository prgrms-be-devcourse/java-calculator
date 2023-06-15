package example.calculator.model.operation;

public class Multiplication implements CalculationOperation {
    @Override
    public double calculate(double a, double b) {
        return a * b;
    }

    @Override
    public String getOperator() {
        return "*";
    }
}
