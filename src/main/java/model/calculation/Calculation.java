package model.calculation;

import java.util.List;

public interface Calculation {
    default int plus(int number1, int number2) {
        return number1 + number2;
    }

    default int minus(int number1, int number2) {
        return number1 - number2;
    }

    default int multiply(int number1, int number2) {
        return number1 * number2;
    }

    default int divide(int number1, int number2) {
        return number1 / number2;
    }

    int calculate(List<String> postfixExpression);
}
