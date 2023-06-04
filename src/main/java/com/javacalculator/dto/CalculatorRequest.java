package com.javacalculator.dto;

import java.util.List;

public class CalculatorRequest {

    private String expression;
    private List<Integer> operands;
    private List<String> operators;

    public CalculatorRequest(String expression, List<Integer> operands, List<String> operators) {
        this.expression = expression;
        this.operands = operands;
        this.operators = operators;
    }

    public String getExpression() {
        return expression;
    }

    public List<Integer> getOperands() {
        return operands;
    }

    public List<String> getOperators() {
        return operators;
    }
}
