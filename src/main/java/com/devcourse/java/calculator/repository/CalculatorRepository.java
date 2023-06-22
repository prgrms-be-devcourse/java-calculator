package com.devcourse.java.calculator.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculatorRepository {

    private final List<History> historyStorage = new ArrayList<>();

    public void storeHistory(History history) {
        this.historyStorage.add(history);
    }

    public List<History> getHistory() {
        return Collections.unmodifiableList(historyStorage);
    }
}
