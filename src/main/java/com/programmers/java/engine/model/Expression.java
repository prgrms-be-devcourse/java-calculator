package com.programmers.java.engine.model;

import lombok.AllArgsConstructor;

/*
 * Expression : 계산 이력 하나를 나타내는 데이터 구조
 * */
@AllArgsConstructor
public class Expression {
    private String problem;
    private String answer;

    @Override
    public String toString() {
        return problem + " = " + answer;
    }
}
