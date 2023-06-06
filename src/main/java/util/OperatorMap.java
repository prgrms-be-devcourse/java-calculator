package util;

public enum OperatorMap {
    MINUS("-"),
    PLUS("+"),
    MUL("*"),
    DIV("/");

    private final String operator;

    OperatorMap(String operator) {
        this.operator = operator;
    }

    public static boolean contains(String operator) {
        for (OperatorMap oper : OperatorMap.values()) {
            if (operator.equals(oper.operator)) {
                return true;
            }
        }
        return false;
    }

}
