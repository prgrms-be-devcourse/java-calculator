package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Expression {
    private String problem;
    private String answer;

    @Override
    public String toString(){
        return problem + " = " + answer;
    }
}
