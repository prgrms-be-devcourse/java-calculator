package calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum OperatorType {

    PLUS("+", Double::sum, 1),
    MINUS("-", (firstNumber, secondNumber) -> firstNumber - secondNumber, 1),
    MULTIPLY("*", (firstNumber, secondNumber) -> firstNumber * secondNumber, 2),
    DIVIDE("/", (firstNumber, secondNumber) -> {
        if (secondNumber == 0) {
            throw new IllegalArgumentException("[ERROR] 0으로 나눌 수 없습니다. 다시 입력해주세요.");
        }
        return firstNumber / secondNumber;
    }, 3);

    private final String operator;
    private final BinaryOperator<Double> expression;
    private final int value;

    OperatorType(String operator, BinaryOperator<Double> expression, int value) {
        this.operator = operator;
        this.expression = expression;
        this.value = value;
    }

    public static OperatorType from(String operator) {
        return Arrays.stream(OperatorType.values())
            .filter(type -> type.operator.equals(operator))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("[ERROR] 연산자가 아닙니다. 다시 입력해주세요."));
    }

    public int getValue() {
        return value;
    }

    public double calculate(double firstNumber, double secondNumber) {
        return expression.apply(firstNumber, secondNumber);
    }
}
