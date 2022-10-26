package calculator.engine.calculator;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.BinaryOperator;

public enum ArithmeticOperator {
    ADDITION("+", OperatorPriority.SECOND, (firstOperand, secondOperand) -> firstOperand + secondOperand),
    SUBTRACTION("-", OperatorPriority.SECOND, (firstOperand, secondOperand) -> firstOperand - secondOperand),
    MULTIPLICATION("*", OperatorPriority.FIRST, (firstOperand, secondOperand) -> firstOperand * secondOperand),
    DIVISION("/", OperatorPriority.FIRST, (firstOperand, secondOperand) -> {
        try {
            return firstOperand / secondOperand;
        } catch (ArithmeticException exception) {
            throw new ArithmeticException();
        }
    });

    private final String symbol;
    private final OperatorPriority priority;
    private final BinaryOperator<Integer> operation;

    ArithmeticOperator(String symbol, OperatorPriority priority, BinaryOperator<Integer> operation) {
        this.symbol = symbol;
        this.priority = priority;
        this.operation = operation;
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

    public Integer calculate(Integer firstOperand, Integer secondOperand) {
        return this.operation.apply(firstOperand, secondOperand);
    }
}
