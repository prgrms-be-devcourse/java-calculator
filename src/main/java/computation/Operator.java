package computation;

import exception.ZeroDivisionException;
import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {
    ADD("+", (num1, num2) -> num1 + num2),
    SUBTRACT("-", (num1, num2) -> num1 - num2),
    MULTIPLY("*", (num1, num2) -> num1 * num2),
    DIVIDE("/", (num1, num2) -> {
        if (num2 == 0)
            throw new ZeroDivisionException();
        return num1 / num2;
    });

    private final String operator;
    private final BiFunction<Integer, Integer, Integer> expression;

    Operator(String operator, BiFunction<Integer, Integer, Integer> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static Operator getOperator(String getString) {
        return Arrays.stream(Operator.values())
                .filter(s -> s.operator.equals(getString))
                .findFirst()
                .get();
    }

    public int operate(Integer num1, Integer num2) {
        return expression.apply(num1, num2);
    }
}
