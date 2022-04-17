package calculator.engine.model;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", 1, (a, b) -> (a + b)),
    MINUS("-", 1, (a, b) -> (a - b)),
    MULTIPLY("*", 2, (a, b) -> (a * b)),
    DIVIDE("/", 2, (a, b) -> (a / b));

    private final String symbol;
    private final int priority;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String symbol, int priority, BiFunction<Double, Double, Double> biFunction) {
        this.symbol = symbol;
        this.priority = priority;
        this.biFunction = biFunction;
    }

    public Double calculate(double a, double b) {
        return this.biFunction.apply(a, b);
    }

    public static Optional<Operator> getOperator(String symbol) {
        return Optional.ofNullable(
                Arrays.stream(Operator.values())
                        .filter(operator -> operator.symbol.equals(symbol))
                        .findAny()
                        .orElse(null)
        );
    }

    // 연산자인지 아닌지 확인
    public static boolean isOperator(String token) {
        return Arrays.stream(Operator.values())
                .anyMatch(operator -> operator.symbol.equals(token));
    }

    // 우선순위 비교
    public int comparePriority(Optional<Operator> operator) {
        if (operator.isPresent()) {
            return this.priority - operator.get().priority;
        } else {
            return 1;
        }
    }

}

