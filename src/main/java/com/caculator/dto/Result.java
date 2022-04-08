package com.caculator.dto;

public class Result {
    private String exp;
    private long result;

    public Result(String exp, long result) {
        this.exp = exp;
        this.result = result;
    }

    @Override
    public String toString() {
        return exp + " = " + result;
    }
}
