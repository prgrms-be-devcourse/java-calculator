package calculator.engine.calculator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.NoSuchElementException;

public enum ArithmeticOperator {
    ADDITION("+", OperatorPriority.SECOND),
    SUBTRACTION("-", OperatorPriority.SECOND),
    MULTIPLICATION("*", OperatorPriority.FIRST),
    DIVISION("/", OperatorPriority.FIRST);

    private final String symbol;
    private final OperatorPriority priority;

    ArithmeticOperator(String symbol, OperatorPriority priority) {
        this.symbol = symbol;
        this.priority = priority;
    }

    public static boolean isOperator(String target) {
        return Arrays.stream(ArithmeticOperator.values())
                .map(operator -> operator.symbol)
                .anyMatch(symbol -> symbol.equals(target));
    }

    public static ArithmeticOperator toOperator(String target) {
        return Arrays.stream(ArithmeticOperator.values())
                .filter(operator -> operator.symbol.equals(target))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    public boolean hasSamePriorityOrPrecede(ArithmeticOperator other) {
        return this.priority.compareTo(other.priority) <= Integer.parseInt(String.valueOf(BigInteger.ZERO));
    }

    public String getSymbol() {
        return symbol;
    }
}
