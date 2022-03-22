package com.programmers.entity;

public class CaseData {
    private Long id;
    private String input;
    private Double result;

    public CaseData(Long id, String input, Double result) {
        this.id = id;
        this.input = input;
        this.result = result;
    }

    public String getInputAndResultString(){
        return input + " = " + String.valueOf(result);
    }

    public Long getId() {
        return id;
    }

    public String getInput() {
        return input;
    }

    public Double getResult() {
        return result;
    }
}
