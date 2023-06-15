package model.entity;

public class Calculator {
    private Long id;
    private String expression;
    private int calculationResult;

    public Calculator(String expression, int calculationResult) {
        this.expression = expression;
        this.calculationResult = calculationResult;
    }

    public Long getId() {
        return id;
    }

    public String getExpression() {
        return expression;
    }

    public int getCalculationResult() {
        return calculationResult;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
