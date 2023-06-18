package com.programmers.calculator.repository;

import com.programmers.calculator.model.Expression;

import java.util.ArrayList;
import java.util.List;

public class HistoryRepository{
    List<String> history;
    List<Integer> resultHistory;

    public HistoryRepository() {
        this.history = new ArrayList<>();
        this.resultHistory = new ArrayList<>();
    }

    public void save(Expression data, int result) {
        history.add(data.toString());
        resultHistory.add(result);
    }
    public void printHistory() {
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i) + " = " + resultHistory.get(i));
        }
        System.out.println();
    }
}
