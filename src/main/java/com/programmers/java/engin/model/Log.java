package com.programmers.java.engin.model;


public class Log {

    private String expression;
    private String result;

    public Log(String expression, String result) {
        this.expression = expression;
        this.result = result;
    }

    public String getLog(){
        return expression + " = " + result;
    }

}
