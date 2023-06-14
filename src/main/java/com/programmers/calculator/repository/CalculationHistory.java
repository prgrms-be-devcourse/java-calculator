package com.programmers.calculator.repository;

import java.math.BigDecimal;

public class CalculationHistory {

    private Long id = 0L;
    private String expression;
    private BigDecimal result;

    public CalculationHistory(String expression, BigDecimal result) {
        this.expression = expression;
        this.result = result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return id + " : " + expression + " = " + result;
    }
}
