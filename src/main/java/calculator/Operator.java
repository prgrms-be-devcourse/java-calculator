package calculator;

public interface Operator {

    String ERROR_DIVIDE = "[ERROR] 0으로 나눌 수 없습니다. 다시 입력해주세요.";

    default double add(double numberOne, double numberTwo) {
        return numberOne + numberTwo;
    }

    default double subtract(double numberOne, double numberTwo) {
        return numberOne - numberTwo;
    }

    default double multiply(double numberOne, double numberTwo) {
        return numberOne * numberTwo;
    }

    default double divide(double numberOne, double numberTwo) {
        if (numberTwo == 0) {
            throw new IllegalArgumentException(ERROR_DIVIDE);
        }
        return numberOne / numberTwo;
    }

}
