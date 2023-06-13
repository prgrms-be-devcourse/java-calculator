package calculator.engine;

import calculator.constant.ErrorMessage;

import java.util.Arrays;
import java.util.Optional;

public enum CalculatorEngine {

    ADD("+", (o1, o2) -> o1 + o2),
    SUB("-", (o1, o2) -> o1 - o2),
    MUL("*", (o1, o2) -> o1 * o2),
    DIV("/", (o1, o2) -> {
        if (o2 != 0) {
            return o1 / o2;
        }
        throw new ArithmeticException(ErrorMessage.DIVISION_BY_ZERO);
    });

    private String operator;
    private OperationHandler handler;

    CalculatorEngine(String operator, OperationHandler handler) {
        this.operator = operator;
        this.handler = handler;
    }

    public static Optional<Integer> execute(int o1, int o2, String operator) {
        return Arrays.stream(values())
                .filter(engine -> engine.operator.equals(operator))
                .findFirst()
                .map(engine -> engine.handler.operate(o1, o2));
    }
}
