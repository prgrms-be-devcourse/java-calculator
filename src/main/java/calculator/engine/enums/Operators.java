package calculator.engine.enums;
public enum Operators {
    PLUS("+"),MINUS("-"),DIVISION("/"),MULTIPLICATION("*");
    public final String operator;
    Operators(String operator) {
        this.operator = operator;
    }
}