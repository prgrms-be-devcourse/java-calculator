package constant;

import java.util.Arrays;
import java.util.function.BiFunction;

import static controller.CalculatorController.INVALID_MENU;
import static model.calculation.CalculationImpl.ZERO_DIVIDE;

public enum Operator {
    PLUS("+", 1, Integer::sum),
    MINUS("-", 1, (operand1, operand2) -> operand2 - operand1),
    MULTIPLY("*", 2, (operand1, operand2) -> operand2 * operand1),
    DIVIDE("/", 2, (operand1, operand2) -> {
        if (operand1 == 0) {
            throw new ArithmeticException(ZERO_DIVIDE);
        }
        return operand2 / operand1;
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

    public static Integer calculateArithmetic(Operator operator, Integer operand1, Integer operand2) {
        return operator.operation.apply(operand1, operand2);
    }

    public static Operator findOperator(String signature) {
        return Arrays.stream(values())
                .filter(operator -> operator.signature.equals(signature))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU));
    }
}
