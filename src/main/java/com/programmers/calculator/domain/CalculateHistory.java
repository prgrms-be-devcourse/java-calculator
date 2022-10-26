package com.programmers.calculator.domain;

import com.programmers.calculator.util.DecimalUtil;

public class CalculateHistory {

    private Long id;

    private String history;

    private String expression;

    private Number result;

    public CalculateHistory(String expression, Number result) {
        this.expression = expression;
        this.result = result;
        this.history = expression + " = " + DecimalUtil.formatToString(result);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHistory() {
        return history;
    }

    public Long getId() {
        return id;
    }

    public Number getResult() {
        return this.result;
    }

}
