package com.programmers.dto;

public class CalculatorDto {
    private String expression; //식
    private int answer; //값

    public CalculatorDto(String expression, int answer){
        this.expression  = expression;
        this.answer = answer;
    }

    public String getExpression(){
        return this.expression;
    }

    public int getAnswer(){
        return this.answer;
    }
}
