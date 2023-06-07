package calculator.service;

import calculator.domain.Calculator;

import java.util.List;

public class CalculatorService {
    public CalculatorService() {}

    public double calculate(String userInput) {
        Calculator calculator = new Calculator(userInput);
        return calculator.getResult();
    }

    public List<String> getCalculateList() {
        return null;
    }
}
