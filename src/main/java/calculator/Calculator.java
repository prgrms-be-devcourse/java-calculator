package calculator;

public class Calculator implements Operator {
    private static final String PLUS = "+";
    private static final String MINUS = "-";
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String ERROR_NOT_OPERAND = "[ERROR] 연산자가 아닙니다. 다시 입력해주세요.";

    public double calculate(String operator, double numberOne, double numberTwo) {
        if (operator.equals(PLUS)) {
            return add(numberOne, numberTwo);
        }

        if (operator.equals(MINUS)) {
            return subtract(numberOne, numberTwo);
        }

        if (operator.equals(MULTIPLY)) {
            return multiply(numberOne, numberTwo);
        }

        if (operator.equals(DIVIDE)) {
            return divide(numberOne, numberTwo);
        }

        throw new IllegalArgumentException(ERROR_NOT_OPERAND);
    }
}
