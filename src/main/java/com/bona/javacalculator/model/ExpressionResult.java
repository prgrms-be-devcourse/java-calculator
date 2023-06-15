package com.bona.javacalculator.model;

public class ExpressionResult {
    private Long id;
    private String input;
    private Double answer;

    public ExpressionResult(String input, Double answer) {
        this.input = input;
        this.answer = answer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Double getAnswer() {
        return answer;
    }

}
