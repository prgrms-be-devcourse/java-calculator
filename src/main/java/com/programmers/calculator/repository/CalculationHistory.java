package com.programmers.calculator.repository;

import com.programmers.calculator.domain.vo.CalculationResult;
import com.programmers.calculator.domain.vo.Expression;

public class CalculationHistory {

    private Long id = 0L;
    private Expression expression;
    private CalculationResult result;

    public CalculationHistory(Expression expression, CalculationResult result) {
        this.expression = expression;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CalculationHistory saveHistory() {
        return this;
    }
}
