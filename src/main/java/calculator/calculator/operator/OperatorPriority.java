package calculator.calculator.operator;

public enum OperatorPriority {

    PLUS_PRIORITY(1),
    MINUS_PRIORITY(1),
    MULTIPLY_PRIORITY(2),
    DIVIDE_PRIORITY(2);

    private final Integer priority;

    OperatorPriority(Integer priority) {
        this.priority = priority;
    }

    public static boolean isLeftSameOrMoreImportantThanRight(Integer leftPriority, Integer rightPriority) {
        return leftPriority >= rightPriority;
    }

    public Integer findPriority() {
        return priority;
    }

}
