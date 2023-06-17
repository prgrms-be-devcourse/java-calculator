package org.example.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class History {
    private List<String> history = new ArrayList<>();


    void save(String infixExpression, Integer result) {
        history.add(String.format("%s = %d", infixExpression, result));
    }

    public List<String> getHistory() {
        return new ArrayList<>(history);
    }
}
