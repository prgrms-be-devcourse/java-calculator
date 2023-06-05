package calulator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {

    ADDITION("+", (leftOperand, rightOperand) -> leftOperand + rightOperand),
    SUBTRACTION("-", (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLICATION("*", (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVISION("/", (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final String value;
    private final BiFunction<Integer, Integer, Integer> calculateFunction;

    Operation(String value, BiFunction<Integer, Integer, Integer> calculateFunction) {
        this.value = value;
        this.calculateFunction = calculateFunction;
    }

    public static boolean isPriority(String value) {
        return value.equals(MULTIPLICATION.value) || value.equals(DIVISION.value);
    }

    public static boolean isNonePriority(String value) {
        return value.equals(ADDITION.value) || value.equals(SUBTRACTION.value);
    }

    public static int operator(String operation, int leftOperand, int rightOperand) {
        return findOperator(operation)
                .calculateFunction.apply(leftOperand, rightOperand);
    }

    private static Operation findOperator(String operation) {
        return Arrays.stream(values())
                .filter(o -> o.value.equals(operation))
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사용할 수 없는 연산자입니다."));
    }

}
