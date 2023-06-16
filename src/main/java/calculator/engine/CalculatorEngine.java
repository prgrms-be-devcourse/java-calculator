package calculator.engine;

import calculator.constant.ErrorMessage;
import calculator.constant.Operator;

import java.util.Arrays;
import java.util.Optional;
import java.util.function.BiFunction;

public enum CalculatorEngine {

    ADD(Operator.ADD, (o1, o2) -> o1 + o2),
    SUB(Operator.SUB, (o1, o2) -> o1 - o2),
    MUL(Operator.MUL, (o1, o2) -> o1 * o2),
    DIV(Operator.DIV, (o1, o2) -> {
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
        return Arrays.stream(values())
                .filter(engine -> engine.operator.equals(operator))
                .findFirst()
                .map(engine -> engine.handler.apply(o1, o2));
    }
}
