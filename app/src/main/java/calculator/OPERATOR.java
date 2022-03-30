package calculator;

public enum Operator {
    PLUS("+", 0),
    MINUS("-", 0),
    MULTIPLY("*", 1),
    DIVIED("/", 1);

    private final String value;
    private final int priority;

    OPERATOR(String value, int priority) {
        this.value = value;
        this.priority = priority;
    }

    public String getValue() {
        return this.value;
    }

    static public int getPriority(String operator) {
        if (PLUS.getValue().equals(operator)) return PLUS.priority;
        if (MINUS.getValue().equals(operator)) return MINUS.priority;
        if (MULTIPLY.getValue().equals(operator)) return MULTIPLY.priority;
        if (DIVIED.getValue().equals(operator)) return DIVIED.priority;
        return -1;
    }

    static public boolean isOperator(String operator) {
        for (Operator op : Operator.values()) {
            if (op.getValue().equals(operator)) return true;
        }
        return false;
    }
}
