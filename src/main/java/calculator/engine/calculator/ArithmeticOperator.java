package calculator.engine.calculator;

public enum ArithmeticOperator {
    ADDITION("+", OperatorPriority.SECOND),
    SUBTRACTION("-", OperatorPriority.SECOND),
    MULTIPLICATION("*", OperatorPriority.SECOND),
    DIVISION("/", OperatorPriority.SECOND);

    private final String symbol;
    private final OperatorPriority priority;

    ArithmeticOperator(String symbol, OperatorPriority priority) {
        this.symbol = symbol;
        this.priority = priority;
    }
}
