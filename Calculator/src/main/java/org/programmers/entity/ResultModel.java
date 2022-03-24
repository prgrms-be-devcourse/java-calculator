package org.programmers.entity;

public class ResultModel {
    Long id;
    String inputEx;
    double result;

    public ResultModel(Long id, String inputEx, double result) {
        this.id = id;
        this.inputEx = inputEx;
        this.result = result;
    }
}
