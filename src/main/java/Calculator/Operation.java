package Calculator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

@Getter
@RequiredArgsConstructor
public enum Operation{
    ADD("+", (num1, num2) -> num1 + num2),
    MINUS("-", (num1, num2) -> num1 - num2),
    MUL("*", (num1, num2) -> num1 * num2),
    DIV("/", (num1, num2) -> num1 / num2);

    private final String symbol;
    private final BiFunction<Long, Long, Long> expression;
    private static final Map<String, Operation> map = new HashMap<>();

    static {
        Operation[] operations = Operation.values();
        for (Operation op : operations) {
            map.put(op.symbol, op);
        }
    }

    public long calc(long num1, long num2) {
        return expression.apply(num1, num2);
    }

    public static Operation getOperation(String symbol) {
        return map.get(symbol);
    }

}
