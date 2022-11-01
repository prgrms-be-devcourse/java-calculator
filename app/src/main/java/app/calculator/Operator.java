package app.calculator;

import app.exception.DivideByZeroException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (operand1, operand2) -> operand1 + operand2),
    MINUS("-", 1, (operand1, operand2) -> operand1 - operand2),
    MULTIPLY("*", 2, (operand1, operand2) -> operand1 * operand2),
    DIVIDE("/", 2, (operand1, operand2) -> operand1 / operand2);

    private final String signature;
    private final Integer priority;
    private final BiFunction<Integer, Integer, Integer> operation;

    Operator(String signature, Integer priority, BiFunction<Integer, Integer, Integer> operation) {
        this.signature = signature;
        this.priority = priority;
        this.operation = operation;
    }

    public static Integer calculate(String inputSignature, int operand1, int operand2) {
        Operator operator = findOperator(inputSignature);
        if (DIVIDE.checkDivideByZero(operator, operand2)) throw new DivideByZeroException();
        return operator.operation.apply(operand1, operand2);
    }

    private static Operator findOperator(String inputSignature) {
        return Arrays.stream(values())
                .filter(operator -> operator.isSameSignatureInput(inputSignature))
                .findAny()
                .get();
    }

    private boolean isSameSignatureInput(String inputSignature) {
        return signature.equals(inputSignature);
    }

    private boolean checkDivideByZero(Operator operator, int operand2) {
        return operator == Operator.DIVIDE && operand2 == 0;
    }

    public static Integer findPriority(String inputSignature) {
        return findOperator(inputSignature).getPriority();
    }

    private Integer getPriority() {
        return priority;
    }
}
