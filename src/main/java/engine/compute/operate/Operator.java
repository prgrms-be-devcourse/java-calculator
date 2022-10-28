package engine.compute.operate;

import engine.exception.NotValidInputException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (n1, n2) -> n1 + n2),
    MINUS("-", 1, (n1, n2) -> n1 - n2),
    MULTIPLY("*", 2, (n1, n2) -> n1 * n2),
    DIVIDE("/", 2, (n1, n2) -> {
        if (n2 == 0) throw new NotValidInputException("0으로 나눌 수 없습니다.");
        return n1 / n2;
    });

    private final String operator;
    private final int priority;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, int priority, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public static boolean isOperator(String exp) {
        return Arrays.stream(Operator.values())
                .anyMatch(operatorElement -> operatorElement.operator.equals(exp));
    }

    public static Operator getOperator(String operatorString) {
        return Arrays.stream(values())
                .filter(operatorEnum -> operatorEnum.operator.equals(operatorString))
                .findFirst()
                .get();

    }

    public double calculate(double operand1, double operand2) {
        return expression.apply(operand1, operand2);
    }

    public int getPriority() {
        return priority;
    }
}
