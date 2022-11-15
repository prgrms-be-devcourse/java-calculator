package com.programmers.java.engine.model;

// 의미론적으로 클래스 추가
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
