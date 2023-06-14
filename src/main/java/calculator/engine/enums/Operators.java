package calculator.engine.enums;
public enum Operators {
    PLUS('+'),MINUS('-'),DIVISION('/'),MULTIPLICATION('*');

    private final char operator;

    Operators(char operator) {
        this.operator = operator;
    }
}