package calculator.engine.calculator;

public enum OperatorPriority {
    FIRST(1),
    SECOND(2);

    private final int priority;

    OperatorPriority(int priority) {
        this.priority = priority;
    }
}
