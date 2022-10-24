package engine.operate;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (n1, n2) -> n1 + n2),
    MINUS("-", 1, (n1, n2) -> n1 - n2),
    MULTIPLY("*", 2, (n1, n2) -> n1 * n2),
    DIVIDE("/", 2, (n1, n2) -> n1 / n2),;

    private String operator;
    private int priority;
    private BiFunction<Double, Double, Double> expression;

    Operator(String operator, int priority, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public double calculate(double n1, double n2) {
        return expression.apply(n1, n2);
    }

    public static boolean isOperator(String exp) {
        if(exp.equals(PLUS.operator) || exp.equals(MINUS.operator) || exp.equals(MULTIPLY.operator) || exp.equals(DIVIDE.operator)){
            return true;
        }

        return false;
    }

    public int getPriority() {
        return priority;
    }

    public static Operator getOperator(String operator) {
        return Arrays.stream(Operator.values())
                .filter(o -> o.operator.equals(operator))
                .findFirst().get();

    }
}
