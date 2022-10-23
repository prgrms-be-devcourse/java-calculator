package calculator.operation;

import java.util.Arrays;

public enum Operation {

    PLUS("+", Priority.FIRST, (first, second) -> first + second),
    MINUS("-", Priority.FIRST, (first, second) -> first - second),
    DIVIDE("/", Priority.SECOND, (first, second) -> {
        if (second == 0) {
            throw new ArithmeticException();
        }
        return first / second;
    }),
    MULTIPLY("*", Priority.SECOND, (first, second) -> first * second),
    ;

    private final String operator;
    private final Priority priority;
    private final CalculateFunction<Double> calculateFunction;


    Operation(String operator, Priority priority, CalculateFunction<Double> calculateFunction) {
        this.operator = operator;
        this.priority = priority;
        this.calculateFunction = calculateFunction;
    }

    public static Operation getOperator(String operator) {
        return Arrays.stream(Operation.values())
                .filter(a -> a.operator.equals(operator))
                .findAny()
                .orElseThrow();

    }

    public Priority getPriority() {
        return priority;
    }

    public double calculate(double first, double second) {
        return calculateFunction.apply(first, second);
    }
}


