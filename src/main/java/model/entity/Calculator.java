package model.entity;

import model.vo.CalculationResult;
import model.vo.Expression;

public class Calculator {
    private Long id;
    private Expression expression;
    private CalculationResult calculationResult;

    public Calculator(Expression expression, CalculationResult calculationResult) {
        this.expression = expression;
        this.calculationResult = calculationResult;
    }

    public Long getId() {
        return id;
    }

    public Expression getExpression() {
        return expression;
    }

    public CalculationResult getCalculationResult() {
        return calculationResult;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
