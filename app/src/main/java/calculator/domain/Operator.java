package calculator.domain;

import calculator.exception.DividedByZeroException;
import calculator.exception.InvalidOperatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION((a, b) -> a + b, Priority.LOW_PRIORITY),
    SUBTRACTION((a, b) -> a - b, Priority.LOW_PRIORITY),
    MULTIPLICATION((a, b) -> a * b, Priority.HIGH_PRIORITY),
    DIVISION((a, b) -> {
        if (b == 0) throw new DividedByZeroException();
        return a / b;
    }, Priority.HIGH_PRIORITY);

    private static final Map<Character, Operator> operators
            = new HashMap<>() {
        {
            put('+', ADDITION);
            put('-', SUBTRACTION);
            put('*', MULTIPLICATION);
            put('/', DIVISION);
        }
    };

    private Priority priority;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(BiFunction<Integer, Integer, Integer> expression, Priority priority) {
        this.expression = expression;
        this.priority = priority;
    }

    public static Operator getOperator(char operator) {
        if (!operators.containsKey(operator)) throw new InvalidOperatorException();
        return operators.get(operator);
    }

    public static int getPriority(char operator) {
        if ('(' == operator || operator == ')') return Integer.MAX_VALUE;
        else if (!operators.containsKey(operator)) throw new InvalidOperatorException();
        return operators.get(operator).priority.order;
    }

    public int calculate(int a, int b) {
        return expression.apply(a, b);
    }

    public enum Priority {
        HIGH_PRIORITY(1),
        LOW_PRIORITY(2);

        private final int order;

        Priority(int order) {
            this.order = order;
        }
    }
}
