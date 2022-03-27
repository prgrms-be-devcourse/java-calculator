package calculator;

public enum OPERATOR {
    PLUS("+"), MINUS("-"),MULTIPLY("*"),DIVIED("/");

    private final String value;
    OPERATOR(String value) {
        this.value = value;
    }

    public String getValue() {return this.value;}
}
