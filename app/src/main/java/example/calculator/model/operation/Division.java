package example.calculator.model.operation;

public class Division implements CalculationOperation {
    @Override
    public double calculate(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            throw new IllegalArgumentException("Cannot divide by zero.");
        }
    }

    @Override
    public String getOperator() {
        return "/";
    }
}
