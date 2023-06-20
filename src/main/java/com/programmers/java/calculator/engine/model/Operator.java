package com.programmers.java.calculator.engine.model;

public enum Operator {
    PLUS(1),
    MINUS(1),
    MULTIPLY(2),
    DIVIDE(2),
    NOTHING(-1);

    private int priority;

    Operator(int priority) {
        this.priority = priority;
    }

    static public int getPriority(char c){
        switch (c){
            case '+':
                return Operator.PLUS.priority;
            case '-':
                return Operator.MINUS.priority;
            case '*':
                return Operator.MULTIPLY.priority;
            case '/':
                return Operator.DIVIDE.priority;
            default:
                return Operator.NOTHING.priority;
        }
    }

}
