package engine;

import java.util.*;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (num1, num2) -> num1 + num2),
    MINUS("-", 1, (num1, num2) -> num1 - num2),
    MULTIPLY("*", 2, (num1, num2) -> num1 * num2),
    DIVIDE("/", 2, (num1, num2) ->
    {
        double answer = num1 / num2;
        if (isRealNumber(answer)) {
            return answer;
        } else {
            throw new ArithmeticException();
        }
    });

    private final String operator;
    private final int priority;
    private final BiFunction<Double, Double, Double> expression;

    Operator(String operator, int priority, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.priority = priority;
        this.expression = expression;
    }

    public double calculate(double num1, double num2) throws ArithmeticException {
        return expression.apply(num1, num2);
    }

    //일치하는 enum return
    public static Operator getOperator(String oper) {
        return Arrays.stream(values())
                .filter(o -> o.isEqualsOperator(oper))
                .findFirst().orElseThrow(()
                        -> new IllegalArgumentException());
    }

    public int comparePriority(Operator op) {
        int x = this.priority;
        int y = op.priority;
        return Integer.compare(x, y);
    }

    private boolean isEqualsOperator(String oper) {
        return this.operator.equals(oper);
    }

    public static boolean isRealNumber(double answer) {
        return Double.isFinite(answer) && !Double.isNaN(answer);
    }
}
