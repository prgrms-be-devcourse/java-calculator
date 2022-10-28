package calculator.domain;

import calculator.exception.DividedByZeroException;
import calculator.exception.IllegalOperatorException;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public enum Operator {
    ADDITION((a, b) -> a + b),
    SUBTRACTION((a, b) -> a - b),
    MULTIPLICATION((a, b) -> a * b),
    DIVISION((a, b) -> {
        if (b == 0) throw new DividedByZeroException();
        return a / b;
    });

    private static final Map<Character, Operator> operators
            = new HashMap<>() {
        {
            put('+', ADDITION);
            put('-', SUBTRACTION);
            put('*', MULTIPLICATION);
            put('/', DIVISION);
        }
    };

    private BiFunction<Integer, Integer, Integer> expression;

    Operator(BiFunction<Integer, Integer, Integer> expression) {
        this.expression = expression;
    }

    public static Operator getOperator(char operator) {
        if(!operators.containsKey(operator)) throw new IllegalOperatorException();
        return operators.get(operator);
    }

    public int calculate(int a, int b) {
        return expression.apply(a, b);
    }
}
