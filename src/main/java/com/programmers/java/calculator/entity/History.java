package com.programmers.java.calculator.entity;

public class History {

    private Long id;
    private String expression;

    public History(String expression) {
        this.expression = expression;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
