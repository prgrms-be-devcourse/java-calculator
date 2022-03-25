package calculator;

public class Calculator {

    public double calculate(String operator, double firstNumber, double secondNumber) {
        return OperatorType.from(operator)
            .calculate(firstNumber, secondNumber);
    }
}
