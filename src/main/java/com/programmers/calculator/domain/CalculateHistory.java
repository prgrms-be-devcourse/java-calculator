package com.programmers.calculator.domain;

import com.programmers.calculator.util.DecimalUtil;

public class CalculateHistory {

    private final Long id;

    private final String history;

    private final String expression;

    private final Number result;

    public CalculateHistory(Long id, String expression, Number result) {
        this.id = id;
        this.expression = expression;
        this.result = result;
        this.history = expression + " = " + DecimalUtil.formatToString(result);
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
