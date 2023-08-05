package programmers.java.calulator.common.operator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (a, b) -> a + b, 1),
    SUBTRACT("-", (a, b) -> a - b, 1),
    MULTIPLY("*", (a, b) -> a * b, 2),
    DIVIDE("/", (a, b) -> {
        if (b == 0) {
            throw new ArithmeticException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }, 2);

    private final String symbol;
    private final BiFunction<Integer, Integer, Integer> calculation;
    private final int priority;

    Operator(String symbol, BiFunction<Integer, Integer, Integer> calculation, int priority) {
        this.symbol = symbol;
        this.calculation = calculation;
        this.priority = priority;
    }

    public static Operator of(String symbol) {
        return Arrays.stream(values())
                .filter(operator -> operator.symbol.equals(symbol))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 입력: 정수에 대한 +, -, *, / 연산만 가능합니다."));
    }

    public int calculate(int a, int b) {
        return calculation.apply(a, b);
    }

    public boolean isHighPriority(Operator other) {
        return this.priority > other.priority;
    }
}


