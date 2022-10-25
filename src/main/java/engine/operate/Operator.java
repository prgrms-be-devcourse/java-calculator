package engine.operate;

import engine.exception.NotValidInputException;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (n1, n2) -> n1 + n2), MINUS("-", 1, (n1, n2) -> n1 - n2), MULTIPLY("*", 2, (n1, n2) -> n1 * n2), DIVIDE("/", 2, (n1, n2) -> {
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
        return exp.equals(PLUS.operator) || exp.equals(MINUS.operator) || exp.equals(MULTIPLY.operator) || exp.equals(DIVIDE.operator);
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(Operator.values()).filter(o -> o.operator.equals(operator)).findFirst().get();

    }

    public double calculate(double n1, double n2) {
        return expression.apply(n1, n2);
    }

    public int getPriority() {
        return priority;
    }
}
