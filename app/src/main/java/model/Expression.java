package model;

public class Expression {

    private final Long id;
    private final String input;
    private final Double result;

    public Expression(Long id, String input, Double result) {
        this.id = id;
        this.input = input;
        this.result = result;
    }

    public String getExpressionWithResult() {
        return input + " = " + String.valueOf(result);
    }

    public Long getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public Double getResult() {
        return result;
    }
}
