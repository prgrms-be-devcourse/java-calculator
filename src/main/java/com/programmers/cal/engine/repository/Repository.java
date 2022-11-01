package com.programmers.cal.engine.repository;

import com.programmers.cal.engine.model.Equation;
import com.programmers.cal.engine.model.Record;

public interface Repository {
    void save(Equation equation);

    Record findAll();
}
