package calculator.strategy;

public class PlusStrategy implements CalculatorStrategy {
    @Override
    public Double calculate(double a, double b) {
        return a + b;
    }

}
