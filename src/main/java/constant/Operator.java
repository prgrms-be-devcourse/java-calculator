package constant;

import java.util.Arrays;

public enum Operator {
    PLUS("+", 1),
    MINUS("-", 1),
    MULTIPLY("*", 2),
    DIVIDE("/", 2);

    private final String signature;
    private final int priority;

    Operator(String signature, int priority) {
        this.signature = signature;
        this.priority = priority;
    }

    public String getSignature() {
        return signature;
    }

    public int getPriority() {
        return priority;
    }

    public static Operator findOperator(String signature) {
        return Arrays.stream(values())
                .filter(operator -> operator.equals(signature))
                .findAny()
                .get();
    }


}
