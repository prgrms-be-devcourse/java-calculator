package com.programmers.java.engine.history;

import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.History;

import java.util.List;

public class HistoryInMemoryInterface implements HistoryRepository{

    private History history = new History();

    @Override
    public void save(Equation equation) {
        history.addEquation(equation.getExpression(), equation.getAnswer());
    }

    @Override
    public List<Equation> findAll() {
        List<Equation> equationList = history.mapToList();

        return equationList;
    }
}
