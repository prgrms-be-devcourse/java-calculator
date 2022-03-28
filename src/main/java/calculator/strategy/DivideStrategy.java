package calculator.strategy;

public class DivideStrategy implements CalculatorStrategy {
    @Override
    public Double calculate(double a, double b) {return a / b;}
}
