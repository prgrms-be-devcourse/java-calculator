package com.programmers.java.engine;

import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.History;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HistoryInMemoryInterface implements HistoryRepository{

    private History history = new History();

    @Override
    public void save(Equation equation) {
        history.addEquation(equation.getExpression(), equation.getAnswer());
    }

    @Override
    public List<Equation> findAll() {
        ArrayList<Equation> equationList = new ArrayList<>();

        for (Map.Entry<String, Answer> equation : history.getEquations().entrySet()) {
            equationList.add(
                    Equation.builder()
                            .expression(equation.getKey())
                            .answer(equation.getValue())
                            .build()
            );
        }

        return equationList;
    }
}
