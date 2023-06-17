package org.example.domain;

import java.util.List;

public interface HistoryInterface {
    void save(String infixExpression, Integer result);

    List<String> getHistory();
}
