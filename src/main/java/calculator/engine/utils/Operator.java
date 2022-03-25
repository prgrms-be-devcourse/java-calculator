package calculator.engine.utils;

import java.util.function.BiFunction;

public enum Operator {
    DIVISION('/', 0, (a, b) -> a / b),
    MULTIPLY('*', 0, (a, b) -> a * b),
    ADD('+', 1, (a, b) -> a + b),
    MINUS('-', 1, (a, b) -> a - b);

    private final Character sign;
    private final int order;
    private final BiFunction<Double, Double, Double> function;

    Operator(Character sign, int order, BiFunction<Double, Double, Double> function) {
        this.sign = sign;
        this.order = order;
        this.function = function;
    }

    public double exec(double a, double b) {
        return this.function.apply(a, b);
    }

    public Character getSign() {
        return this.sign;
    }

    public int getOrder() {
        return this.order;
    }
}
