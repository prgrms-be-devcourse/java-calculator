package calculator.engine;

import calculator.constant.ErrorMessage;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculatorEngine {

    ADD("+", (o1, o2) -> o1 + o2),
    SUB("-", (o1, o2) -> o1 - o2),
    MUL("*", (o1, o2) -> o1 * o2),
    DIV("/", (o1, o2) -> {
        if (o2 == 0) {
            throw new ArithmeticException(ErrorMessage.DIVISION_BY_ZERO);
        }
        return o1 / o2;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> handler;

    CalculatorEngine(String operator, BiFunction<Integer, Integer, Integer> handler) {
        this.operator = operator;
        this.handler = handler;
    }

    public static Optional<Integer> execute(int o1, int o2, String operator) {
        return findEngine(operator)
                .map(engine -> engine.handler.apply(o1, o2));
    }

    private static Optional<CalculatorEngine> findEngine(String symbol) {
        return Arrays.stream(values())
                .filter(engine -> engine.operator.equals(symbol))
                .findFirst();
    }
}
