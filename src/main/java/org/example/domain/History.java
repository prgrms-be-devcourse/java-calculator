package org.example.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class History {
    private final List<String> history = new ArrayList<>();

    public void save(String infixExpression, Integer result) {
        history.add(String.format("%s = %d", infixExpression, result));
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}
