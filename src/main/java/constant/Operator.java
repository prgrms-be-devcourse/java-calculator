package constant;

import java.util.Arrays;
import java.util.function.BiFunction;

import static controller.CalculatorController.INVALID_MENU;
import static model.calculation.CalculationImpl.ZERO_DIVIDE;

public enum Operator {
    PLUS("+", 1, Integer::sum),
    MINUS("-", 1, (now, prev) -> prev - now),
    MULTIPLY("*", 2, (now, prev) -> prev * now),
    DIVIDE("/", 2, (now, prev) -> {
        if (now == 0) {
            throw new ArithmeticException(ZERO_DIVIDE);
        }
        return prev / now;
    });

    private final String signature;
    private final int priority;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String signature, int priority, BiFunction<Integer, Integer, Integer> operation) {
        this.signature = signature;
        this.priority = priority;
        this.operation = operation;
    }

    public String getSignature() {
        return signature;
    }

    public int getPriority() {
        return priority;
    }

    public static boolean isOperator(String textSegment) {
        return Arrays.stream(values())
                    .map(Operator::getSignature)
                    .anyMatch(textSegment::equals);
    }

    public static Integer calculateArithmetic(Operator operator, Integer now, Integer prev) {
        return operator.operation.apply(now, prev);
    }

    public static Operator findOperator(String signature) {
        return Arrays.stream(values())
                .filter(operator -> operator.signature.equals(signature))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU));
    }
}
