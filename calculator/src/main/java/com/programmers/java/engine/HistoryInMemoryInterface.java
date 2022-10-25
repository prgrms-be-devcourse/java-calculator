package com.programmers.java.engine;

import com.programmers.java.engine.model.Answer;
import com.programmers.java.engine.model.Equation;
import com.programmers.java.engine.model.History;

import java.util.Map;

public class HistoryInMemoryInterface implements HistoryRepository{

    private History history = new History();

    @Override
    public void save(Equation equation) {
        history.addEquation(equation.getExpression(), equation.getAnswer());
    }

    @Override
    public String findAll() {
        StringBuilder stringBuilder = new StringBuilder("\n");

        for (Map.Entry<String, Answer> equation : history.getEquations().entrySet()) {
            if (history.checkInt(equation.getValue())) {
                stringBuilder.append(equation.getKey()).append(" = ").append(equation.getValue().getValue().intValue()).append("\n");
            } else {
                stringBuilder.append(equation.getKey()).append(" = ").append(equation.getValue()).append("\n");
            }
        }

        return stringBuilder.toString();
    }
}
