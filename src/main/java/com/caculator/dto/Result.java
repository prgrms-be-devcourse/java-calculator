package com.caculator.dto;

public class Result {
    private String exp;
    private int result;

    public Result(String exp, int result) {
        this.exp = exp;
        this.result = result;
    }

    @Override
    public String toString() {
        return exp + " = " + result;
    }
}
