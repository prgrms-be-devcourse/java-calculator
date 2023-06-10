package org.example.engine.model;

import lombok.ToString;

@ToString
public class CalculationResult {
    private String expression;
    private Double result;
    public CalculationResult( String expression, Double result) {
        this.expression = expression;
        this.result = result;
    }
    public void printInfo(){
        System.out.printf("%s = ", this.expression, this.result);
    }
}
