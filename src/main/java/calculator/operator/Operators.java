package calculator.operator;

public enum Operators {
    PLUS("+"),
    MINUS("-"),
    MULTIPLICATION("*"),
    DIVISION("/");

    private final String operators;

    Operators(String operators) {
        this.operators = operators;
    }
}
