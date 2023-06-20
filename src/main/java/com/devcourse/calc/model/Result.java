package com.devcourse.calc.model;

public class Result {

    private int result;

    public Result() {
    }

    public Result(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return String.valueOf(result);
    }
}
