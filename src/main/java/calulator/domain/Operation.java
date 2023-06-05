package calulator.domain;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operation {

    ADDITION('+', (leftOperand, rightOperand) -> leftOperand + rightOperand),
    SUBTRACTION('-', (leftOperand, rightOperand) -> leftOperand - rightOperand),
    MULTIPLICATION('*', (leftOperand, rightOperand) -> leftOperand * rightOperand),
    DIVISION('/', (leftOperand, rightOperand) -> leftOperand / rightOperand);

    private final char value;
    private final BiFunction<Integer, Integer, Integer> calculateFunction;

    Operation(char value, BiFunction<Integer, Integer, Integer> calculateFunction) {
        this.value = value;
        this.calculateFunction = calculateFunction;
    }

    public static int operator(char operation, int leftOperand, int rightOperand) {
        return findOperator(operation)
                .calculateFunction.apply(leftOperand, rightOperand);
    }

    private static Operation findOperator(char operation) {
        return Arrays.stream(values())
                .filter(o -> o.value == operation)
                .findFirst().orElseThrow(() -> new IllegalArgumentException("사용할 수 없는 연산자입니다."));
    }

}
