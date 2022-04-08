package Calculator;

import Config.EnumInterface;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

@RequiredArgsConstructor
@Getter
public enum OperationPriority implements EnumInterface {
    ADD("+", 1),
    MINUS("-", 1),
    MUL("*", 2),
    DIV("/", 2);

    private final String type;
    private final int priority;

    public static int getPriorityByOperation(String type) {
        return EnumInterface.find(type, values()).getPriority();
    }

    public static boolean compareByOperation(Operation operation1, Operation operation2) {
        return getPriorityByOperation(operation1.getType()) < getPriorityByOperation(operation2.getType());
    }
}
