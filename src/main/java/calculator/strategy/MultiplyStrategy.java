package calculator.strategy;

public class MultiplyStrategy implements CalculatorStrategy {
    @Override
    public Double calculate(double a, double b) {
        return a * b;
    }

}
