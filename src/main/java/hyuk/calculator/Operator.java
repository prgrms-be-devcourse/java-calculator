package hyuk.calculator;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public enum Operator {
    PLUS("+", (firstOperand, secondOperand) -> firstOperand + secondOperand),
    MINUS("-", (firstOperand, secondOperand) -> firstOperand - secondOperand),
    DIVIDE("/", (firstOperand, secondOperand) -> {
        if (secondOperand == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
        return firstOperand / secondOperand;
    }),
    MULTIPLY("*", (firstOperand, secondOperand) -> firstOperand * secondOperand);

    private final String textOperator;
    private final BinaryOperator<Integer> binaryOperator;

    Operator(final String textOperator, final BinaryOperator<Integer> binaryOperator) {
        this.textOperator = textOperator;
        this.binaryOperator = binaryOperator;
    }

    public static Operator of(final String symbol) {
        return Arrays.stream(values())
            .filter(operator -> operator.isTextOperator(symbol))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("해당 연산자를 찾을 수 없습니다."));
    }

    private boolean isTextOperator(String symbol) {
        return textOperator.equals(symbol);
    }

    public Integer apply(int firstOperand, int secondOperand) {
        return binaryOperator.apply(firstOperand, secondOperand);
    }
}
