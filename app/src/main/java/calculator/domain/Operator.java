package calculator.domain;

import calculator.exception.DividedByZeroException;
import calculator.exception.IllegalOperatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION((a, b) -> a + b, 2),
    SUBTRACTION((a, b) -> a - b, 2),
    MULTIPLICATION((a, b) -> a * b, 1),
    DIVISION((a, b) -> {
        if (b == 0) throw new DividedByZeroException();
        return a / b;
    }, 1);

    private static final Map<Character, Operator> operators
            = new HashMap<>() {
        {
            put('+', ADDITION);
            put('-', SUBTRACTION);
            put('*', MULTIPLICATION);
            put('/', DIVISION);
        }
    };

    private int priority;
    private BiFunction<Integer, Integer, Integer> expression;

    Operator(BiFunction<Integer, Integer, Integer> expression, int priority) {
        this.expression = expression;
        this.priority = priority;
    }

    public static Operator getOperator(char operator) {
        if (!operators.containsKey(operator)) throw new IllegalOperatorException();
        return operators.get(operator);
    }

    public static int getPriority(char operator) {
        if ('(' == operator || operator == ')') return Integer.MAX_VALUE;
        else if (!operators.containsKey(operator)) throw new IllegalOperatorException();
        return operators.get(operator).priority;
    }

    public int calculate(int a, int b) {
        return expression.apply(a, b);
    }
}
