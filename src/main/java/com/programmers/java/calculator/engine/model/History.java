package com.programmers.java.calculator.engine.model;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class History {
    //TODO : 조회 기능시 사용될 History 클래스 만들기
    private String formula;
    private Integer result;

    public String show() {
        return formula + " = " + result;
    }
}
