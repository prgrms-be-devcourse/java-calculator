package calculator.strategy;

public class MinusStrategy implements CalculatorStrategy {
    @Override
    public Double calculate(double a, double b) {
        return a - b;
    }
}
