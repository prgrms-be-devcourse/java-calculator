package com.devcourse.java.calculator.repository;

import lombok.Getter;

import java.util.LinkedHashMap;

@Getter
public class CalculatorRepository {

    private Integer historyNumber = 0;
    private final LinkedHashMap<Integer, String> history = new LinkedHashMap<>();

    public void storeHistory(String equationWithAnswer) {
        this.history.put(historyNumber++, equationWithAnswer);
    }
}
