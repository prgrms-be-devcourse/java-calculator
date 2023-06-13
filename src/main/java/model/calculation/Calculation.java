package model.calculation;

import model.vo.CalculationResult;

import java.util.List;

public interface Calculation {
    default int plus(int number1, int number2) {
        return number2 + number1;
    }

    default int minus(int number1, int number2) {
        return number2 - number1;
    }

    default int multiply(int number1, int number2) {
        return number2 * number1;
    }

    default int divide(int number1, int number2) {
        return number2 / number1;
    }

    CalculationResult calculate(List<String> postfixExpression);
}
