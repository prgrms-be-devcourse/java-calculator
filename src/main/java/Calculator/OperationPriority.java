package Calculator;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum OperationPriority {
    ADD(Operation.ADD, 1),
    MINUS(Operation.MINUS, 1),
    MUL(Operation.MUL, 2),
    DIV(Operation.DIV, 2);

    private final Operation operation;
    private final int priority;

    public static int getPriorityByOperation(Operation operation) {
        return Arrays.stream(OperationPriority.values())
                .filter(operationPriority -> operationPriority.getOperation().equals(operation))
                .findFirst()
                .get().getPriority();
    }

    public static boolean compareByOperation(Operation operation1, Operation operation2) {
        return getPriorityByOperation(operation1) < getPriorityByOperation(operation2);
    }
}
