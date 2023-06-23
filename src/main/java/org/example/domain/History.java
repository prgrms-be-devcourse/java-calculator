package org.example.domain;

import java.util.ArrayList;
import java.util.List;

public class History implements HistoryInterface {
    private final List<String> history = new ArrayList<>();

    @Override
    public void save(String infixExpression, Integer result) {
        history.add(String.format("%s = %d", infixExpression, result));
    }

    @Override
    public List<String> getHistories() {
        return new ArrayList<>(history);
    }
}
