package com.programmers.java.engine;

import com.programmers.java.engine.model.Equation;

import java.util.List;

public interface HistoryRepository {
    void save(Equation equation);

    List<Equation> findAll();
}
