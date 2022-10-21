package calculator.calculator.operator;

import java.util.Arrays;
import java.util.Optional;

public enum OperatorPriority {

    PLUS_PRIORITY("+", 1),
    MINUS_PRIORITY("-", 1),
    MULTIPLY_PRIORITY("*", 2),
    DIVIDE_PRIORITY("/", 2);

    private final String operator;
    private final Integer priority;

    OperatorPriority(String operator, Integer priority) {
        this.operator = operator;
        this.priority = priority;
    }

    public static OperatorPriority findOperator(String inputOperator) {
        return findOptionalOperator(inputOperator)
                .orElseThrow(() -> new NullPointerException());
    }

    public boolean isSameOrMoreImportantThan(String inputOperator) {
        return priority >= findPriority(inputOperator);
    }

    private Integer findPriority(String inputOperator) {
        return findOptionalOperator(inputOperator)
                .orElseThrow(() -> new NullPointerException())
                .priority;
    }

    private static Optional<OperatorPriority> findOptionalOperator(String inputOperator) {
        return Arrays.stream(OperatorPriority.values())
                .filter(operator -> operator.operator.equals(inputOperator))
                .findFirst();
    }
}
