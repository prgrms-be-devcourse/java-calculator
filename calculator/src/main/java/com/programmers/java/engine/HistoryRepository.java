package com.programmers.java.engine;

import com.programmers.java.engine.model.Equation;

public interface HistoryRepository {
    void save(Equation equation);

    String findAll();
}
