package com.programmers.java.engine.model;

public class Expression {
    private StringBuffer expression;

    public Expression(String expression) {
        this.expression = new StringBuffer(expression);
    }

    public String get() {
        return expression.toString();
    }

    public void add(String str) {
        expression.append(str);
    }

    @Override
    public String toString() {
        return this.get();
    }
}
