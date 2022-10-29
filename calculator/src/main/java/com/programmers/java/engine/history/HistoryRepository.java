package com.programmers.java.engine.history;

import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.EquationRecord;

public interface HistoryRepository {
    void save(Equation equation);

    EquationRecord findAll();
}
