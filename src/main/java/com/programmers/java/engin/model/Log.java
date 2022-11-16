package com.programmers.java.engin.model;


public class Log {

    private InputExpression expression;
    private String result;

    public Log(InputExpression expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    public String getLog(){
        return expression.getExpression() + " = " + result;
    }

}
