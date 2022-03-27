package calculator;

public enum OPERATOR {
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

    public String getValue() {return this.value;}

    static public int getPriority(String operator) {
        if (PLUS.getValue() == operator) return PLUS.priority;
        if (MINUS.getValue() == operator) return MINUS.priority;
        if (MULTIPLY.getValue() == operator) return MULTIPLY.priority;
        if (DIVIED.getValue() == operator) return DIVIED.priority;
        return -1;
    }
}
