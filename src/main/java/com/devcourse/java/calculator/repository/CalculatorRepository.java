package com.devcourse.java.calculator.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorRepository {

    private final List<String> history = new ArrayList<>();

    public void storeHistory(String equationWithAnswer) {
        this.history.add(equationWithAnswer);
    }

    public List<String> getHistory() {
        return Collections.unmodifiableList(history);
    }
}
