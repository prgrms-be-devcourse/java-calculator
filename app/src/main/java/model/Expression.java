package model;

public class Expression {

    private final String input;
    private final Double result;

    public Expression(String input, Double result) {
        this.input = input;
        this.result = result;
    }

    public String getInput() {
        return input;
    }

    public Double getResult() {
        return result;
    }
}
