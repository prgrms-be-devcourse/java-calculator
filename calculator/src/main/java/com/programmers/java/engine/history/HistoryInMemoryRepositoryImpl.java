package com.programmers.java.engine.history;

import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.EquationRecord;
import com.programmers.java.engine.model.History;

public class HistoryInMemoryRepositoryImpl implements HistoryRepository{

    private History history = new History();

    @Override
    public Equation save(Equation equation) {
        if (history.isNew(equation)) {
            history.addEquation(equation.getExpression(), equation.getAnswer());
        }

        return equation;
    }

    @Override
    public EquationRecord findAll() {
        return EquationRecord.builder()
                .record(history.mapToList())
                .build();
    }
}
