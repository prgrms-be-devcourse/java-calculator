package hyuk.calculator;

import java.util.function.BiFunction;

public enum Operator {
    PLUS((a, b) -> a + b),
    MINUS((a, b) -> a - b),
    DIVIDE((a, b) -> {
        if (b == 0) {
            throw new IllegalStateException("0으로 나눌 수 없습니다.");
        }
        return a / b;
    }),
    MULTIPLY((a, b) -> a * b);

    private final BiFunction<Integer, Integer, Integer> biFunction;

    Operator(BiFunction<Integer, Integer, Integer> biFunction) {
        this.biFunction = biFunction;
    }

    public Integer calculate(int firstOperand, int secondOperand) {
        return this.biFunction.apply(firstOperand, secondOperand);
    }

}
