package Calculator;

import Config.EnumInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.function.BiFunction;

@Getter
@RequiredArgsConstructor
public enum Operation implements EnumInterface {
    ADD("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private final String type;
    private final BiFunction<Long, Long, Long> expression;

    public long calc(long num1, long num2) {
        return expression.apply(num1, num2);
    }

    public static Operation getOperation(String type) {
        return EnumInterface.find(type, values());
    }

}
