package calculator;

import calculator.domain.OperatorType;

public class Calculator {

    public double calculate(String operator, double firstNumber, double secondNumber) {
        return OperatorType.from(operator)
            .calculate(firstNumber, secondNumber);
    }
}
