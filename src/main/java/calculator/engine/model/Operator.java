package calculator.engine.model;

import java.util.Optional;
import java.util.function.BiFunction;

public enum Operator {
    PLUS("+", (a, b) -> (a + b)),
    MINUS("-", (a, b) -> (a - b)),
    MULTIPLY("*", (a, b) -> (a * b)),
    DIVIDE("/", (a, b) -> (a / b));

    private final String symbol;
    private final BiFunction<Double, Double, Double> biFunction;

    Operator(String symbol, BiFunction<Double, Double, Double> biFunction) {
        this.symbol = symbol;
        this.biFunction = biFunction;
    }

    public Double calculate(double a, double b) {
        return this.biFunction.apply(a, b);
    }

    public String getSymbol() {
        return symbol;
    }

    public static Optional<Operator> getOperator(String symbol) {
        if (symbol.equals("+")) return Optional.of(Operator.PLUS);
        else if (symbol.equals("-")) return Optional.of(Operator.MINUS);
        else if (symbol.equals("*")) return Optional.of(Operator.MULTIPLY);
        else if (symbol.equals("/")) return Optional.of(Operator.DIVIDE);
        else return Optional.empty();       // "("인 경우
    }

    // 연산자인지 아닌지 확인
    public static boolean isOperator(String s) {
        for (Operator type : Operator.values()) {
            if (s.equals(type.symbol)) return true;
        }
        return false;
    }

    // 우선순위 비교
    public int comparePriority(Operator operator) {
        if (operator instanceof Operator)
            return this.getPriority() - operator.getPriority();
        else return 1;
    }

    // 우선순위 반환
    public int getPriority() {
        // +, -인 경우 1 반환
        if (this.equals(Operator.PLUS) || this.equals(Operator.MINUS))
            return 1;
            // *, /인 경우 2 반환
        else
            return 2;
    }
}

